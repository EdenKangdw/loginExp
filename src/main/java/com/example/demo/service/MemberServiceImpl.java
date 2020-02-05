package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.MemberDTO;
import com.example.demo.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	/*
	 * BoardMapper 빈(Bean) 선언
	 */
	@Autowired
	private MemberMapper mapper;

	@Override
	public boolean registerMember(MemberDTO member) {
		mapper.registerMember(member);
		return true;
				
	}
	

	@Override
	public MemberDTO selectMember(String email) {
		return mapper.selectMember(email);
		
	}

	

}
