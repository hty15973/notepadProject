package kr.co.team.service.member;

import java.io.PrintWriter;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.MemberDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.MemberVO;

public class MemberSearchByIDService implements IService {
	

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		MemberDAO dao =(MemberDAO)DAOManager.getDAO("MemberDAO");
		PrintWriter out = null;
		boolean result=false;
		out= response.getWriter();
		if(request.getParameter("selectOption").equals("byName")) {
			String keyword=request.getParameter("keyword");
			String list = dao.serachByID(keyword);
			if(list != null) {
				result=true;
			}
			request.setAttribute("list", list);
			request.setAttribute("result",result);
		}
		else if(request.getParameter("selectOption").equals("byGroup")) {
			String keyword=request.getParameter("keyword");
			String list = dao.serachByID(keyword);
			if(list != null) {
				result=true;
			}
			request.setAttribute("list", list);
			request.setAttribute("result",result);
		}
	}
}
