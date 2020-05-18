package kr.co.team.service.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.GroupDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.GroupVO;

public class SearchLeaderGroupService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		GroupDAO groupDAO = (GroupDAO)DAOManager.getDAO("GroupDAO");
		
		String groupName = (String)request.getParameter("groupName");
		String memberID =(String)request.getSession().getAttribute("MemberID");
		int code =  (int)request.getSession().getAttribute("MemberCode"); //로그인시 세션에 저장되어있는 멤버코드 
		boolean result = false;
		
		result = groupDAO.searchLeader(groupName, code);
		
		if(result == true) { //내가 그룹장인 그룹에 해당 그룹이 존재하면
			request.setAttribute("isExist", "yes");
		}
		else { //내 그룹에 그런그룹이 없다면
			request.setAttribute("isExist", "no");
		}
		
	}
}
