package kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVO;

/**
 * Servlet implementation class MyinfoController
 */
@WebServlet("/myinfo")
public class MyinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = null;
		if((MemberVO)request.getSession().getAttribute("lgnss") != null) {
			id = ((MemberVO)request.getSession().getAttribute("lgnss")).getId();
		}
		if(id != null) {
			request.setAttribute("myinfo", new MemberService().myinfo(id));
			request.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMsg", "로그인이 되지 않아 정보를 확인 할 수 없습니다.");
			request.getRequestDispatcher("/WEB-INF/view/error/error_login.jsp").forward(request, response);
		}
		
	}

}
