package hello.corespring.repository.impl;

import java.util.Map;

import org.springframework.stereotype.Component;

import java.util.HashMap;

import hello.corespring.member.Member;
import hello.corespring.repository.MemberRepository;

@Component
public class MemoryMemberRepository implements MemberRepository {

	// 동시성 이슈 때문에, ConcurrentHashMap을 사용하는게 맞으나,
	// 예제이기 때문에 HashMap 사용
	private static Map<Long, Member> store = new HashMap<>();
	
	@Override
	public void save(Member member) {
		store.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId) {
		return store.get(memberId);
	}

}
