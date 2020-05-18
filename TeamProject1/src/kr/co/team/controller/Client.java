package kr.co.team.controller;

import java.util.ArrayList;

import javax.websocket.Session;

public class Client {
	   private static ArrayList<Session> clients;
	   
	   static {
	      clients = new ArrayList<>();
	   }
	   public static void addSession(Session session) {
	      clients.add(session);
	   }
	   
	   public static void sendMessage(String message) {
	      for(Session s : clients) {
	         if(s.isOpen()) {
	            try {
	               s.getBasicRemote().sendText(message);
	            }
	            catch(Exception e) {
	               e.printStackTrace();
	            }
	         }
	      }
	   }
	   public static void removeSession(Session session) {
	      clients.remove(session);
	   }
	}