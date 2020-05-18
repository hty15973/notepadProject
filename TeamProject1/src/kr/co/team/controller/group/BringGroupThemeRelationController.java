package kr.co.team.controller.group;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.group.BringGroupThemeRelationService;
import kr.co.team.vo.MemberVO;
import kr.co.team.vo.ThemeMemberVO;

public class BringGroupThemeRelationController implements BackController {
	IService service=new BringGroupThemeRelationService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		JSONObject jobj=null;	
		try {
			System.out.println(1);

			service.doService(request, response);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			out=response.getWriter();
			
			ArrayList<ThemeMemberVO> list=(ArrayList<ThemeMemberVO>)request.getAttribute("list");
			System.out.println(list.size());
			jobj=new JSONObject();
			JSONArray jAry=new JSONArray();
			for(ThemeMemberVO vo:list) {
				JSONObject jtemp=new JSONObject();
				jtemp.put("themeMemberCode", vo.getThemeMember_code());
				jtemp.put("themeMemberName", vo.getThemeMember_name());
				
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