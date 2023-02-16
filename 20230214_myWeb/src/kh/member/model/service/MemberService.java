package kh.member.model.service;

import java.sql.Connection;

import static kh.common.jdbc.JdbcTemplate.*;

import kh.common.jdbc.JdbcTemplate;
import kh.member.model.dao.MemberDao;
import kh.member.model.vo.MemberVO;

public class MemberService {
	
	public int enroll(MemberVO m) {
		Connection conn = getConnection();
		int result = -1;
		
		MemberDao dao = new MemberDao();
		result =  dao.enroll(conn, m);
		
		close(conn);
		return result;
		
	}

	public int DuplicateId(String id) {
		int result = 0;
		
		return result;
	}

	public MemberVO login(MemberVO m) {
		Connection conn = getConnection();
		MemberVO vo = new MemberVO();
		
		
		MemberDao dao = new MemberDao();
		
		vo = dao.login(conn, m);
		
		JdbcTemplate.close(conn);
		
		return vo;
	}
	
	public MemberVO myinfo(String id) {
		Connection conn = getConnection();
		MemberVO vo = new MemberVO();
		
		
		MemberDao dao = new MemberDao();
		
		vo = dao.myinfo(conn, id);
		
		JdbcTemplate.close(conn);
		
		return vo;
	}

}
