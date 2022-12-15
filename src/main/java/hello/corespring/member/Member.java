package hello.corespring.member;

public class Member {
	private Long id;
	private String name;
	private Grade grade;
	
	public Member(Long id, String name, Grade grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
}
