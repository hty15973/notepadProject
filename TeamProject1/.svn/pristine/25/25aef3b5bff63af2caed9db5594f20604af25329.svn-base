package kr.co.team.service.notepad;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.ThemeMemberNotepadDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.ThemeMemberNotepadVO;


public class ClassifiedByDateService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ThemeMemberNotepadDAO dao = (ThemeMemberNotepadDAO)DAOManager.getDAO("ThemeMemberNotepadDAO");
		
		ArrayList<String> getList = new ArrayList<>();
		
		//ThemeMemberVO themememberVO = new ThemeMemberVO();
		//NotepadVO notepadVO = new NotepadVO();
		String memberID = (String)request.getSession().getAttribute("MemberID");
		
		if(memberID != null) {
			int code=(int)request.getSession().getAttribute("MemberCode");
			if(dao.getList(code)!= null) {
				getList = dao.getList(code);
				request.setAttribute("dates", getList);
			}
			else {
				;
			}
		}
		else {
			;
		}
		
	}
}
