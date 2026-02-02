package com.example.cloudarchitecturedeployment.member.dto;

import lombok.Getter;

@Getter
public class UploadImageFileResponse {
    private final String key;

    public UploadImageFileResponse(String key) {
        this.key = key;
    }
}
