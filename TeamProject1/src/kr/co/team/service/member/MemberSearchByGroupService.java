package kr.co.team.service.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.GroupDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.GroupVO;

public class MemberSearchByGroupService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
	GroupDAO groupDAO=(GroupDAO)DAOManager.getDAO("GroupDAO");
		
		
		GroupVO groupVO =new GroupVO();
		String memberID=(String)request.getSession().getAttribute("MemberID");
		
		if(memberID!=null) {
			String groupName=request.getParameter("groupName");
			groupVO.setGroup_name(groupName);
			ArrayList<String> leaderNameList=null;
			leaderNameList=groupDAO.searchBythemeName(groupVO);	
			System.out.println(leaderNameList.size());
			request.setAttribute("leaderNameList", leaderNameList);
			request.setAttribute("themeCode", "0");
		}else {
			request.setAttribute("themeCode", "1");
		}
	}
	
}
