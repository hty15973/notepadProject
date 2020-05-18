package kr.co.team.controller.member;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.member.MemberSearchByGroupService;
import kr.co.team.vo.GroupVO;

public class MemberSearchByGroupController implements BackController {
	IService service=new MemberSearchByGroupService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		JSONObject jobj=null;
		try {
			service.doService(request, response);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			out=response.getWriter();
			ArrayList<String> leaderNameList=(ArrayList<String>)request.getAttribute("leaderNameList");
			
			jobj=new JSONObject();
			JSONArray jAry=new JSONArray();
			for(String leaderName:leaderNameList) {
				JSONObject jtemp=new JSONObject();
				jtemp.put("name", leaderName);
				jAry.add(jtemp);
			}
			jobj.put("leaderNameList", jAry);
			out.println(jobj.toJSONString());
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}
}
