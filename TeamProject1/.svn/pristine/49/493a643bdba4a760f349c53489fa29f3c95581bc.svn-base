package kr.co.team.controller.theme;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.theme.PrivateThemeService;

public class PrivateThemeController implements BackController {
	
	IService service = new PrivateThemeService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			service.doService(request, response);
			String data = (String)request.getAttribute("isMine");
			out.println(data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
