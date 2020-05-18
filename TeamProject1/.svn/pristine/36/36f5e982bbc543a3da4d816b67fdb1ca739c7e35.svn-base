package kr.co.team.service.message;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.MemberDAO;
import kr.co.team.dao.MessageDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.MemberVO;
import kr.co.team.vo.MessageVO;

public class messageBoardService implements IService{
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		MessageDAO messageDAO=(MessageDAO)DAOManager.getDAO("MessageDAO");
		MemberDAO memberDAO=(MemberDAO)DAOManager.getDAO("MemberDAO");
		MessageVO messageVO=new MessageVO();
		MemberVO memberVO=new MemberVO();
		String memberID=(String)request.getSession().getAttribute("MemberID");
		
		if(memberID!=null) {
			
			int memberCode=(int) request.getSession().getAttribute("MemberCode");
			String type=request.getParameter("type");
			int currentNum=0;
			int section=10;
			int startNum=0;
			int totalTuple=messageDAO.getTotal(memberCode);
			System.out.println(totalTuple);
			int endNum=(totalTuple-1)/section+1;
			int headtuple;
	
			if(totalTuple!=0) {
				
				if(("first").equals(type)) {
					currentNum=1;
					startNum=currentNum;

					if(endNum>5) {
						endNum=5;
					}
				}else if(("last").equals(type)) {
					startNum=(endNum/5)*5+1;
					currentNum=endNum;
				}else if(("select").equals(type)) {
					currentNum=Integer.parseInt(request.getParameter("currentNum"));
					startNum=((currentNum-1)/5)*5+1;
					if(endNum>startNum+4) {
						endNum=startNum+4;
					}
					
				}else if(("next").equals(type)) {
					currentNum=Integer.parseInt(request.getParameter("currentNum"))+1;
					if(currentNum>endNum) {
						currentNum--;
					}
					startNum=((currentNum-1)/5)*5+1;
					if(endNum>startNum+4) {
						endNum=startNum+4;
					}
				}else if(("before").equals(type)) {
					currentNum=Integer.parseInt(request.getParameter("currentNum"))-1;
					if(currentNum<1) {
						currentNum=1;
					}
					startNum=((currentNum-1)/5)*5+1;
					if(endNum>startNum+4) {
						endNum=startNum+4;
					}
				}
				headtuple=(currentNum-1)*10;
				ArrayList<MessageVO> list=messageDAO.getMessageList(headtuple, memberCode);
				ArrayList<String> senderIDList=new ArrayList<String>();
				int isNotRead=messageDAO.getIsNotRead(memberCode);
				
				for(MessageVO message:list){
					String id=memberDAO.searchByCode(message.getSender_code());
					System.out.println(id);
					senderIDList.add(id);
				}
				request.setAttribute("list", list);
				request.setAttribute("startNum",startNum);
				request.setAttribute("endNum",endNum);
				request.setAttribute("senderIDList", senderIDList);
				request.setAttribute("isNotRead", isNotRead);
				System.out.println("dudfo"+startNum);
				System.out.println("dudfo"+endNum);
				System.out.println("dudfo"+senderIDList);
				

				
			}else {
				//암것두 없음
			}
			request.setAttribute("themeCode", "0");
		}else {
			request.setAttribute("themeCode", "1");
		}
	}
}
