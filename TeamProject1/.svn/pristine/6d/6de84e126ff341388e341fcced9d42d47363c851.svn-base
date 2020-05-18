package kr.co.team.service.group;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.GroupDAO;
import kr.co.team.dao.GroupToMemberThemeDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.GroupVO;
import kr.co.team.vo.ThemeMemberVO;

public class BringGroupThemeRelationService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		GroupToMemberThemeDAO groupToMemberThemeDAO=(GroupToMemberThemeDAO)DAOManager.getDAO("GroupToMemberThemeDAO");
		GroupVO groupVO =new GroupVO();
		ArrayList<ThemeMemberVO> list=new ArrayList<ThemeMemberVO>();
		String memberID=(String)request.getSession().getAttribute("MemberID");
		
		if(memberID!=null) {
			System.out.println(2);

			String memberCode=request.getParameter("memberCode");
			String theme=request.getParameter("theme");
			String groupCode=request.getParameter("groupCode");
			String type=request.getParameter("type");
			System.out.println(memberCode+theme+groupCode+type);
			list=groupToMemberThemeDAO.getRelation(memberCode,theme,groupCode,type);
			
			request.setAttribute("list", list);
			request.setAttribute("themeCode", "0");
		}else {
			request.setAttribute("themeCode", "1");
		}
	}
}