package kr.co.team.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.MemberDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.MemberVO;

public class MemberSearchPassService implements IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		MemberDAO dao=(MemberDAO)DAOManager.getDAO("MemberDAO");
		String type = request.getParameter("type");
		System.out.println(type);
		if(request.getParameter("type").equals("findPass")) {
			System.out.println(1);
			String id = request.getParameter("findID");
			String email = request.getParameter("findEmail");
			MemberVO member = new MemberVO();
			member.setId(id);
			member.setEmail(email);
			MemberVO memberVO = dao.findPass(member);
			if(memberVO != null) { //해당 비밀번호가 있으면
				request.setAttribute("findPass", "success"); //성공
				String findPass = memberVO.getPass(); //찾은 패스워드
				System.out.println(findPass);
				request.setAttribute("find", findPass); 
			}
			else { // 아이디나 메일번호가 잘못되어 해당 비밀번호가 없을시
				request.setAttribute("findIDByEmail", "fail");
			}
		}
	}
}
