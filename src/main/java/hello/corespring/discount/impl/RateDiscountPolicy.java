package hello.corespring.discount.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import hello.corespring.annotation.MainDiscountPolicy;
import hello.corespring.discount.DiscountPolicy;
import hello.corespring.member.Grade;
import hello.corespring.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
	
	private int discountPercent = 10; // 10%

	@Override
	public int discount(Member member, int price) {
		if(member.getGrade() == Grade.VIP) {
			return price * discountPercent / 100;
		} else {
			return price;
		}
	}
	
	
}
