package hello.corespring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.corespring.member.Member;
import hello.corespring.repository.MemberRepository;
import hello.corespring.service.MemberService;

@Component
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	// 생성자 주입
	@Autowired
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
	
}
