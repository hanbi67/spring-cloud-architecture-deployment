package com.example.cloudarchitecturedeployment.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Member Errors
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_001", "팀원 정보가 존재하지 않습니다"),
    MEMBER_NAME_REQUIRED(HttpStatus.BAD_REQUEST, "MEMBER_002", "이름 입력이 필요합니다"),
    MEMBER_AGE_REQUIRED(HttpStatus.BAD_REQUEST, "MEMBER_003", "나이 입력이 필요합니다"),
    MEMBER_MBTI_REQUIRED(HttpStatus.BAD_REQUEST, "MEMBER_004", "MBTI 입력이 필요합니다"),

    // S3 File Errors
    FILE_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "FILE_001", "파일 업로드에 실패했습니다"),
    PROFILE_IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "FILE_002", "프로필 이미지가 등록되지 않았습니다");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
