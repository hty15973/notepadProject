package kr.co.team.service.notepad;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.NotepadDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.NotepadVO;

public class GetThemeContentService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		NotepadDAO notepadDAO=(NotepadDAO)DAOManager.getDAO("NotepadDAO");
		String memberID=(String)request.getSession().getAttribute("MemberID");
		ArrayList<NotepadVO> notepadList=new ArrayList<>(); 
		if(memberID!=null) {
			
			String memberCode=request.getParameter("memberCode");
			System.out.println(memberCode);

			if("-1".equals(memberCode)){
			
				
				int temp=(int)request.getSession().getAttribute("MemberCode");
				memberCode=String.valueOf(temp);
			}
			String themeName=request.getParameter("themeName");
		
			notepadList=notepadDAO.getContent(memberCode, themeName);
			System.out.println(notepadList.size());
			request.setAttribute("notepadList", notepadList);
			request.setAttribute("themeCode", "0");
		}else {
			request.setAttribute("themeCode", "1");
		}
	}
}
