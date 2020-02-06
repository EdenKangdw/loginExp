package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
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
	
	@RequestMapping(value = "/google")
	public String google() {
		
		return "board/google";
	}
	
	
	@RequestMapping(value = "/signup")
	public String signup() {
		return "board/signup";
	}
	
	@RequestMapping(value = "/main")
	public String main() {
		return "board/google";
	}
	
	@RequestMapping(value = "/register")
	public String signup(final MemberDTO member) throws NullPointerException {
		System.out.println("============= ID :" + member.getMbr_email());
		String userEmail = member.getMbr_email();
		
		
		try { 
			MemberDTO dbMemberDTO = service.selectMember(userEmail);
			dbMemberDTO.getMbr_email().equals(userEmail); 
			System.out.println("============= test1 :" + member.getMbr_email());
			return "redirect:/";
		
					
		} catch (NullPointerException e) {
			service.registerMember(member);
			System.out.println("============= test2 :" + member.getMbr_email());
			return "board/login";
		}
		
	}
	
	@RequestMapping(value = "/signin")
	public String login(final MemberDTO member, HttpServletRequest req, Model model) {
		System.out.println("============= ID :" + member.getMbr_email());
		String userEmail = member.getMbr_email();
		String userPw = member.getMbr_pw();
		MemberDTO dbMemberDTO = service.selectMember(userEmail);
		
		try {
			if ( dbMemberDTO.getMbr_email().equals(userPw) && dbMemberDTO.getMbr_pw().equals(userPw) ) {
				System.out.println("============= ID2222 :" + userEmail);
				
				req.getSession().setAttribute("loginInFo", userEmail);
				req.getSession().setMaxInactiveInterval(10);
				
				model.addAttribute("member", member);
				return "board/welcome";
			} else {
				System.out.println("============= ID 3:" + userEmail);
				return "redirect:/";
			}
			
		} catch(NullPointerException e) {
			e.getStackTrace();
			System.out.println("============= ID 4:" + userEmail);
			return "redirect:/";
		}
		
		
		
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().removeAttribute("loginInfo");
		return "board/login";
		
	}

	
	

}


