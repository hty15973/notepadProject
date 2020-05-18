package kr.co.team.controller.notepad;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.notepad.GetThemeContentService;
import kr.co.team.vo.NotepadVO;

public class GetThemeContentController implements BackController {
	IService service=new GetThemeContentService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		JSONObject jobj=null;	
		try {
			service.doService(request, response);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			out=response.getWriter();
			ArrayList<NotepadVO> notepadList=(ArrayList<NotepadVO>)request.getAttribute("notepadList");
			System.out.println(notepadList.size());
			jobj=new JSONObject();
			JSONArray jAry=new JSONArray();
			for(NotepadVO notepad:notepadList) {
				JSONObject jtemp=new JSONObject();
				jtemp.put("content", notepad.getContent());
				jtemp.put("regdate", notepad.getRegdate());
				jAry.add(jtemp);
			}
			jobj.put("myGroupList", jAry);
			out.println(jobj.toJSONString());
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}
}
