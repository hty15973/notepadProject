package kr.co.team.controller.group;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.group.GetMyGroupListService;
import kr.co.team.vo.GroupVO;

public class GetMyGroupListController implements BackController {
	IService service=new GetMyGroupListService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		JSONObject jobj=null;	
		try {
			service.doService(request, response);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			out=response.getWriter();
			ArrayList<GroupVO> myGroupList=(ArrayList<GroupVO>)request.getAttribute("myGroupList");
			System.out.println(myGroupList.size());
			jobj=new JSONObject();
			JSONArray jAry=new JSONArray();
			for(GroupVO group:myGroupList) {
				JSONObject jtemp=new JSONObject();
				jtemp.put("groupCode", group.getGroup_code());
				jtemp.put("groupName", group.getGroup_name());
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