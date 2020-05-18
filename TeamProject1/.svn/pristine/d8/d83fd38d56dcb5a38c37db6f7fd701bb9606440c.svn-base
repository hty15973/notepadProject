package kr.co.team.service.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.GroupDAO;
import kr.co.team.dao.GroupToMemberListDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.GroupVO;

public class GroupMakingService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		GroupDAO groupDAO=(GroupDAO)DAOManager.getDAO("GroupDAO");
		GroupToMemberListDAO groupToMemberListDAO=(GroupToMemberListDAO)DAOManager.getDAO("GroupToMemberListDAO");
		
		GroupVO groupVO =new GroupVO();
		String memberID=(String)request.getSession().getAttribute("MemberID");
		
		if(memberID!=null) {
			String groupName=request.getParameter("groupName");
			int memberCode=(int)request.getSession().getAttribute("MemberCode");
			groupVO.setGroup_leader_code(memberCode);
			groupVO.setGroup_name(groupName);
			if(groupDAO.searchBythemeNameAndCode(groupVO)!=null) {
				groupVO=groupDAO.searchBythemeNameAndCode(groupVO);
				request.setAttribute("successCode", "no");
			}else {
				groupVO=groupDAO.insert(groupVO);
				groupToMemberListDAO.insert(groupVO);
				request.setAttribute("successCode", "yes");
				
			}
			
			request.setAttribute("GroupCode", groupVO.getGroup_code());
			request.setAttribute("themeCode", "0");
		}else {
			request.setAttribute("themeCode", "1");
		}
	}
}
