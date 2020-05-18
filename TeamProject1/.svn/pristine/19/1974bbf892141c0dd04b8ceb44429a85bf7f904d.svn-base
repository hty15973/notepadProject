package kr.co.team.controller.theme;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.theme.SetThemeRelationService;

public class SetThemeRelationController implements BackController {
	IService service =new SetThemeRelationService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		JSONObject jobj=null;
		try {
			service.doService(request, response);
			response.setCharacterEncoding("utf-8");
			out=response.getWriter();
			out.println(request.getAttribute("message"));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}
}
