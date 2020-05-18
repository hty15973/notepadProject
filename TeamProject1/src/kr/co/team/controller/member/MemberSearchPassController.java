package kr.co.team.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.member.MemberSearchPassService;

public class MemberSearchPassController implements BackController {
	IService service;
	
	public MemberSearchPassController() {
		service = new MemberSearchPassService();
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String findPass = null;
		PrintWriter out = null;
		response.setCharacterEncoding("utf-8");

		try {
			System.out.println(111);
			service.doService(request, response);
			out = response.getWriter();
			findPass = (String)request.getAttribute("findPass"); //success or fail 둘중하나
			if(findPass != null) {
				String pass = (String)request.getAttribute("find"); //비밀번호
				System.out.println(pass);
				out.println(pass); //성공시 패스워드를 ajax로
			}
			else {
				out.println(0); // 실패시 0을 ajax로
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
