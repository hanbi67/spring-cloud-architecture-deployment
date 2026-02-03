package com.example.cloudarchitecturedeployment.member.exception;

import com.example.cloudarchitecturedeployment.common.exception.CustomException;
import com.example.cloudarchitecturedeployment.common.exception.ErrorCode;

public class FileUploadFailedException extends CustomException {
    public FileUploadFailedException() {
        super(ErrorCode.FILE_UPLOAD_FAILED);
    }

    public FileUploadFailedException(Throwable cause) {
        super(ErrorCode.FILE_UPLOAD_FAILED, "파일 업로드 중 오류가 발생했습니다: " + cause.getMessage());
    }
}
