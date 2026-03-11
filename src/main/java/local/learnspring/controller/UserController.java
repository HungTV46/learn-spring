package local.learnspring.controller;

import jakarta.validation.Valid;
import local.learnspring.dto.request.UserCreationRequest;
import local.learnspring.dto.request.UserUpdateRequest;
import local.learnspring.dto.response.ApiResponse;
import local.learnspring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    ApiResponse<?> create(@RequestBody @Valid UserCreationRequest request){
        return ApiResponse.builder()
                .result((userService.create(request)))
                .build();
    }

    @GetMapping
    ApiResponse<?> fillAll(){
        return ApiResponse.builder()
                .result(userService.findAll())
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<?> getById(@PathVariable String id){
        return ApiResponse.builder()
                .result(userService.getById(id))
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<?> update(@PathVariable String id, @RequestBody UserUpdateRequest request){
        return ApiResponse.builder()
                .result(userService.update(id, request))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<?> delete(@PathVariable String id){
        userService.deleteById(id);
        return ApiResponse.builder()
                .message("Delete successfully")
                .build();
    }
}
