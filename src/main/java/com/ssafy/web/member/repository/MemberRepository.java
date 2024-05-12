package com.ssafy.web.member.repository;

import com.ssafy.web.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
