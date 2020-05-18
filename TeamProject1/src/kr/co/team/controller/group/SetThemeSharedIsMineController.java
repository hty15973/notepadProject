package kr.co.team.controller.group;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.group.SetThemeSharedIsMineService;

public class SetThemeSharedIsMineController implements BackController {
	IService service = new SetThemeSharedIsMineService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			
			service.doService(request, response);
			out = response.getWriter();
			String isMine = (String)request.getAttribute("isMine");
			System.out.println(isMine);
			out.println(isMine);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
