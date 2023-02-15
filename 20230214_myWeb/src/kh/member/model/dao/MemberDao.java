package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kh.common.jdbc.JdbcTemplate;
import kh.member.model.vo.MemberVO;

public class MemberDao {
	
	//회원 가입  enrollcontroller 에서 요청
	public int enroll(Connection conn, MemberVO mvo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "insert INTO TEST_MEMBER VALUES(?,?,?,?)";		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPasswd());
			pstmt.setString(3, mvo.getName());
			pstmt.setString(4, mvo.getEmail());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(pstmt);
		}
		System.out.println("DAO return : " + result);
		return result;
	}

}
