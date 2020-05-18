package kr.co.team.controller.notepad;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.notepad.ClassifiedByDateService;
import kr.co.team.vo.ThemeMemberNotepadVO;

public class ClassifiedByDateController implements BackController {
	IService service;
	
	public ClassifiedByDateController() {
		service = new ClassifiedByDateService();
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> dates = null;
		PrintWriter out = null;
		JSONObject jobj=null;
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		System.out.println(1);
		try {
			service.doService(request, response); //dates라는 attribute 들어옴(날짜들어있는 list<vo객체>)
			jobj = new JSONObject();
			dates = new ArrayList<>();
			out = response.getWriter();
			dates = (ArrayList<String>)request.getAttribute("dates");
			for(int i=0;i<dates.size();i++) {
				jobj.put(i,dates.get(i));
				
			}
			out.println(jobj.toJSONString());
			//여기까지
			//System.out.println(dates);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
