package hello.corespring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.corespring.discount.DiscountPolicy;
import hello.corespring.discount.impl.FixDiscountPolicy;
import hello.corespring.discount.impl.RateDiscountPolicy;
import hello.corespring.repository.MemberRepository;
import hello.corespring.repository.impl.MemoryMemberRepository;
import hello.corespring.service.MemberService;
import hello.corespring.service.OrderService;
import hello.corespring.service.impl.MemberServiceImpl;
import hello.corespring.service.impl.OrderServiceImpl;

// 관심사의 분리 - 생성자 주입
// 애플리케이션의 실제 동작에 필요한 '구현 객체를 생성' 해주는 역할
// 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입 해주는 역할
@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public OrderService orderService() {
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}

	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		System.out.println("call AppConfig.discountPolicy");
		return new RateDiscountPolicy();
	}

}
