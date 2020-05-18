package kr.co.team.controller.group;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.group.SetThemeSharedService;

public class SetThemeSharedController implements BackController {
	IService service = new SetThemeSharedService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		
		try {
			service.doService(request, response);
			out = response.getWriter();
			String isTheme = (String)request.getAttribute("isTheme");
			out.println(isTheme);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
