package kr.co.team.controller.theme;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.theme.DeleteThemeService;

public class DeleteThemeController implements BackController {
	
	IService service = new DeleteThemeService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			service.doService(request, response);
			response.setCharacterEncoding("utf-8");
			String data = (String)request.getAttribute("themeDelete");
			out.println(data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
