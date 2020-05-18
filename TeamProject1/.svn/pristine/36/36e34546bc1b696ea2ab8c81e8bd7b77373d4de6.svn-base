package kr.co.team.service.member;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.MemberDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.MemberVO;

public class MemberRegisterService implements IService {

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		MemberDAO dao=(MemberDAO)DAOManager.getDAO("MemberDAO");
		
		
		if(request.getParameter("type").equals("register")) {
			
			String member_name = request.getParameter("register_name");
			String id = request.getParameter("register_id");
			String pass = request.getParameter("register_password");
			String email = request.getParameter("register_email");
		
			MemberVO member = new MemberVO();
			member.setMember_name(member_name);
			member.setId(id);
			member.setPass(pass);
			member.setEmail(email);
			dao.register(member);

			request.setAttribute("URL", "/login.jsp");

		}
		else if(request.getParameter("type").equals("duplicate")){
			
			
			
			String id = request.getParameter("id");
			MemberVO member = new MemberVO();
			member.setId(id);
			MemberVO memberVO = new MemberVO();
			
			memberVO = dao.duplicateId(member);
			if(memberVO == null) { //¼º°ø
				request.setAttribute("dupli", "success");
			}
			else {
				request.setAttribute("dupli", "fail");
			}
		}
		
		else if(request.getParameter("type").equals("cancel")){
			request.setAttribute("URL", "/login.jsp");
		}
		

	}
}
