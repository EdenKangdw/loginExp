package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {

	/** 번호 (PK) */
	private Integer mbr_id;

	/** 이메일 */
	private String mbr_email;
	
	/** 패스워드 */
	private String mbr_pw;

	

}
