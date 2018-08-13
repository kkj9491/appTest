package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.UserDao;
import org.study.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		if (pw.equals("1111")) {	
			HttpSession session = request.getSession();
			session.setAttribute("pw", pw);
			response.sendRedirect("/newProject/src/main/webapp/WEB-INF/welcome.jsp");
		} else {
			request.setAttribute("error", "주어진 정보가 맞지 않습니다. 다시 로그인하세요");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}
}
