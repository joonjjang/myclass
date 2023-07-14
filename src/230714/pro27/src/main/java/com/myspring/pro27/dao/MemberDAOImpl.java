package com.myspring.pro27.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.pro27.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<MemberVO> membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public void insertMember(MemberVO memberVO) throws DataAccessException {
		sqlSession.insert("mapper.member.insertMember", memberVO);

	}

	@Override
	public void deleteMember(String id) throws DataAccessException {
		sqlSession.delete("mapper.member.deleteMember", id);
	}

	@Override
	public MemberVO modMember(String id) throws DataAccessException {
		MemberVO memList = (MemberVO) sqlSession.selectOne("mapper.member.modMember", id);
		return memList;
	}

	@Override
	public void updateMember(MemberVO memberVO) throws DataAccessException {
		sqlSession.update("mapper.member.updateMember", memberVO);
	}

	@Override
	public List searchMemberName(String id) throws DataAccessException {
		List memList = sqlSession.selectList("mapper.member.searchMemberName", id);
		return memList;
	}

	@Override
	public List<MemberVO> searchMemberEmail(String email) throws DataAccessException {
		List<MemberVO> memList = sqlSession.selectList("mapper.member.searchMemberEmail", email);
		return memList;
	}

	@Override
	public List<MemberVO> searchMemberFirst(String name) throws DataAccessException {
		List<MemberVO> memList = sqlSession.selectList("mapper.member.searchMemberFirst", name);
		return memList;
	}

	@Override
	public MemberVO loginById(MemberVO member) throws DataAccessException {
		MemberVO vo = sqlSession.selectOne("mapper.member.loginById", member);
		return vo;
	}
}
