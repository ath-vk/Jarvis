package com.project.jarvis.mapper;


import com.project.jarvis.dto.auth.SignupRequest;
import com.project.jarvis.dto.auth.UserProfileResponse;
import com.project.jarvis.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(SignupRequest signupRequest);
    UserProfileResponse toUserProfileResponse(User user);
}
