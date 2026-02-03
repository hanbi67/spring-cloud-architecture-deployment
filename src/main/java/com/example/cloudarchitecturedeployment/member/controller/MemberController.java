package com.example.cloudarchitecturedeployment.member.controller;

import com.example.cloudarchitecturedeployment.member.dto.*;
import com.example.cloudarchitecturedeployment.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@Slf4j
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 팀원 정보 저장
    @PostMapping
    public ResponseEntity<CreateMemberResponse> saveMember(@Valid @RequestBody CreateMemberRequest request) {
        CreateMemberResponse response = memberService.saveMember(request);
        log.info("[API - LOG] 팀원 저장: name={}, age={}, mbti_type={}", response.getName(), response.getAge(), response.getMbti_type());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 팀원 조회
    @GetMapping("/{id}")
    public ResponseEntity<SearchMemberResponse> searchMember(@PathVariable Long id) {
        SearchMemberResponse response = memberService.getOne(id);
        log.info("[API - LOG] 팀원 조회: id={}, name={}, age={}, mbti_type={}", response.getId(), response.getName(), response.getAge(), response.getMbti_type());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 프로필 이미지 업로드
    @PostMapping("/{id}/profile-image")
    public ResponseEntity<UploadImageFileResponse> upload(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        String key = memberService.upload(id, file);
        log.info("[API - LOG] 프로필 이미지 업로드: id={}, key={}", id, key);
        return ResponseEntity.ok(new UploadImageFileResponse(key));
    }

    // 프로필 이미지 Presigned URL 조회
    @GetMapping("/{id}/profile-image")
    public ResponseEntity<FileDownloadUrlResponse> getDownloadUrl(@PathVariable Long id) {
        URL url = memberService.getDownloadUrl(id);
        log.info("[API - LOG] 프로필 이미지 Presigned URL 조회: id={}, url={}", id, url.toString().replaceAll("https://", ""));
        return ResponseEntity.ok(new FileDownloadUrlResponse(url.toString()));
    }

}
