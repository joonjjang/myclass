package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.spring.member.vo.MemberVO;

public interface MemberService {
	 public List listMembers() throws DataAccessException;
	 public List searchname(String name) throws DataAccessException;
	 public List searchemail(String emlil) throws DataAccessException;
	 public int addMember(MemberVO membeVO) throws DataAccessException;
	 public int removeMember(String id) throws DataAccessException;
	 public void updateMember(MemberVO memberVO) throws DataAccessException;
}
