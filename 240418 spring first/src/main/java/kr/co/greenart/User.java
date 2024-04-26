package kr.co.greenart;

public class User {
	private String name;
	private String email;
	private Integer age;
	private Boolean marry;
	
	public User() {}

	public User(String name, String email, Integer age, Boolean marry) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.marry = marry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getMarry() {
		return marry;
	}

	public void setMarry(Boolean marry) {
		this.marry = marry;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", age=" + age + ", marry=" + marry + "]";
	}
}
