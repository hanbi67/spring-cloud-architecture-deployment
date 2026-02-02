package com.example.cloudarchitecturedeployment.member.exception;

import com.example.cloudarchitecturedeployment.common.exception.CustomException;
import com.example.cloudarchitecturedeployment.common.exception.ErrorCode;

public class MemberNotFoundException extends CustomException {
    public MemberNotFoundException() {
        super(ErrorCode.MEMBER_NOT_FOUND);
    }

    public MemberNotFoundException(Long id) {
        super(ErrorCode.MEMBER_NOT_FOUND, String.format("ID %d에 해당하는 팀원 정보가 존재하지 않습니다", id));
    }
}
