package kr.co.team.controller.notepad;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.notepad.ContentInsertService;

public class ContentInsertController implements BackController {
	IService service=new ContentInsertService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		try {
			service.doService(request, response);
			response.setCharacterEncoding("utf-8");
			out=response.getWriter();
			String data=(String) request.getAttribute("notepadCode");
			out.println(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}
}
