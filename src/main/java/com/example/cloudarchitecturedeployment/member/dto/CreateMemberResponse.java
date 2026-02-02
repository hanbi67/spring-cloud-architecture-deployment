package com.example.cloudarchitecturedeployment.member.dto;

import lombok.Getter;

@Getter
public class CreateMemberResponse {
    private final Long id;
    private final String name;
    private final Integer age;
    private final String mbti_type;

    private CreateMemberResponse(Long id, String name, Integer age, String mbti_type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mbti_type = mbti_type;
    }

    public static CreateMemberResponse register(Long id, String name, Integer age, String mbti_type) {
        return new CreateMemberResponse(id, name, age, mbti_type);
    }

}
