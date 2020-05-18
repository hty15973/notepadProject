package kr.co.team.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.member.MemberSearchByEmailService;

public class MemberSearchByEmailController implements BackController{
	IService service;
	
	public MemberSearchByEmailController() {
		service = new MemberSearchByEmailService();
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String findIDByEmail = null;
		PrintWriter out = null;
		response.setCharacterEncoding("utf-8");

		try {
			service.doService(request, response);
			out = response.getWriter();
			findIDByEmail = (String)request.getAttribute("findIDByEmail"); // success or fail 둘중 하나
			if(findIDByEmail != null) {
				if(findIDByEmail.equals("success")) {
					String id = (String)request.getAttribute("find");
					out.println(id);
				}
				else {
					out.println(0);
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
