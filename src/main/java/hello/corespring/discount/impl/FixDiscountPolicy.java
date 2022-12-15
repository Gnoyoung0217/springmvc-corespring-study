package hello.corespring.discount.impl;


import org.springframework.stereotype.Component;

import hello.corespring.discount.DiscountPolicy;
import hello.corespring.member.Grade;
import hello.corespring.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
	
	private int discountFixAmount = 1000; // 1000원 정액할인

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		} else {
			return 0;
		}
	}
	

}
