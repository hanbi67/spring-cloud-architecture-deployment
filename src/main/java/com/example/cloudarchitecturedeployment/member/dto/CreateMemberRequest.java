package com.example.cloudarchitecturedeployment.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateMemberRequest {
    @NotBlank(message = "이름 입력이 필요합니다")
    private String name;

    @NotNull(message = "나이 입력이 필요합니다")
    private Integer age;

    @NotBlank(message = "MBTI 입력이 필요합니다")
    private String mbti_type;
}
