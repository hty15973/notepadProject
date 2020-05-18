package kr.co.team.service.notepad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.NotepadDAO;
import kr.co.team.dao.ThemeMemberDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.NotepadVO;
import kr.co.team.vo.ThemeMemberVO;

public class UpdateContentService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		NotepadDAO notepadDAO=(NotepadDAO)DAOManager.getDAO("NotepadDAO");
		ThemeMemberDAO themeMemberDAO=(ThemeMemberDAO)DAOManager.getDAO("ThemeMemberDAO");
		
		String content=(String)request.getParameter("content");
		String themeName=(String)request.getParameter("themeName");
		String date=(String)request.getParameter("date");
		String memberID=(String)request.getSession().getAttribute("MemberID");
		int memberCode=(int)request.getSession().getAttribute("MemberCode");
		if(memberID!=null) {
			ThemeMemberVO m= new ThemeMemberVO();
			NotepadVO m2=new NotepadVO();
			m.setMember_code(memberCode);
			m.setThemeMember_name(themeName);
			m=themeMemberDAO.searchBythemeName(m);
			m2.setContent(content);
			m2.setThemeMember_code(m.getThemeMember_code());
			m2.setRegdate(date);
			notepadDAO.updateContent(m2);
			request.setAttribute("notepadCode", "0");
			
		}else {
			request.setAttribute("notepadCode", "1");
		}
	}
}
