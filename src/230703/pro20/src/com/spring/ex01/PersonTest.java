package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		PersonService person = (PersonService) factory.getBean("personService");
		// PersonService person = new PersonServiceImpl();
		person.sayHello();
	
		//스프링의 DI (의존성 주입)방식
		
		//이름을 setter를 이용하지만 이 클래스를 객체를 만들어서 하는 것이 아닌 주입하는 방식
		//PersonServiceImpl person = new PersonServiceImpl(); 이 과정이 없으짐
		//홍길동이란 이름을 설정파일에서 주입해줌
		//person.setName("홍길동");
		
		//스프링에서는 BeanFactory와 이를 상속한 ApplicationContext 두 가지 유형의 컨테이너를 제공
		//BeanFactory는 스프링 설정파일(person.xml)에 등록된 bean 객체를 사용하고 관리하는
		//가장 기본적인 콘테이너 기능만 제공, 실제 beanFactory를 사용할 일은 없다.
		
		// BeanFactory factory1 = new XmlBeanFactory(new FileSystemResource("person.xml"));
	
		PersonService person2 = (PersonService) factory.getBean("PpersonService");
	
		person2.sayHello();
	}

}
