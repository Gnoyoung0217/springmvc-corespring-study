package hello.corespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.corespring.member.Grade;
import hello.corespring.member.Member;
import hello.corespring.service.MemberService;
import hello.corespring.service.impl.MemberServiceImpl;

public class MemberApp {

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = ac.getBean("memberService", MemberService.class);
//		AppConfig appConfig = new AppConfig();
		
//		MemberService memberService = new MemberServiceImpl();
//		MemberService memberService = appConfig.memberService();
		
		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		
		System.out.println("findMember.getId() ::: " + findMember.getId());
		System.out.println("findMember.getName() ::: " + findMember.getName());
		System.out.println("findMember.getGrade() ::: " + findMember.getGrade());
	}

}
