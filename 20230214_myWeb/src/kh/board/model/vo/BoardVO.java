package kh.board.model.vo;

import java.sql.Date;

public class BoardVO {
	
	private int boardNum;
	private String boardTitle;
	private String boardWrite;
	private String boardContent;
	private String boardOriginalFilename;
	private String boardRenameFilename;
	private Date boardDate;
	private int boardLevel;
	private int boardRef;
	private int boardReplySeq;
	private int boardReadcount;
	
	
	
	
	
	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BoardVO(int boardNum, String boardTitle, String boardWrite, String boardContent,
			String boardOriginalFilename, String boardRenameFilename, Date boardDate, int boardLevel, int boardRef,
			int boardReplySeq, int boardReadcount) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardWrite = boardWrite;
		this.boardContent = boardContent;
		this.boardOriginalFilename = boardOriginalFilename;
		this.boardRenameFilename = boardRenameFilename;
		this.boardDate = boardDate;
		this.boardLevel = boardLevel;
		this.boardRef = boardRef;
		this.boardReplySeq = boardReplySeq;
		this.boardReadcount = boardReadcount;
	}
	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardWrite=" + boardWrite
				+ ", boardContent=" + boardContent + ", boardOriginalFilename=" + boardOriginalFilename
				+ ", boardRenameFilename=" + boardRenameFilename + ", boardDate=" + boardDate + ", boardLevel="
				+ boardLevel + ", boardRef=" + boardRef + ", boardReplySeq=" + boardReplySeq + ", boardReadcount="
				+ boardReadcount + "]";
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWrite() {
		return boardWrite;
	}
	public void setBoardWrite(String boardWrite) {
		this.boardWrite = boardWrite;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardOriginalFilename() {
		return boardOriginalFilename;
	}
	public void setBoardOriginalFilename(String boardOriginalFilename) {
		this.boardOriginalFilename = boardOriginalFilename;
	}
	public String getBoardRenameFilename() {
		return boardRenameFilename;
	}
	public void setBoardRenameFilename(String boardRenameFilename) {
		this.boardRenameFilename = boardRenameFilename;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardLevel() {
		return boardLevel;
	}
	public void setBoardLevel(int boardLevel) {
		this.boardLevel = boardLevel;
	}
	public int getBoardRef() {
		return boardRef;
	}
	public void setBoardRef(int boardRef) {
		this.boardRef = boardRef;
	}
	public int getBoardReplySeq() {
		return boardReplySeq;
	}
	public void setBoardReplySeq(int boardReplySeq) {
		this.boardReplySeq = boardReplySeq;
	}
	public int getBoardReadcount() {
		return boardReadcount;
	}
	public void setBoardReadcount(int boardReadcount) {
		this.boardReadcount = boardReadcount;
	}
	
	
	
	
	

}
