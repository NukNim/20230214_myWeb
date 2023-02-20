package kh.home.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.board.model.service.BoardService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({"/", "/main", "/index", "/home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aaa = request.getParameter("aaa");
		BoardService bs = new BoardService();
		//2. DB
		//request.setAttribute("boardlist", "TODO값");
		// dto, dao , service, controller, view
		//Paging 처리
		
		//1-총글 개수 DB 알아오기
		int cnt = bs.getCountBoard(); // TODO
		//2-한페이지에 나타낼 글수 정하기
		int pageSize =3; //한페이지에 나타낼 글수 보통 10개
		//3-페이지가 몇개인지 확인
		int pageBlock = 2;
		//4- 현재페이지
		int currentPage = 1; //default =1, 클릭시에는 변경
		
		try {
			currentPage = Integer.parseInt(aaa);
		}catch (Exception e) {
			
		}
		
		
		//나는 일케
		if(aaa != null) {
			currentPage = Integer.parseInt(aaa) ;
		}
		
		//5-row num 범위 정하기
		int startRnum=0;
		int endRnum = 0;
		startRnum = (currentPage -1)* pageSize +1;
		endRnum = (startRnum + pageSize -1) > cnt ? (startRnum + pageSize -1) : cnt;
		request.setAttribute("boardlist", bs.getBoardList(startRnum, endRnum));
		
		//6-페이지 범위 정하기
		int startPageNum = 0;
		int endPageNum = 0;
		startPageNum = (currentPage % pageBlock == 0 ) ? (currentPage/pageBlock -1)*pageBlock +1 
					: ((currentPage/pageBlock)*pageBlock +1);
		
		int pageCnt = (cnt/pageSize) + (cnt%pageSize == 0 ? 0:1);
		
		endPageNum = (startPageNum + pageBlock -1) > pageCnt ? pageCnt : (startPageNum + pageBlock -1) ;
		
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCnt", pageCnt);
		
		//request.setAttribute("boardlist", bs.getBoardList());
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
