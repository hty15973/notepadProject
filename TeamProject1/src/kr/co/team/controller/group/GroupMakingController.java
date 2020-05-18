package kr.co.team.controller.group;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.group.GroupMakingService;

public class GroupMakingController implements BackController {
	IService service=new GroupMakingService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		JSONObject jobj=null;
		try {
			service.doService(request, response);
			response.setCharacterEncoding("utf-8");
			out=response.getWriter();
			jobj=new JSONObject();
			response.setContentType("application/json");
			jobj.put("successCode", request.getAttribute("successCode"));
			jobj.put("GroupCode", request.getAttribute("GroupCode"));
			out.println(jobj.toJSONString());
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}
}
