package com.project.jarvis.mapper;

import com.project.jarvis.dto.member.MemberResponse;
import com.project.jarvis.entity.ProjectMember;
import com.project.jarvis.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target="userId", source="id")
    @Mapping(target="projectRole", constant= "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "name", source = "user.name")
    MemberResponse toProjectMemberResponseFromProjectMember(ProjectMember projectMember);

}
