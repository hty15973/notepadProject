package kr.co.team.controller.theme;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.theme.BringThemeRelationService;
import kr.co.team.vo.NotepadVO;

public class BringThemeRelationController implements BackController {
	IService service =new BringThemeRelationService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		JSONObject jobj=null;
		try {
			service.doService(request, response);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			out=response.getWriter();
			jobj=new JSONObject();
			ArrayList<String> list=(ArrayList<String>)request.getAttribute("list");
			JSONArray jAry=new JSONArray();
			for(String theme:list) {	
				JSONObject jtemp=new JSONObject();
				jtemp.put("theme",theme);
				jAry.add(jtemp);
			}
			jobj.put("list", jAry);
			out.println(jobj.toJSONString());
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}
}
