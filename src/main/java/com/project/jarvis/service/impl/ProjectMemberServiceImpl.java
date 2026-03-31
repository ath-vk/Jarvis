package com.project.jarvis.service.impl;

import com.project.jarvis.dto.member.InviteMemberRequest;
import com.project.jarvis.dto.member.MemberResponse;
import com.project.jarvis.dto.member.UpdateMemberRoleRequest;
import com.project.jarvis.entity.Project;
import com.project.jarvis.mapper.ProjectMemberMapper;
import com.project.jarvis.repository.ProjectMemberRepository;
import com.project.jarvis.repository.ProjectRepository;
import com.project.jarvis.service.ProjectMemberService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    ProjectMemberMapper projectMemberMapper;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = projectRepository.findAccessibleProjectsById(projectId, userId).orElseThrow();

        List<MemberResponse> memberResponseList = new ArrayList<>();
        memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));

        memberResponseList.addAll(projectMemberRepository.findByIdProjectId(projectId).stream().map(projectMemberMapper::toProjectMemberResponseFromProjectMember).toList());

        return memberResponseList;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }

}
