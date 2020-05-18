package kr.co.team.controller.group;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.group.GroupExpelService;

public class GroupExpelController implements BackController {
	
	IService service = new GroupExpelService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		JSONObject jobj = null;
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			service.doService(request, response);
			jobj = new JSONObject();
			
			String leaderCheck = (String)request.getAttribute("leaderCheck");
			String object = (String)request.getAttribute("object");
			jobj.put("leaderCheck", leaderCheck);
			jobj.put("object", object);
			out.println(jobj.toJSONString());
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
