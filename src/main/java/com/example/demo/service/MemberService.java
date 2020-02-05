package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.MemberDTO;

public interface MemberService {

	// 회원가입 
	public boolean registerMember(MemberDTO member);
	
	// 중복체크 
	public MemberDTO selectMember (String email);

}
