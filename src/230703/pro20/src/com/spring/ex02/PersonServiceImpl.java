package com.spring.ex02;

public class PersonServiceImpl implements PersonService {
	private String name;
	private String sex;
	private int age;

	public PersonServiceImpl(String name) {
		this.name = name;
	}

	public PersonServiceImpl(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public PersonServiceImpl(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	

	

	@Override
	public void sayHello() {
		System.out.println("이름 : "+ name);
		System.out.println("나이 : " + age + "세");
		if (sex != null) {
			System.out.println("성별 : " + sex + "성");
			
		}
		// String 타입이 겹치므로 오류
	}
}
