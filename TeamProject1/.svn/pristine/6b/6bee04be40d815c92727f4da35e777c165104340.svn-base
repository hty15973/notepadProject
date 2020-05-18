package kr.co.team.controller.message;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.message.SearchLeaderGroupService;

public class SearchLeaderGroupController implements BackController {
	IService service = new SearchLeaderGroupService(); 
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			service.doService(request, response);
			String data=(String)request.getAttribute("isExist");
			out.println(data); //yes or no µµÂø
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
