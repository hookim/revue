package com.ssafy.web.member.service;

import com.ssafy.web.OpenCrypt;
import com.ssafy.web.global.AccessMemStorage;
import com.ssafy.web.global.RefreshMemStorage;
import com.ssafy.web.global.TupleStorage;
import com.ssafy.web.member.repository.MemberRepository;
import com.ssafy.web.member.repository.MemberSecretRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import com.ssafy.web.member.model.Member;
import com.ssafy.web.member.model.MemberSecret;

import java.util.*;

@Service
public class MemberService {
	private final MemberRepository memberRepository;
	private final MemberSecretRepository memberSecretRepository;
	private final AccessMemStorage accessMemStorage;
	private final RefreshMemStorage refreshMemStorage;

	public MemberService(MemberRepository memberRepository, MemberSecretRepository memberSecretRepository, AccessMemStorage accessMemStorage, RefreshMemStorage refreshMemStorage) {
		this.memberRepository = memberRepository;
		this.memberSecretRepository = memberSecretRepository;
		this.accessMemStorage = accessMemStorage;
		this.refreshMemStorage = refreshMemStorage;
	}

	public Map<String, String> login(Member member) throws Exception{

		Map<String, String> result = new HashMap<>();
		result.put("msg", "로그인 실패");

		if(member.getId() == null || member.getPw() == null){
			return result;
		}

		Optional<Member> resultMember = memberRepository.findById(member.getId());
		Optional<MemberSecret> resultSecret = memberSecretRepository.findById(member.getId());
		if(resultMember.isEmpty() || resultSecret.isEmpty()){
			return result;
		}

		String OriginalPw = resultMember.get().getPw();
		String RequestedPw = OpenCrypt.getSHA256(member.getPw(), resultSecret.get().getSalt());

		if(!OriginalPw.equals(RequestedPw)){
			return result;
		}

		try{
//			String accessToken = UUID.randomUUID().toString();
//			Date accessExpiration = new Date(System.currentTimeMillis() + 60 * 1000);
//			accessMemStorage.getStorage().put(accessToken, new TupleStorage(member.getId(), accessExpiration));
//
//			String refreshToken = UUID.randomUUID().toString();
//			Date refreshExpire = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
//			refreshMemStorage.getStorage().put(refreshToken, new TupleStorage(member.getId(), refreshExpire));
//
//			result.put("access-token", accessToken);
//			result.put("refresh-token", refreshToken);

			result.put("msg", "로그인 성공");

			return result;
		}
		catch(Exception e){
			return result;
		}

	}

	public boolean registMember(Member member) throws Exception {

		System.out.println(member);
		if(member.getId() == null || member.getEmail() == null ||  member.getName() == null || member.getSsn() == null || member.getPw() == null ){
			return false;
		}

		MemberSecret memberSecret = new MemberSecret();
		String salt = UUID.randomUUID().toString();
		String enc_pwd = OpenCrypt.getSHA256(member.getPw(), salt);
		String ssn_key = OpenCrypt.generateKey("AES", 128);
		String enc_ssn = OpenCrypt.aesEncrypt(member.getSsn(), ssn_key);

		member.setPw(enc_pwd);
		member.setSsn(enc_ssn);

		memberSecret.setId(member.getId());
		memberSecret.setSalt(salt);
		memberSecret.setSsn_key(ssn_key);

		try {
			if(memberRepository.findById(member.getId()).isPresent()){
				return false;
			}
			memberRepository.save(member);
			memberSecretRepository.save(memberSecret);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public Map<String ,String> refresh(String refreshToken) {
		Map<String, String> retMap = new HashMap<>();
		if(refreshToken == null || refreshMemStorage.getStorage().get(refreshToken) == null){
			retMap.put("msg", "리프레시 토큰이 유효하지 않습니다.");
			return retMap;
		}
		if(refreshMemStorage.getStorage().get(refreshToken).getExpireDate().before(new Date(System.currentTimeMillis()))){
			refreshMemStorage.getStorage().remove(refreshToken);
			retMap.put("msg", "리프레시 토큰이 만료됐습니다. 다시 로그인 해주세요.");
			return retMap;
		}


		String userId = refreshMemStorage.getStorage().get(refreshToken).getUserId();
		String newAccessToken = UUID.randomUUID().toString();
		accessMemStorage.getStorage().put(newAccessToken, new TupleStorage(userId, new Date(System.currentTimeMillis())));
		retMap.put("access-token", newAccessToken);
		return retMap;
	}

	public Map<String, String> logout(Map<String, String> req, HttpServletRequest request) {
		if(req.get("refresh-token") != null || refreshMemStorage.getStorage().get(req.get("refresh-token")) != null){
			refreshMemStorage.getStorage().remove(req.get("refresh-token"));
		}
		if(request.getHeader("Authorization") != null){
			String remainingAccessToken = request.getHeader("Authorization").split("Bearer ")[1];
			if(accessMemStorage.getStorage().get(remainingAccessToken) != null){
				accessMemStorage.getStorage().remove(remainingAccessToken);
			}
		}

		Map<String, String> retMap= new HashMap<>();
		retMap.put("msg", "로그아웃에 성공했습니다.");

		return retMap;
	}


}
