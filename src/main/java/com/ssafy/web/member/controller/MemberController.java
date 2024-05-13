package com.ssafy.web.member.controller;

import java.util.*;

import com.ssafy.web.global.AccessMemStorage;
import com.ssafy.web.global.RefreshMemStorage;
import com.ssafy.web.global.TupleStorage;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import com.ssafy.web.OpenCrypt;
import com.ssafy.web.member.model.Member;
import com.ssafy.web.member.model.MemberSecret;
import com.ssafy.web.member.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin("*")
@RequestMapping("/members")
public class MemberController {
	private final MemberService memberService;
	private final RefreshMemStorage refreshMemStorage;
	private final AccessMemStorage accessMemStorage;

	public MemberController(MemberService memberService, RefreshMemStorage refreshMemStorage, AccessMemStorage accessMemStorage) {
		this.memberService = memberService;
		this.refreshMemStorage = refreshMemStorage;
		this.accessMemStorage = accessMemStorage;
	}
	
	@PostMapping("/regist")
	public Map<String, String> register(@RequestBody Member member, HttpServletResponse response) throws Exception {
		Map<String, String> retMap = new HashMap<>();

		boolean ret = memberService.registMember(member);

		if(ret){
			retMap.put("msg", "회원가입 성공");
		}
		else{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			retMap.put("msg", "회원가입 실패");
		}

		return retMap;
	}

	@PostMapping("/refresh")
	public Map<String, String> refresh(@RequestBody Map<String, String> req) throws Exception {
		return memberService.refresh(req.get("refresh-token"));
	}

	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Member member) throws Exception{
		return memberService.login(member);
	}

	@PostMapping("/logout")
	public Map<String, String> logout(@RequestBody Map<String, String> req, HttpServletRequest request) throws Exception {
		return memberService.logout(req, request);
	}

}
