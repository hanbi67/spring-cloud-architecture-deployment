package com.example.cloudarchitecturedeployment.member.repository;

import com.example.cloudarchitecturedeployment.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
}
