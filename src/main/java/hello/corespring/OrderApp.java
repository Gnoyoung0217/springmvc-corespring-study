package hello.corespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.corespring.member.Grade;
import hello.corespring.member.Member;
import hello.corespring.order.Order;
import hello.corespring.service.MemberService;
import hello.corespring.service.OrderService;
import hello.corespring.service.impl.MemberServiceImpl;
import hello.corespring.service.impl.OrderServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		OrderService orderService = ac.getBean("orderService", OrderService.class);

//		AppConfig appConfig = new AppConfig();		
//		MemberService memberService = new MemberServiceImpl();
//		OrderService orderService = new OrderServiceImpl();
//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 20000);
		
		System.out.println("order = " + order.calcuratePrice());
	}

}
