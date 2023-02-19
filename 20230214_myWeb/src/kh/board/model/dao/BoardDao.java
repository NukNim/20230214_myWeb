package kh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kh.board.model.vo.BoardVO;
import kh.common.jdbc.JdbcTemplate;

public class BoardDao {
	
	public List<BoardVO> getBoardList(Connection conn){
		List<BoardVO> result = null; 
		
		String query = "select board_num, BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME,BOARD_RENAME_FILENAME,"
				+ " BOARD_DATE, BOARD_LEVEL, BOARD_REF, BOARD_REPLY_SEQ, BOARD_READCOUNT from board";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<BoardVO>();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoardContent(rs.getString("board_Content"));
				vo.setBoardDate(rs.getDate("board_Date"));
				vo.setBoardLevel(rs.getInt("board_Level"));
				vo.setBoardNum(rs.getInt("board_num"));
				vo.setBoardOriginalFilename(rs.getString("BOARD_ORIGINAL_FILENAME"));
				vo.setBoardReadcount(rs.getInt("BOARD_READCOUNT"));
				vo.setBoardRef(rs.getInt("BOARD_REF"));
				vo.setBoardRenameFilename(rs.getString("BOARD_RENAME_FILENAME"));
				vo.setBoardReplySeq(rs.getInt("BOARD_REPLY_SEQ"));
				vo.setBoardTitle(rs.getString("BOARD_TITLE"));
				vo.setBoardWrite(rs.getString("BOARD_WRITER"));
				
				result.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(pstmt);
			JdbcTemplate.close(rs);
		}
		
		return result;
	}

}
