package kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;

/**
 * Servlet implementation class DupIdCheckServlet
 */
@WebServlet("/dupid.lo")
public class DupIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DupIdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		// 1. ajax 에서 담은 정보 가져오기
		String id = request.getParameter("id");
		System.out.println("전달 받은 데이터 " + id);
		//2. DB 갔다오기
		int dupCheck = new MemberService().DuplicateId(id);
		//3. 결과 데이터 전달 
		PrintWriter out = response.getWriter();
		out.append("응답할데이터");
		out.flush();
		out.close();
		
		
	}

}
