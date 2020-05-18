package kr.co.team.controller;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class MyWebSocket {
   @OnOpen
   public void onOpen(Session session) {
	   Client.addSession(session);
   }
   
   @OnMessage
   public void onMessage(Session session, String message){
	   Client.sendMessage(message);
   }
   @OnError
   public void onError(Session session, Throwable t) {
   }
   @OnClose
   public void onClose(Session session) {
	   Client.removeSession(session);
   }
}
