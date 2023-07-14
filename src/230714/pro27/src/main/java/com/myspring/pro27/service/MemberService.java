package com.myspring.pro27.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro27.vo.MemberVO;

public interface MemberService {
	public List listMembers() throws DataAccessException;

	public void addMember(MemberVO memberVO) throws DataAccessException;

	public void delMember(String id) throws DataAccessException;

	public MemberVO modMember(String id) throws DataAccessException;

	public void updateMember(MemberVO memberVO) throws DataAccessException;

	public List searchMemberName(String name) throws DataAccessException;

	public List searchMemberEmail(String email) throws DataAccessException;

	public List searchMemberFirst(String first) throws DataAccessException;

	public MemberVO login(MemberVO member) throws DataAccessException;
}
