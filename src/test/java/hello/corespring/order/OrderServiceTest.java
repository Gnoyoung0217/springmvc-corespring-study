package hello.corespring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.corespring.AppConfig;
import hello.corespring.member.Grade;
import hello.corespring.member.Member;
import hello.corespring.service.MemberService;
import hello.corespring.service.OrderService;

public class OrderServiceTest {
	
	MemberService memberService;
	OrderService orderService;
	
	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}
	
	@Test
	void 주문생성() {
		// given
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		
		// when
		memberService.join(member);
		Order order = orderService.createOrder(memberId, "itemA", 10000);
		
		// then
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
	
}
