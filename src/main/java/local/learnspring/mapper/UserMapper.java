package local.learnspring.mapper;

import local.learnspring.dto.request.UserCreationRequest;
import local.learnspring.dto.request.UserUpdateRequest;
import local.learnspring.dto.response.UserResponse;
import local.learnspring.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserCreationRequest userCreationRequest);
    UserResponse toResponse(User user);

    @Mapping(target = "id",  ignore = true)
    void update(UserUpdateRequest request, @MappingTarget User user);
}
