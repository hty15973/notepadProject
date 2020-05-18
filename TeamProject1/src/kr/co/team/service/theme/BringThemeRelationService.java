package kr.co.team.service.theme;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.ThemeMemberDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.ThemeMemberVO;

public class BringThemeRelationService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ThemeMemberDAO themeMemberDAO=(ThemeMemberDAO)DAOManager.getDAO("ThemeMemberDAO");
	
		ThemeMemberVO themeMemberVO=new ThemeMemberVO();
		String memberID=(String)request.getSession().getAttribute("MemberID");
		
		if(memberID!=null) {
			int memberCode=(int)request.getSession().getAttribute("MemberCode");
			
			String type=(String)request.getParameter("type");
			String theme=(String)request.getParameter("theme");
			
			System.out.println(type);
			System.out.println(theme);
			
			
			ArrayList<String> list=null;
			list=themeMemberDAO.getRelation(type, theme,memberCode);
			System.out.println(list.size());
			request.setAttribute("list", list);
			request.setAttribute("themeCode", "0");
		}else {
			request.setAttribute("themeCode", "1");
		}
	}
}
