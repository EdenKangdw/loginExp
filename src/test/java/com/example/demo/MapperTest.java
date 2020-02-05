package com.example.demo;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import com.example.demo.domain.MemberDTO;
import com.example.demo.mapper.MemberMapper;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
	/*
	 * BoardMapper 빈(Bean) 선언
	 */
	@Autowired
	private MemberMapper memberMapper;

	@Test
	public void testInsert() {
		MemberDTO member = new MemberDTO();
		member.setMbr_email("edenkang5517@gmail.com");
		member.setMbr_pw("password");

		memberMapper.registerMember(member);
		System.out.println("결과는 " + member.getMbr_email() + "입니다.");
	}
//	
//	@Test
//	public void testSelectDetails() {
//		MemberDTO boardDetails = boardMapper.selectBoardDetails(1);
//		try {
//			String jsonStr = new ObjectMapper().writeValueAsString(boardDetails);
//			System.out.println("=========================");
//			System.out.println(jsonStr);
//			System.out.println("=========================");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testUpdate() {
//		MemberDTO params = new MemberDTO();
//		params.setTitle("수정한 게시글 제목");
//		params.setContent("수정한 게시글 내용");
//		params.setWriter("수정한 작성자");
//		params.setNoticeYn("Y");
//		params.setSecretYn("Y");
//		params.setIdx(1);
//
//		int result = boardMapper.updateBoard(params);
//		if (result == 1) {
//			try {
//				MemberDTO boardDetails = boardMapper.selectBoardDetails(1);
//				String jsonStr = new ObjectMapper().writeValueAsString(boardDetails);
//				System.out.println("=========================");
//				System.out.println(jsonStr);
//				System.out.println("=========================");
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		// end of if
//	}
//	
//	@Test
//	public void testDelete() {
//		int result = boardMapper.deleteBoard(1);
//		System.out.println("결과는 " + result + "입니다.");
//	}
//	
//	@Test
//	public void testMultipleInsert() {
//		for (int i = 2; i <= 50; i++) {
//			MemberDTO params = new MemberDTO();
//			params.setTitle(i + "번 게시글 제목");
//			params.setContent(i + "번 게시글 내용");
//			params.setWriter(i + "번 게시글 작성자");
//			boardMapper.insertBoard(params);
//		}
//	}
//	
//	@Test
//	public void testSelectList() {
//		List<MemberDTO> boardList = boardMapper.selectBoardList();
//		if (CollectionUtils.isEmpty(boardList) == false) {
//			for (MemberDTO board : boardList) {
//				System.out.println("=========================");
//				System.out.println(board.getTitle());
//				System.out.println(board.getContent());
//				System.out.println(board.getWriter());
//				System.out.println("=========================");
//			}
//		}
//	}

}
