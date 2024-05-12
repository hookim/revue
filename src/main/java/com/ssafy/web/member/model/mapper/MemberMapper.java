package com.ssafy.web.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.web.member.model.Member;
import com.ssafy.web.member.model.MemberSecret;

@Mapper
public interface MemberMapper {
	public Member login(Member member) throws Exception;

	public String getSalt(String email) throws Exception;

	public void registMember(Member member) throws Exception;

	public void registMemberSecret(MemberSecret memberSecret) throws Exception;

	public int findMemberNo(String email) throws Exception;
}
