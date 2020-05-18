package kr.co.team.controller.member;



import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.member.MemberLoginService;

public class MemberLoginController implements BackController {
	IService service;
	
	public MemberLoginController() {
		service = new MemberLoginService();
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		String dispatcherUri=null;
		
		try {
			service.doService(request, response);
			dispatcherUri=(String)request.getAttribute("URL");
			
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
