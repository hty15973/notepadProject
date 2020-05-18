package kr.co.team.service.notepad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.NotepadDAO;
import kr.co.team.dao.ThemeMemberDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.NotepadVO;
import kr.co.team.vo.ThemeMemberVO;

public class ContentInsertService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		NotepadDAO notepadDAO=(NotepadDAO)DAOManager.getDAO("NotepadDAO");
		ThemeMemberDAO themeMemberDAO=(ThemeMemberDAO)DAOManager.getDAO("ThemeMemberDAO");
	
		NotepadVO notepadVO=new NotepadVO();
		ThemeMemberVO themeMemberVO=new ThemeMemberVO();
		String memberID=(String)request.getSession().getAttribute("MemberID");

		if(memberID!=null) {
			int code=(int)request.getSession().getAttribute("MemberCode");
			String theme=(String)request.getParameter("themes");
			String content=(String)request.getParameter("contents");
			themeMemberVO.setMember_code(code);
			themeMemberVO.setThemeMember_name(theme);
			
			
			if(themeMemberDAO.searchBythemeName(themeMemberVO)!=null) {
				themeMemberVO=themeMemberDAO.searchBythemeName(themeMemberVO);
			}
			else {
				themeMemberDAO.insert(themeMemberVO);
			}
			notepadVO.setThemeMember_code(themeMemberVO.getThemeMember_code());
			notepadVO.setContent(content);
			notepadDAO.insert(notepadVO);
			request.setAttribute("notepadCode", "0");
			
		}else {
			request.setAttribute("notepadCode", "1");
		}
		
		

		
	}
}
