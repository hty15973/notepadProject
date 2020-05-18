package kr.co.team.service.notepad;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.ThemeMemberNotepadDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.ThemeMemberNotepadVO;

public class GetDateContentService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ThemeMemberNotepadDAO dao = (ThemeMemberNotepadDAO)DAOManager.getDAO("ThemeMemberNotepadDAO");
		
		ArrayList<ThemeMemberNotepadVO> getNameContent = new ArrayList<>();
		
		String memberID = (String)request.getSession().getAttribute("MemberID");
		String date = (String)request.getParameter("date"); //date·Î ¹Þ±â
		if(memberID != null) {
			int code=(int)request.getSession().getAttribute("MemberCode");
			if(dao.getContent(code, date)!=null) {
				getNameContent = dao.getContent(code, date);
				
				request.setAttribute("nameContent", getNameContent);
			}
			else {
				;
			}
		}
	}
}
