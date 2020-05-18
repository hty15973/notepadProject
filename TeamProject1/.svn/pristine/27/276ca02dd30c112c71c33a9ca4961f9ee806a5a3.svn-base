package kr.co.team.controller.member;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.member.MemberLogoutService;

public class MemberLogoutController implements BackController{
	
	IService service;
	
	public MemberLogoutController() {
		service=new MemberLogoutService();
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String dispatcherUri=null;
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("utf-8");
			service.doService(request, response);
			dispatcherUri=(String)request.getAttribute("URL");
			RequestDispatcher disp=request.getRequestDispatcher(dispatcherUri);
			HttpSession session=request.getSession(true);
			disp.forward(request, response);
			session.invalidate();
			
		}catch(Exception e){
			
		}
	}

}
