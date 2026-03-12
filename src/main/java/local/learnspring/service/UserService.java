package local.learnspring.service;

import local.learnspring.dto.request.UserCreationRequest;
import local.learnspring.dto.request.UserUpdateRequest;
import local.learnspring.dto.response.UserResponse;
import local.learnspring.entity.User;
import local.learnspring.exception.AppException;
import local.learnspring.exception.ErrorCode;
import local.learnspring.mapper.UserMapper;
import local.learnspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse create(UserCreationRequest request){
        if (userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toEntity(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userMapper.toResponse(userRepository.save(user));
    }

    public List<UserResponse> findAll(){
        return userRepository.findAll().stream()
                .map(userMapper::toResponse)
                .toList();
    }

    public UserResponse getById(String id){
        return userMapper.toResponse(userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    public UserResponse update(String id, UserUpdateRequest request){
        User user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        userMapper.update(request,user);
        userRepository.save(user);
        return userMapper.toResponse(user);
    }

    public void deleteById(String id){
        userRepository.deleteById(id);
    }
}
