package local.learnspring.service;

import local.learnspring.dto.request.UserCreationRequest;
import local.learnspring.dto.request.UserUpdateRequest;
import local.learnspring.dto.response.UserResponse;
import local.learnspring.entity.User;
import local.learnspring.mapper.UserMapper;
import local.learnspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request){
        User user = userMapper.toEntity(request);
        return userMapper.toResponse(userRepository.save(user));
    }

    public List<UserResponse> findAll(){
        return userRepository.findAll().stream()
                .map(userMapper::toResponse)
                .toList();
    }

    public UserResponse getUserById(String id){
        return userMapper.toResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("id is not exists")));
    }

    public UserResponse updateUser(String id, UserUpdateRequest request){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("id is not exists"));
        userMapper.update(request,user);
        userRepository.save(user);
        return userMapper.toResponse(user);
    }

    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }
}
