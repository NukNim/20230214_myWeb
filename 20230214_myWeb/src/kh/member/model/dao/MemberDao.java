package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
	public MemberVO login(Connection conn, MemberVO mvo) {
		MemberVO  m = null;
		
		String query = "SELECT ID, NAME, EMAIL FROM TEST_MEMBER";
		query += " WHERE ID = ? AND PASSWD = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			m = new MemberVO();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPasswd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m.setId(rs.getString("ID"));
				m.setName(rs.getString("NAME"));
				m.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		
		
		return m;
	}
	
	public MemberVO myinfo(Connection conn, String id) {
		MemberVO  m = null;
		
		String query = "SELECT ID, NAME, EMAIL FROM TEST_MEMBER";
		query += " WHERE ID = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			m = new MemberVO();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m.setId(rs.getString("ID"));
				m.setName(rs.getString("NAME"));
				m.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		
		
		return m;
	}

}
