package sec07_02;

import java.sql.Date;

public class MemberVO {
	// Value Object

	// 필드(field) - 객체의 데이터가 저장되는 곳
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;

	// 생성자 - 객체 생성시 초기화를 담당, 생성자 만드는 법 클래스명(){}, 일종의 메서드
	MemberVO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
