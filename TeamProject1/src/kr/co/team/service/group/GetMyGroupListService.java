package kr.co.team.service.group;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.GroupDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.GroupVO;

public class GetMyGroupListService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		GroupDAO groupDAO=(GroupDAO)DAOManager.getDAO("GroupDAO");
		String memberID=(String)request.getSession().getAttribute("MemberID");
		ArrayList<GroupVO> myGroupList=new ArrayList<>();
		if(memberID!=null) {
			int memberCode=(int)request.getSession().getAttribute("MemberCode");
			myGroupList=groupDAO.getGroupList(memberCode);
			System.out.println(myGroupList.size());
			request.setAttribute("myGroupList", myGroupList);
			request.setAttribute("themeCode", "0");
		}else {
			request.setAttribute("themeCode", "1");
		}
	}
}
