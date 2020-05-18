package kr.co.team.controller.group;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.group.WithdrawGroupService;

public class WithdrawGroupController implements BackController {
	
	IService service = new WithdrawGroupService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			service.doService(request, response);
			String data = (String)request.getAttribute("leaderCheck");
			out.println(data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
