package kr.co.team.controller.notepad;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.notepad.GetDateContentService;
import kr.co.team.vo.ThemeMemberNotepadVO;

public class GetDateContentController implements BackController {
	IService service;
	
	public GetDateContentController() {
		service = new GetDateContentService();
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		ArrayList<ThemeMemberNotepadVO> list = null;
		JSONObject jobj = null;
		PrintWriter out = null;
		JSONArray jAry = null;
		
		try {
			service.doService(request, response);
			
			list = new ArrayList<>();
			jobj=new JSONObject();
			out = response.getWriter();
			jAry = new JSONArray();
			
			list = (ArrayList<ThemeMemberNotepadVO>)request.getAttribute("nameContent");
			for(ThemeMemberNotepadVO vo: list) {
				JSONObject jTemp = new JSONObject();
				jTemp.put("themeName", vo.getThemeMember_name());
				jTemp.put("regdate", vo.getRegdate());
				jTemp.put("content", vo.getContent());
				
				jAry.add(jTemp);
			}
			jobj.put("contentName", jAry);
			out.println(jobj.toJSONString());
			
			//여기까지
			//System.out.println(nameContent);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
