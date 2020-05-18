package kr.co.team.controller.member;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.member.MemberRegisterService;


public class MemberRegisterController implements BackController {
	IService service;
	
	public MemberRegisterController() {
		service = new MemberRegisterService();
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String dispatcherUri=null;
		String dupli = null;
		PrintWriter out = null;
		response.setCharacterEncoding("utf-8");
		try {
			service.doService(request, response);
			out = response.getWriter();
			dupli = (String)request.getAttribute("dupli");
			if(dupli != null) {
				if(dupli.equals("success")) {
					out.println(0);
				}
				else {
					out.println(1);
				}
			}
			
			dispatcherUri = (String)request.getAttribute("URL");
			if(dispatcherUri != null) {
				RequestDispatcher disp=request.getRequestDispatcher(dispatcherUri);
				disp.forward(request, response);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}
}
