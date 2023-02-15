package kh.member.model.service;

import java.sql.Connection;

import static kh.common.jdbc.JdbcTemplate.*;
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

}
