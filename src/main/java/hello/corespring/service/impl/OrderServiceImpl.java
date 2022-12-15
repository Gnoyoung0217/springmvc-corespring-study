package hello.corespring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import hello.corespring.annotation.MainDiscountPolicy;
import hello.corespring.discount.DiscountPolicy;
import hello.corespring.discount.impl.RateDiscountPolicy;
import hello.corespring.member.Member;
import hello.corespring.order.Order;
import hello.corespring.repository.MemberRepository;
import hello.corespring.repository.impl.MemoryMemberRepository;
import hello.corespring.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService {
	
	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	public MemberRepository getMemberRepository() {
		return memberRepository;
	}

}
