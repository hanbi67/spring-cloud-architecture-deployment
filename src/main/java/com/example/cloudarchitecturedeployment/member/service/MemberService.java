package com.example.cloudarchitecturedeployment.member.service;

import com.example.cloudarchitecturedeployment.member.dto.CreateMemberRequest;
import com.example.cloudarchitecturedeployment.member.dto.CreateMemberResponse;
import com.example.cloudarchitecturedeployment.member.dto.SearchMemberResponse;
import com.example.cloudarchitecturedeployment.member.entity.Member;
import com.example.cloudarchitecturedeployment.member.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 팀원 정보 저장
    @Transactional
    public CreateMemberResponse saveMember(@Valid CreateMemberRequest request) {
        Member member = Member.register(request.getName(), request.getAge(), request.getMbti_type());
        Member savedMember = memberRepository.save(member);
        return CreateMemberResponse.register(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getAge(),
                savedMember.getMbti_type()
        );
    }

    // 팀원 정보 조회
    @Transactional(readOnly = true)
    public SearchMemberResponse getOne(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("팀원 정보가 존재하지 않습니다")
        );
        return SearchMemberResponse.regiser(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti_type()
        );
    }
    

}
