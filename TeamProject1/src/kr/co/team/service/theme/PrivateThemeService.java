package kr.co.team.service.theme;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.GroupToMemberThemeDAO;
import kr.co.team.service.IService;

public class PrivateThemeService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		GroupToMemberThemeDAO groupToMemberThemeDAO = new GroupToMemberThemeDAO(); 
		
		String memberID=(String)request.getSession().getAttribute("MemberID");
		int code = Integer.parseInt(request.getParameter("memberCode"));//클릭한 멤버코드
		String themeName = (String)request.getParameter("theme"); //클릭한 테마명
		int groupCode = Integer.parseInt(request.getParameter("groupCode")); //클릭한 그룹코드
		
		if(memberID != null) {
			int myCode=(int)request.getSession().getAttribute("MemberCode"); //회원코드
			if(myCode == code) { //내 회원코드와 클릭한 회원코드가 일치. 즉 내꺼의 공유테마를 숨기려할때! 가능함ㅇ
				request.setAttribute("isMine", "true");
				groupToMemberThemeDAO.delete(code, groupCode, themeName); 
			}
			else { //상대방의 테마를 숨기는것. 불가능x
				request.setAttribute("isMine", "false");
			}
		}
		else {
			;
		}
	}
}
