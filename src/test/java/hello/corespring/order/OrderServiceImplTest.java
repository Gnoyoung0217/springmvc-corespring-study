package hello.corespring.order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import hello.corespring.discount.impl.FixDiscountPolicy;
import hello.corespring.member.Grade;
import hello.corespring.member.Member;
import hello.corespring.repository.impl.MemoryMemberRepository;
import hello.corespring.service.OrderService;
import hello.corespring.service.impl.OrderServiceImpl;

public class OrderServiceImplTest {
	
	@Test
	void createOrder() {
		MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
		memoryMemberRepository.save(new Member(1L, "memberA", Grade.VIP));
		
		OrderService orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());
		Order order = orderService.createOrder(1L, "itemA", 10000);
		
		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}
