 package kr.co.team.controller.member;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.member.MemberDeleteService;

public class MemberDeleteController implements BackController {
	IService service;
	
	public MemberDeleteController() {
		service = new MemberDeleteService();
	}
	
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
