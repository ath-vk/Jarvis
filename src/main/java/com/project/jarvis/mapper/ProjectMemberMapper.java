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

    MemberResponse toProjectMemberResponseFromProjectMember(ProjectMember projectMember);

}
