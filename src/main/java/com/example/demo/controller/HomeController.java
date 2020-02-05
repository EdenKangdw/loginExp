package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.MemberDTO;
import com.example.demo.service.MemberService;

@Controller
public class HomeController {

	/*
	 * BoardService 빈(Bean) 선언
	 */
	@Autowired
	private MemberService service;
	
	@RequestMapping(value = "/")
	public String index(HttpServletRequest req) {
		if(req.getSession().getAttribute("loginInfo") != null){
			return "board/welcome";
		} else {
			
			return "board/login";
		}
		
	}
	
	@RequestMapping(value = "/signup")
	public String signup() {
		return "board/signup";
	}
	
	@RequestMapping(value = "/register")
	public String signup(final MemberDTO member) {
		System.out.println("============= ID :" + member.getMbr_email());
		service.registerMember(member);
		return "board/login";
	}
	
	@RequestMapping(value = "/login")
	public String login(final MemberDTO member, HttpServletRequest req, Model model) {
		System.out.println("============= ID :" + member.getMbr_email());
		String userEmail = member.getMbr_email();
		if ( service.selectMember(userEmail) != null ) {
			System.out.println("============= ID2222 :" + userEmail);
			
			req.getSession().setAttribute("loginInFo", userEmail);
			req.getSession().setMaxInactiveInterval(10);
			
			model.addAttribute("member", member);
			return "board/welcome";
		} else {
			System.out.println("============= ID 3:" + userEmail);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().removeAttribute("loginInfo");
		return "board/login";
		
	}

	
	

	
//	@RequestMapping(value = "/board/write.do")
//	public String openBoardWrite(@RequestParam(value = "idx", required = false) Integer idx, Model model) {
//
//		if (idx == null) {
//			model.addAttribute("board", new MemberDTO());
//		} else {
//			if (idx < 1) {
//				return "redirect:/board/list.do";
//			}
//
//			MemberDTO board = service.getMemberDetails(idx);
//			if (board == null) {
//				return "redirect:/board/list.do";
//			}
//			model.addAttribute("board", board);
//		}
//
//		return "board/write";
//	}
//	
//	@RequestMapping(value = "/board/register.do", method = RequestMethod.POST)
//	public String registerBoard(final MemberDTO params) {
//
//		try {
//			boolean result = service.registerMember(params);
//			if (result == false) {
//				// TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달
//			}
//		} catch (DataAccessException e) {
//			// TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO => 알 수 없는 문제가 발생하였다는 메시지를 전달
//			e.printStackTrace();
//		}
//
//		return "redirect:/board/list.do";
//	}
}


