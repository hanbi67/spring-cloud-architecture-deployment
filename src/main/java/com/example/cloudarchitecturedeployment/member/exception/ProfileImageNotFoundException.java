package com.example.cloudarchitecturedeployment.member.exception;

import com.example.cloudarchitecturedeployment.common.exception.CustomException;
import com.example.cloudarchitecturedeployment.common.exception.ErrorCode;

public class ProfileImageNotFoundException extends CustomException {
    public ProfileImageNotFoundException() {
        super(ErrorCode.PROFILE_IMAGE_NOT_FOUND);
    }

    public ProfileImageNotFoundException(Long id) {
        super(ErrorCode.PROFILE_IMAGE_NOT_FOUND,
                String.format("ID %d 팀원의 프로필 이미지가 등록되지 않았습니다", id));
    }
}
