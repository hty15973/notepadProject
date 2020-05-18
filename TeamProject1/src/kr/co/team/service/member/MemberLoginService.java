package kr.co.team.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.team.dao.MemberDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.MemberVO;

public class MemberLoginService implements IService {
	
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		MemberDAO dao=(MemberDAO)DAOManager.getDAO("MemberDAO");
		if(request.getParameter("type").equals("login")) {
			
			dao = (MemberDAO)DAOManager.getDAO("MemberDAO");
			String id = request.getParameter("user_id");
			String pass = request.getParameter("user_pass");
			
			MemberVO member = new MemberVO();
			member.setId(id);
			member.setPass(pass);
			MemberVO memberVO= dao.login(member);
			
			if(memberVO!=null) {
				HttpSession session= request.getSession();
				session.setAttribute("MemberCode", memberVO.getMember_code());
				session.setAttribute("MemberID", memberVO.getId());
				session.setAttribute("MemberPass", memberVO.getPass());
				
				request.setAttribute("URL", "/index.jsp"); //setAttribute에서 key를 URL로
			}
			else {
				request.setAttribute("URL", "/login.jsp");
			}
	
		}
		else if(request.getParameter("type").equals("register")) {
			request.setAttribute("URL", "/register.jsp");
			
		}
		else if(request.getParameter("type").equals("searchLogin")) {
			request.setAttribute("URL", "/findID.jsp");
			
		}
		else if(request.getParameter("type").equals("searchPass")) {
			request.setAttribute("URL", "/findPass.jsp");
			
		}
	}
}
