package kr.co.team.service.group;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.GroupToMemberThemeDAO;
import kr.co.team.dao.ThemeMemberDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;

public class SetThemeSharedIsMineService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//ThemeMemberDAO themeMemberDAO = (ThemeMemberDAO)DAOManager.getDAO("ThemeMemberDAO");
		//GroupToMemberThemeDAO groupToMemberThemeDAO = (GroupToMemberThemeDAO)DAOManager.getDAO("GroupToMemberThemeDAO");
		
		int myCode = (int)request.getSession().getAttribute("MemberCode");
		int code = Integer.parseInt(request.getParameter("memberCode"));
		//int groupCode = Integer.parseInt(request.getParameter("groupCode")); //해당되는 그룹코드
		//boolean check = false;
		if(code == myCode) { //+클릭이 내거에서 한 경우에
			request.setAttribute("isMine", "true");
		}
		else { // 상대방거에서 +버튼을 눌럿을 경우에
			request.setAttribute("isMine", "false");
		}
	}
	
}
