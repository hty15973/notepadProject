package kr.co.team.service.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.team.dao.GroupToMemberListDAO;
import kr.co.team.dao.MessageDAO;
import kr.co.team.listener.DAOManager;
import kr.co.team.service.IService;
import kr.co.team.vo.MessageVO;

public class SendMessageService implements IService{
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception{
		MessageDAO messageDAO =(MessageDAO)DAOManager.getDAO("MessageDAO");
		GroupToMemberListDAO groupToMemberListDAO = (GroupToMemberListDAO)DAOManager.getDAO("GroupToMemberListDAO"); 
		
		String memberID = (String)request.getSession().getAttribute("MemberID");
		int code = (int)request.getSession().getAttribute("MemberCode");
		
		String receiverID = (String)request.getParameter("receiverID");
		
		String groupName = (String)request.getParameter("groupName");
		
		if(request.getParameter("type").equals("invite")) {
			String inviteMessage = null;
			inviteMessage = "<div id='invite'><ul><li>'"+memberID+"'가'"+groupName+"'그룹에 초대하였습니다 </ul><ul><li><button id='inviteAcceptBtn'>수락</button><button id='inviteRefuseBtn'>거절</button></li></ul></div>";
			if(request.getParameter("receiverID").equals(memberID)) { //나 자신을 초대하는것이라면
				request.setAttribute("yesno", "no");
			}
			else { //상대방을 초대하는것이라면
				messageDAO.insert(receiverID, code, inviteMessage);
				request.setAttribute("yesno", "yes");
			}
		}
		else if(request.getParameter("type").equals("normal")) {
			String messageContent = (String)request.getParameter("content");
			messageDAO.insert(receiverID, code ,messageContent);
			request.setAttribute("yesno", "yes");
			
		}
		else if(request.getParameter("type").equals("request")) {
			String requestMessage = null;
			requestMessage = "<div id='request'><ul><li>'"+memberID+"'가 '"+groupName+"'그룹에 가입을 요청하였습니다 </ul><ul><li><button id='requestAcceptBtn'>수락</button><button id='requestRefuseBtn'>거절</button>";
			if(request.getParameter("receiverID").equals(memberID)) { // 그룹장이 자신인 그룹에 가입요청이 자기자신일때
				request.setAttribute("yesno", "no");
			}
			else { //그룹장이 다른사람인 그룹에 정상적으로 가입요청을 할때
				messageDAO.insert(receiverID, code, requestMessage);
				request.setAttribute("yesno", "yes");
			}
		}
		
		
		//상대방이 수락/거절 메세지를 받았다는 가정하에.
		else if(request.getParameter("type").equals("inviteAccept")){ //초대메세지에 대해서 수락버튼 눌렀을 경우
			int messageCode = Integer.parseInt(request.getParameter("messageCode"));
			String myInviteAcceptMessage = "<div id='myInviteAccept'><ul><li>'"+memberID+"'의'"+groupName+"'그룹에 수락하였습니다 </ul></div>"; //수락햇을때 내거 바뀌는 메세지
			String partnerInviteAcceptMessage = "<div id='partnerInviteAccept'><ul><li>'"+receiverID+"'님이'"+groupName+"'그룹에 수락하였습니다 </ul></div>"; //수락햇을경우 상대방한테 가는메세지
			
			groupToMemberListDAO.insert(groupName, code, receiverID); //리스트에 추가
			
			messageDAO.update(messageCode, myInviteAcceptMessage); //내거의 메세지 업데이트 수락/거절 버튼 사라지게
			messageDAO.insert(receiverID,code,partnerInviteAcceptMessage); //상대방한테 가는 메세지 '~님이 수락하였습니다'
			request.setAttribute("inviteAccept", "yes");
			
		}
		else if(request.getParameter("type").equals("inviteRefuse")) { //초대메세지에 대해서 거부버튼 눌렀을경우
			int messageCode = Integer.parseInt(request.getParameter("messageCode"));
			String myInviteRefuseMessage = "<div id='myInviteRefuse'><ul><li>'"+memberID+"'의'"+groupName+"'그룹에 거부하였습니다 </ul></div>"; // 거부했을때 내꺼 바뀌는 메세지
			String partnerInviteRefuseMessage ="<div id='partnerInviteRefuse'><ul><li>'"+receiverID+"'님이'"+groupName+"'그룹에 거부하였습니다 </ul></div>";  //거부했을때 상대방꺼 가는 메세지
			
			messageDAO.update(messageCode, myInviteRefuseMessage);
			messageDAO.insert(receiverID, code,partnerInviteRefuseMessage);
			request.setAttribute("inviteAccept", "no");
		
		}
		
		else if(request.getParameter("type").equals("requestAccept")) { //요청에 대해서 수락했을경우
			int messageCode = Integer.parseInt(request.getParameter("messageCode"));
			String myRequestAceeptMessage = "<div id='myRequestAccept'><ul><li>'"+receiverID+"'의'"+groupName+"'그룹요청에 수락하였습니다 </ul></div>";
			String partnerRequestRefuseMessage = "<div id='partnerRequestAccept'><ul><li>'"+memberID+"'님의'"+groupName+"'그룹에 들어갔습니다 </ul></div>";
			
			groupToMemberListDAO.insert(groupName, receiverID, code); //리스트에 추가
			
			messageDAO.update(messageCode, myRequestAceeptMessage);
			messageDAO.insert(receiverID, code, partnerRequestRefuseMessage);
			request.setAttribute("requestAccept", "yes");
		}
		else if(request.getParameter("type").equals("requestRefuse")) { //요청에 대해서 거부했을경우
			int messageCode = Integer.parseInt(request.getParameter("messageCode"));
			String myRequestRefuseMessage = "<div id='myRequestRefuse'><ul><li>'"+receiverID+"'의'"+groupName+"'그룹요청에 거절하였습니다 </ul></div>";
			String partnerRequestRefuseMessage = "<div id='partnerRequestRefuse'><ul><li>'"+memberID+"'님의'"+groupName+"'그룹에 거절당하였습니다 </ul></div>";
			
			messageDAO.update(messageCode, myRequestRefuseMessage);
			messageDAO.insert(receiverID, code, partnerRequestRefuseMessage);
			request.setAttribute("requestAccept", "no");
		}
	}
}
