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
	public String register(final MemberDTO member) {
		System.out.println("============= ID :" + member.getMbr_email());
		service.registerMember(member);
		return "board/login";
	}
	
	@RequestMapping(value = "/signin")
	public String signin(final MemberDTO member, HttpServletRequest req, Model model) {
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

	
	

}


