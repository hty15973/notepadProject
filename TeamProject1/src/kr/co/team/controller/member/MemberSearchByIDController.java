package kr.co.team.controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.member.MemberSearchByIDService;

public class MemberSearchByIDController implements BackController {
	IService service;

	public MemberSearchByIDController() {
		service = new MemberSearchByIDService();
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		try {
			service.doService(request, response);
			PrintWriter out = null;
			out=response.getWriter();
			String list = (String)request.getAttribute("list");
			boolean result = (boolean)request.getAttribute("result");
			if(result=true) {
				if(list!=null) {
					out.println(list);
				}
				else {
					out.println("데이터가 비어있음");
				}
				
			}
			else {
				out.println("result가 null임");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
