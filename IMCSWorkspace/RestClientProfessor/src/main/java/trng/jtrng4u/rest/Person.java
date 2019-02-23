package trng.jtrng4u.rest;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
    private Integer pid;	
    private String username;
    private String password;
    private int age;
    private String gender;
    private String city;
    
    
    
	public Person() {
		super();
	}
	public Person(Integer pid, String username, String password, int age, String gender, String city) {
		super();
		this.pid = pid;
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", username=" + username + ", password=" + password + ", age=" + age + ", gender="
				+ gender + ", city=" + city + "]";
	}
}
