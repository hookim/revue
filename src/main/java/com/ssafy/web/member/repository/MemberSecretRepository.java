package com.ssafy.web.member.repository;

import com.ssafy.web.member.model.MemberSecret;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberSecretRepository extends JpaRepository<MemberSecret, String> {
}
