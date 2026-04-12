package com.project.jarvis.service;

import com.project.jarvis.dto.member.InviteMemberRequest;
import com.project.jarvis.dto.member.MemberResponse;
import com.project.jarvis.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);
    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);
    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);
    void removeProjectMember(Long projectId, Long memberId);
}
