package com.spring.ex01;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;

	}

	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}
	
	public void addMember(MemberVO memberVO) {
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		session.insert("mapper.member.addMember", memberVO);
		session.commit(); 
		
	}
	
	public void delMember(MemberVO memberVO) {
		
		sqlMapper =getInstance();
		SqlSession session = sqlMapper.openSession();
		
		session.delete("mapper.member.delMember", memberVO);
		session.commit();
	}
	
	public List<MemberVO> saerchMember(MemberVO memberVO) {
		
		sqlMapper =getInstance();
		SqlSession session = sqlMapper.openSession();
		
		List<MemberVO> listmember = session.selectList("mapper.member.saerchMember", memberVO);
		session.commit();
		return listmember;
		
	}
	
}
