package kr.co.team.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.team.dao.MemberDAO;
import kr.co.team.dao.ThemeMemberDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.MemberVO;
import kr.co.team.vo.ThemeMemberVO;

public class MemberDeleteService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		MemberDAO dao=(MemberDAO)DAOManager.getDAO("MemberDAO");
		dao = (MemberDAO)DAOManager.getDAO("MemberDAO");
		String id = request.getParameter("user_id");
		String pass = request.getParameter("user_pass");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPass(pass);
		MemberVO memberVO= dao.login(member);
		
		if(memberVO!=null) {
			
			dao.delete(memberVO);
			request.setAttribute("message", "ok");
		}
		else {
			request.setAttribute("message","no");
		}
	
		
	}
}
