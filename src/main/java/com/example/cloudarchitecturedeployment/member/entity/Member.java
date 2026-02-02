package com.example.cloudarchitecturedeployment.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String mbti_type;

    private String profileImageUrl;

    public static Member register(String name, Integer age, String mbti_type) {
        Member member = new Member();
        member.name = name;
        member.age = age;
        member.mbti_type = mbti_type;
        return member;
    }

    // 프로필 이미지 URL 업데이트
    public void updateProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
