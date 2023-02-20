package kh.board.model.service;

import java.sql.Connection;
import java.util.List;

import kh.board.model.dao.BoardDao;
import kh.board.model.vo.BoardVO;
import kh.common.jdbc.JdbcTemplate;

public class BoardService {
	
	//overloading
	public List<BoardVO> getBoardList(){
		List<BoardVO> result = null;
		
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardDao().getBoardList(conn);
		
		JdbcTemplate.close(conn);
		
		return result; 
	}
	public List<BoardVO> getBoardList(int srum, int ernum){
		List<BoardVO> result = null;
		
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardDao().getBoardList(conn, srum, ernum);
		
		JdbcTemplate.close(conn);
		
		return result; 
	}

	public int getCountBoard() {
		int result = -1;
		
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardDao().getCountBoard(conn);
		
		JdbcTemplate.close(conn);
		
		
		return result;
	}

}
