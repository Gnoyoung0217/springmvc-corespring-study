package hello.corespring.scan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.corespring.AutoAppConfig;
import hello.corespring.repository.MemberRepository;
import hello.corespring.service.MemberService;
import hello.corespring.service.impl.OrderServiceImpl;

public class AutoAppConfigTest {
	
	@Test
	void basicScan() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
		
		OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
		
		MemberRepository memberRepository = bean.getMemberRepository();
		System.out.println("memberRepository = " + memberRepository);
	}

	
}