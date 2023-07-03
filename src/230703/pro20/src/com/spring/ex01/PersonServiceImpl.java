package com.spring.ex01;

public class PersonServiceImpl implements PersonService {
	private String name;
	private String aaa;
	private String sex;
	private int age;

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	@Override
	public void sayHello() {
		System.out.println("홍길동쓰 " + name);
		System.out.println("이게 대체 뭐야" + age);
		System.out.println("이건 추가한거임" + aaa);
		System.out.println("성별은" + sex);
	}
}
