package cl.duoc.playlist.user.mapper;

import cl.duoc.playlist.user.dto.UserRequest;
import cl.duoc.playlist.user.dto.UserResponse;
import cl.duoc.playlist.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    User toEntity(UserRequest request);

    UserResponse toResponse(User user);

    List<UserResponse> toResponseList(List<User> users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    void updateEntity(UserRequest request, @MappingTarget User user);
}