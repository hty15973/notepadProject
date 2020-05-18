package kr.co.team.controller.message;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.team.controller.BackController;
import kr.co.team.service.IService;
import kr.co.team.service.message.messageBoardService;
import kr.co.team.vo.MessageVO;

public class MessageBoardController implements BackController{
	IService service =new messageBoardService();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		JSONObject jobj=null;
		try {
			service.doService(request, response);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			out=response.getWriter();
			jobj=new JSONObject();
			ArrayList<MessageVO> messageList=(ArrayList<MessageVO>)request.getAttribute("list");
			ArrayList<String> senderIDList=(ArrayList<String>)request.getAttribute("senderIDList");
			int endNum=(int)request.getAttribute("endNum");
			int startNum=(int)request.getAttribute("startNum");
			int isNotRead=(int)request.getAttribute("isNotRead");
			
			JSONArray jAry1=new JSONArray();
			JSONArray jAry2=new JSONArray();
			
			
			for(int i=0;i<messageList.size();i++) {
				JSONObject jtemp=new JSONObject();
				jtemp.put("senderID",senderIDList.get(i));
				jtemp.put("date",messageList.get(i).getRegdate());
				jtemp.put("content",messageList.get(i).getContent());
				jtemp.put("messageCode", messageList.get(i).getMessage_code());
				jtemp.put("isNotRead", messageList.get(i).getIsRead());
				jAry1.add(jtemp);
				
			}
			JSONObject jtemp=new JSONObject();
			jtemp.put("startNum", startNum);
			jtemp.put("endNum", endNum);
			jtemp.put("isNotReadTotal", isNotRead);
			jAry2.add(jtemp);
			
			jobj.put("list", jAry1);
			jobj.put("num",jAry2);
			out.println(jobj.toJSONString());
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}
}
