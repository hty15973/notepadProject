package kr.co.team.service.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.GroupToMemberThemeDAO;
import kr.co.team.dao.ThemeMemberDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;

public class SetThemeSharedService implements IService{

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ThemeMemberDAO themeMemberDAO = (ThemeMemberDAO)DAOManager.getDAO("ThemeMemberDAO");
		GroupToMemberThemeDAO groupToMemberThemeDAO = (GroupToMemberThemeDAO)DAOManager.getDAO("GroupToMemberThemeDAO");
		
		int groupCode = Integer.parseInt(request.getParameter("groupCode"));
		int myCode = (int)request.getSession().getAttribute("MemberCode");
		String themeName = request.getParameter("themeName");
		boolean result = themeMemberDAO.isTheme(myCode, themeName);
		int count = 0;
		
		if(result == true) { //회원에게 그 테마가 존재하면
			count = groupToMemberThemeDAO.count(groupCode, myCode, themeName);
			if(count > 0) {
				request.setAttribute("isTheme", "false");
			}
			else {
				groupToMemberThemeDAO.insert(groupCode, myCode, themeName);
				request.setAttribute("isTheme", "true");
			}
		}
		else { //회원에게 그 테마가 존재하지않으면
			request.setAttribute("isTheme", "false");
		}
	}
}
