package com.myspring.pro27.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro27.vo.MemberVO;

public interface MemberDAO {
	public List selectAllMemberList() throws DataAccessException;

	public void insertMember(MemberVO memberVO) throws DataAccessException;

	public void deleteMember(String id) throws DataAccessException;

	public MemberVO modMember(String id) throws DataAccessException;

	public void updateMember(MemberVO memberVO) throws DataAccessException;

	public List searchMemberName(String id) throws DataAccessException;

	public List searchMemberEmail(String email) throws DataAccessException;

	public List searchMemberFirst(String name) throws DataAccessException;

	public MemberVO loginById(MemberVO member) throws DataAccessException;

}
