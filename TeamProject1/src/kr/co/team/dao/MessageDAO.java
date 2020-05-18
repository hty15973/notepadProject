package kr.co.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import kr.co.team.controller.DbManager;
import kr.co.team.vo.MessageVO;
import kr.co.team.vo.ThemeMemberVO;

public class MessageDAO {
    public int getTotal(int memberCode) {
          String sql="SELECT COUNT(*) from message a WHERE a.receiver_code='"+memberCode+"'";
          Connection con = null;
          Statement stmt=null;
          ResultSet rs=null;
          int num=0;
          ThemeMemberVO themeMemberVO=null;
          try {
            con=DbManager.getConnection(); 
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            
            if(rs.next()) {
               num=rs.getInt(1);
            }
         } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }finally {
            DbManager.close(rs, stmt, con);
         }

          return num;
       }
    public int getIsNotRead(int memberCode) {
          String sql="SELECT COUNT(*) FROM message a WHERE a.receiver_code='"+memberCode+"' AND isRead='0'";
          Connection con = null;
          Statement stmt=null;
          ResultSet rs=null;
          int num=0;
          ThemeMemberVO themeMemberVO=null;
          try {
            con=DbManager.getConnection(); 
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            
            if(rs.next()) {
               num=rs.getInt(1);
            }
         } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }finally {
            DbManager.close(rs, stmt, con);
         }

          return num;
       }
    
    public void setRead(String messageCode) {
          String sql="UPDATE message SET isREAD='"+1+"' WHERE message_code='"+messageCode+"'";
          Connection con = null;
          Statement stmt=null;
          ResultSet rs=null;

          try {
            con=DbManager.getConnection(); 
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);

         } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }finally {
            DbManager.close(rs, stmt, con);
         }

       }
    public void deleteMessage(String messageCode) {
        String sql="DELETE FROM message WHERE message_code='"+messageCode+"'";
        Connection con = null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
          con=DbManager.getConnection(); 
          stmt=con.createStatement();
          rs=stmt.executeQuery(sql);

       } catch (NamingException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
       } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
       }finally {
          DbManager.close(rs, stmt, con);
       }

     }
    
    public ArrayList<MessageVO> getMessageList(int head,int memberCode) {
          String sql="SELECT* from message a WHERE a.receiver_code='"+memberCode+"' ORDER BY regdate desc LIMIT "+head+",10";
          Connection con = null;
          Statement stmt=null;
          ResultSet rs=null;
          ArrayList<MessageVO> list=new ArrayList<MessageVO>();
          try {
            con=DbManager.getConnection(); 
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
            
            while(rs.next()) {
                  MessageVO messageVO=new MessageVO();
                  messageVO.setMessage_code(rs.getInt(1));
                  messageVO.setSender_code(rs.getInt(2));
                  messageVO.setContent(rs.getString(4));
                  messageVO.setRegdate(rs.getString(5));
                  messageVO.setIsRead(rs.getInt(6));
                  list.add(messageVO);
            }
         } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }finally {
            DbManager.close(rs, stmt, con);
         }

          return list;
       }
    public void insert(String receiverID, int code, String content) { // insertMessage
        String sql="INSERT INTO message VALUES (DEFAULT,?,(SELECT member_code FROM member WHERE id=?),?, DEFAULT, DEFAULT)";
        Connection con = null;
        PreparedStatement stmt = null;
        System.out.println(receiverID+receiverID);
        try {
           con = DbManager.getConnection();
           stmt = con.prepareStatement(sql);
           stmt.setInt(1, code);
           stmt.setString(2, receiverID);
           stmt.setString(3, content);
           stmt.executeUpdate();
        }
        catch(NamingException e) {
              e.printStackTrace();
           }
           catch(SQLException e) {
              e.printStackTrace();
           }
           finally {
              DbManager.close(stmt, con);
           }
     } 
   
   public void update(int messageCode, String content) {
      String sql="UPDATE message SET content=? WHERE message_code=?";
      Connection con = null;
       PreparedStatement stmt = null;
       
       try {
           con = DbManager.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, content);
            stmt.setInt(2, messageCode);
            stmt.executeUpdate();
       }
       catch(NamingException e) {
           e.printStackTrace();
        }
        catch(SQLException e) {
           e.printStackTrace();
        }
        finally {
           DbManager.close(stmt, con);
        }
   }
 
}