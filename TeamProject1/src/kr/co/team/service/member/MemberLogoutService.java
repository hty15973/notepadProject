package kr.co.team.service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.team.service.IService;

public class MemberLogoutService implements IService {

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setAttribute("URL","/login.jsp");
		return;
	}

}
