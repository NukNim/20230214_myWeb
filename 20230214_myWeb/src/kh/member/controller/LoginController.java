package kh.member.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login test");
		//1 
		MemberVO m = new MemberVO();
		m.setId(request.getParameter("id"));
		m.setPasswd( request.getParameter("passwd"));
		
		MemberService ms = new MemberService();
		
		MemberVO result = ms.login(m);
		
		if(result != null) {
			System.out.println("성공");
			request.getSession().setAttribute("lgnss", result);
		}else {
			System.out.println("실패");
		}
		response.sendRedirect(request.getContextPath()+"/");
	}


}
