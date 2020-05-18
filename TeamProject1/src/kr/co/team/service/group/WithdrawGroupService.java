package kr.co.team.service.group;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.GroupDAO;
import kr.co.team.dao.GroupToMemberListDAO;
import kr.co.team.dao.GroupToMemberThemeDAO;
import kr.co.team.dao.ThemeMemberDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.GroupVO;

public class WithdrawGroupService implements IService {
	
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		ThemeMemberDAO themeMemberDAO = (ThemeMemberDAO)DAOManager.getDAO("ThemeMemberDAO");
		GroupToMemberThemeDAO groupToMemberThemeDAO = (GroupToMemberThemeDAO)DAOManager.getDAO("GroupToMemberThemeDAO");
		GroupToMemberListDAO groupToMemberListDAO = (GroupToMemberListDAO)DAOManager.getDAO("GroupToMemberListDAO");
		GroupDAO groupDAO = (GroupDAO)DAOManager.getDAO("GroupDAO");
//		ThemeMemberVO themeMemberVO = new ThemeMemberVO();
//		GroupToMemberThemeVO groupToMemberThemeVO = new GroupToMemberThemeVO();
//		GroupToMemberListVO groupToMemberListVO = new GroupToMemberListVO();
		
		String memberID=(String)request.getSession().getAttribute("MemberID");
		boolean check = false;
		int count = 0;
		if(memberID != null) {
			int code = (int)request.getSession().getAttribute("MemberCode"); //로그인시 세션에 저장되어있는 멤버코드 
			int groupCode = Integer.parseInt(request.getParameter("groupCode")); //ajax에서 받기!! 숨겨놓은 그룹코드
			check = groupDAO.checkLeader(code, groupCode);
			count = groupToMemberListDAO.countList(groupCode);
			if(check == true) { //나가려고하는 사람이 그룹장이면
				if(count > 1) { // 나 이외에 다른사람들 남아있으면
					request.setAttribute("leaderCheck", "true"); //그룹리더이다true
				}
				else { // 나 혼자만 남아있을때
					groupToMemberListDAO.delete(code, groupCode);
					groupToMemberThemeDAO.delete(code, groupCode);
					groupDAO.delete(groupCode);
					request.setAttribute("leaderCheck", "trueAlone");
				}
			}
			else { //나가려는 사람이 일반회원이면
				groupToMemberListDAO.delete(code, groupCode); //리스트에서 삭제
				groupToMemberThemeDAO.delete(code, groupCode); //그룹to회원테마에서 삭제
				request.setAttribute("leaderCheck", "false"); // 일반 회원이므로 관련 테이블 다 삭제하고 리더가 아니라는것 attribute에 저장
			}
		}
		else {
			;
		}
	}
}
