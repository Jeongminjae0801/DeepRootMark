package net.madvirus.spring4.chap08.auth;

import net.madvirus.spring4.chap08.member.MemberService;

public class Authenticator {

	private MemberService memberService;

	public Authenticator(MemberService memberService) {
		this.memberService = memberService;
	}

}
