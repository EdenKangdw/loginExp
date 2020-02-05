package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	
	public boolean registerMember(MemberDTO member);
	
	public MemberDTO selectMember (String email);
	
	

	public int insertBoard(MemberDTO params);

	public MemberDTO selectBoardDetails(Integer idx);

	public int updateBoard(MemberDTO params);

	public int deleteBoard(Integer idx);

	public List<MemberDTO> selectBoardList();

}
