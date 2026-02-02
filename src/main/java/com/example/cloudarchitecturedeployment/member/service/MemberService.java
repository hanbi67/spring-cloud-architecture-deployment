package com.example.cloudarchitecturedeployment.member.service;

import com.example.cloudarchitecturedeployment.member.dto.CreateMemberRequest;
import com.example.cloudarchitecturedeployment.member.dto.CreateMemberResponse;
import com.example.cloudarchitecturedeployment.member.dto.SearchMemberResponse;
import com.example.cloudarchitecturedeployment.member.entity.Member;
import com.example.cloudarchitecturedeployment.member.exception.MemberNotFoundException;
import com.example.cloudarchitecturedeployment.member.repository.MemberRepository;
import io.awspring.cloud.s3.S3Template;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // Presigned URL의 유효기간 설정
    private static final Duration PRESIGNED_URL_EXPIRATION = Duration.ofDays(7);
    private final S3Template s3Template;

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;

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
                () -> new MemberNotFoundException()
        );
        return SearchMemberResponse.regiser(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti_type()
        );
    }

    // 프로필 사진 업로드
    @Transactional
    public String upload(Long id, MultipartFile file) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new MemberNotFoundException()
        );
        try {
            String key = "uploads/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
            s3Template.upload(bucket, key, file.getInputStream());
            member.updateProfileImageUrl(key);
            return key;
        } catch (IOException e) {
            // 적절한 커스텀 예외로 바꾸고, GlobalExceptionHandler로 핸들링 필요
            throw new RuntimeException("파일 업로드 실패", e);
        }
    }

    // 프로필 사진 URL 다운로드
    @Transactional(readOnly = true)
    public  URL getDownloadUrl(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new MemberNotFoundException()
        );
        return s3Template.createSignedGetURL(bucket, member.getProfileImageUrl(), PRESIGNED_URL_EXPIRATION);
    }

}
