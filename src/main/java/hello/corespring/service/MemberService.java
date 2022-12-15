package hello.corespring.service;

import hello.corespring.member.Member;

public interface MemberService {
	void join(Member member);
	Member findMember(Long memberId);
}
