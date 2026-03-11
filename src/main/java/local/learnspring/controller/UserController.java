package local.learnspring.controller;

import local.learnspring.dto.request.UserCreationRequest;
import local.learnspring.dto.request.UserUpdateRequest;
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
    ResponseEntity<?> createUser(@RequestBody UserCreationRequest request){
        return ResponseEntity.ok(userService.createUser(request));
    }

    @GetMapping
    ResponseEntity<?> fillAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getUserById(@PathVariable String id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserUpdateRequest request){
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable String id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("Delete successfully");
    }
}
