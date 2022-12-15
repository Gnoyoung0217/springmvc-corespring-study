package hello.corespring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.corespring.repository.MemberRepository;
import hello.corespring.repository.impl.MemoryMemberRepository;

@Configuration
@ComponentScan(
		basePackages = "hello.corespring",
		basePackageClasses = AutoAppConfig.class,
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
	
//	@Bean(name = "memoryMemberRepository")
//	MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
//	}
}
