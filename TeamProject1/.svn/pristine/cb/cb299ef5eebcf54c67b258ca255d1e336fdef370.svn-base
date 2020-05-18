package kr.co.team.service.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.GroupDAO;
import kr.co.team.dao.GroupToMemberListDAO;
import kr.co.team.dao.GroupToMemberThemeDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;

public class GroupExpelService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		GroupToMemberThemeDAO groupToMemberThemeDAO = (GroupToMemberThemeDAO)DAOManager.getDAO("GroupToMemberThemeDAO");
		GroupToMemberListDAO groupToMemberListDAO = (GroupToMemberListDAO)DAOManager.getDAO("GroupToMemberListDAO");
		GroupDAO groupDAO = (GroupDAO)DAOManager.getDAO("GroupDAO");
		
		String memberID = (String)request.getSession().getAttribute("MemberID");
		boolean check = false;
		if(memberID != null) {
			int myCode = (int)request.getSession().getAttribute("MemberCode"); //나의 코드
			int code = Integer.parseInt(request.getParameter("memberCode")); //클릭한 이름에 대한 코드
			int groupCode = Integer.parseInt(request.getParameter("groupCode")); //해당되는 그룹코드
			check = groupDAO.checkLeader(myCode, groupCode); //클릭한 사람이 방장인지 체크
			if(check == true) { //추방하려는 사람이 그룹장이면
				if(myCode != code) {
					groupToMemberListDAO.delete(code, groupCode);
					groupToMemberThemeDAO.delete(code, groupCode);
					request.setAttribute("leaderCheck", "true");
					request.setAttribute("object", "other");
				}
				else {
					request.setAttribute("leaderCheck", "true");
					request.setAttribute("object", "me");
				}
			}
			else { //추방하려는 사람이 일반회원이면
				request.setAttribute("leaderCheck", "false");
				request.setAttribute("object", null);
			}
		}
	}
}
