package kr.co.team.service.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.MemberDAO;
import kr.co.team.dao.MessageDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.MemberVO;
import kr.co.team.vo.MessageVO;

public class DeleteMessageService implements IService{
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		MessageDAO messageDAO=(MessageDAO)DAOManager.getDAO("MessageDAO");
		String memberID=(String)request.getSession().getAttribute("MemberID");
		
		if(memberID!=null) {
		String messageCode=request.getParameter("messageCode");
		messageDAO.deleteMessage(messageCode);

			request.setAttribute("themeCode", "0");
		}else {
			request.setAttribute("themeCode", "1");
		}
	}
}
