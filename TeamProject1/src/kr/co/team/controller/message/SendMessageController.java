package kr.co.team.controller.message;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.message.SendMessageService;

public class SendMessageController implements BackController{
	IService service = new SendMessageService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = null;
		try {
			out=response.getWriter();
			service.doService(request, response);
			System.out.println(request.getParameter("type"));
			if(request.getParameter("type").equals("invite") || request.getParameter("type").equals("normal") || request.getParameter("type").equals("request")) {
				String data = (String)request.getAttribute("yesno");
				System.out.println(data);
				out.println(data); // yes no º¸³»±â
			}
			if(request.getParameter("type").equals("inviteAccept") || request.getParameter("type").equals("inviteRefuse")) {
				String data = (String)request.getAttribute("inviteAccept");
				out.println(data);
				
			}
			if( request.getParameter("type").equals("requestAccept") || request.getParameter("type").equals("requestRefuse")) {
				String data = (String)request.getAttribute("requestAccept");
				out.println(data);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
