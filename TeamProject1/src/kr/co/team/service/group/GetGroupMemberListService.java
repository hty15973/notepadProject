package kr.co.team.service.group;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.MemberDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.MemberVO;

public class GetGroupMemberListService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		MemberDAO memberDAO=(MemberDAO)DAOManager.getDAO("MemberDAO");
		String memberID=(String)request.getSession().getAttribute("MemberID");
		ArrayList<MemberVO> groupMemberList =new ArrayList<>();
		if(memberID!=null) {
			String groupCode=(String)request.getParameter("groupCode");
			groupMemberList=memberDAO.getGroupMemberList(groupCode);
			System.out.println(groupMemberList.size());
			request.setAttribute("groupMemberList", groupMemberList);
			request.setAttribute("themeCode", "0");

		}else {
			request.setAttribute("themeCode", "1");
		}
	}
	
}
