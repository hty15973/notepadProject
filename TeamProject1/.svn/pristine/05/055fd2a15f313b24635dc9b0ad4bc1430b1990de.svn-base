package kr.co.team.controller.group;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.group.GetGroupMemberListService;
import kr.co.team.vo.MemberVO;


public class GetGroupMemberListController implements BackController {
	IService service=new GetGroupMemberListService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		JSONObject jobj=null;	
		try {
			service.doService(request, response);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			out=response.getWriter();
			
			ArrayList<MemberVO> groupMemberList=(ArrayList<MemberVO>)request.getAttribute("groupMemberList");
			System.out.println(groupMemberList.size());
			jobj=new JSONObject();
			JSONArray jAry=new JSONArray();
			for(MemberVO groupMember:groupMemberList) {
				JSONObject jtemp=new JSONObject();
				jtemp.put("id", groupMember.getId());
				jtemp.put("memberCode", groupMember.getMember_code());
				jAry.add(jtemp);
			}
			jobj.put("groupMemberList", jAry);
			out.println(jobj.toJSONString());
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}
}
