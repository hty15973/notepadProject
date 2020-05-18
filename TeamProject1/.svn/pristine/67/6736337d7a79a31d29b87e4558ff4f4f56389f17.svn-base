package kr.co.team.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String,BackController>backController;
	
	public void init(ServletConfig config)throws ServletException {
		backController=new HashMap<>();
		Enumeration<String> names=config.getInitParameterNames();
		while(names.hasMoreElements()) {
			String name=names.nextElement();
			try {
				Class cls=Class.forName(config.getInitParameter(name));//해당클레스를 메모리에 올림.
				backController.put(name,(BackController)(cls.newInstance()));
			}catch(Exception e) {
				
			}
		}

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		BackController sc=null;
		if(backController.containsKey(uri)) {
			backController.get(uri).execute(request, response);
			

		}else {
			request.setAttribute("error", "잘못된 경로입니다 web.xml고치세요");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
