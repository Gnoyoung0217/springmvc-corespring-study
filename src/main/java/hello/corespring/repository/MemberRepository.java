package hello.corespring.repository;

import hello.corespring.member.Member;

public interface MemberRepository {
	void save(Member member);
	
	Member findById(Long memberId);
}
