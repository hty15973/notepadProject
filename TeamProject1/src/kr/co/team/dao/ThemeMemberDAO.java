package kr.co.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.naming.NamingException;

import kr.co.team.controller.DbManager;
import kr.co.team.vo.ThemeMemberVO;

public class ThemeMemberDAO {
   
    public void insert(ThemeMemberVO m) {
      String sql="insert into theme_member values(default,?,?,default)";
      Connection con = null;
      PreparedStatement stmt = null;
      
      try {
         con=DbManager.getConnection();
         stmt=con.prepareStatement(sql);
         stmt.setInt(1, m.getMember_code());
         stmt.setString(2, m.getThemeMember_name());
         stmt.executeUpdate();
         int code=this.getLastInsertId(con);
         m.setThemeMember_code(code);
         
      } catch (NamingException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         DbManager.close(stmt, con);
         
      }


   
    }
    public ThemeMemberVO searchBythemeName(ThemeMemberVO m) {
       String sql="select*from theme_member where theme_member_name='"+m.getThemeMember_name()+"'and member_code='"+m.getMember_code()+"'";
       Connection con = null;
       Statement stmt=null;
       ResultSet rs=null;
       
       ThemeMemberVO themeMemberVO=null;
       try {
         con=DbManager.getConnection(); 
         stmt=con.createStatement();
         rs=stmt.executeQuery(sql);

         if(rs.next()) {
            themeMemberVO=new ThemeMemberVO();
            themeMemberVO.setSuper_themeMember_code(rs.getInt("super_theme_member_code"));
            themeMemberVO.setThemeMember_code(rs.getInt("theme_member_code"));
            themeMemberVO.setThemeMember_name(rs.getString("theme_member_name"));
            themeMemberVO.setMember_code(rs.getInt("member_code"));
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

       return themeMemberVO;
    }
    
   public int getLastInsertId(Connection con)  {
      String sql = "SELECT LAST_INSERT_ID()";
      Statement stmt = null;
      ResultSet rs = null;
      int id = 0;
      
      try {
         stmt = con.createStatement();
         rs = stmt.executeQuery(sql);
         if (rs.next()) {
            id = rs.getInt(1);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
       finally {
            DbManager.close(rs, stmt, con);
         }

      return id;
   }
   public ArrayList<String> getRelation(String type,String theme, int code){
      String sql = null;
      if(type.equals("front")) {
         sql="SELECT a.theme_member_name,c.theme_member_name,max(latest) d FROM theme_member a LEFT OUTER JOIN notepad b USING(theme_member_code) left outer join theme_member c ON(a.super_theme_member_code=c.theme_member_code) WHERE a.member_code='"+code+"' and c.theme_member_name='"+theme+"' Group BY a.theme_member_name ORDER BY d desc";

      }else if(type.equals("back")&&!theme.equals("")) {
         sql="SELECT theme_member_name,max(latest) d FROM theme_member a LEFT OUTER JOIN notepad b USING(theme_member_code) WHERE a.member_code='"+code+"'AND a.super_theme_member_code=(SELECT super_theme_member_code FROM theme_member WHERE theme_member_name='"+theme+"') Group BY a.theme_member_name ORDER BY d DESC";

      }else{
         sql="SELECT theme_member_name,MAX(latest) a FROM theme_member left outer join notepad USING(theme_member_code) WHERE member_code='"+code+"' and super_theme_member_code=0 group by theme_member_name ORDER BY a desc";


      }
       Connection con = null;
       Statement stmt=null;
       ResultSet rs=null;
       ArrayList<String> b=new ArrayList<>();
       
       ThemeMemberVO themeMemberVO=null;
       try {
         con=DbManager.getConnection();
         stmt=con.createStatement();
         rs=stmt.executeQuery(sql);

         while(rs.next()) {
            String a=rs.getString(1);
            b.add(a);
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

       return b;
   }
   public void delete(ThemeMemberVO vo) {
      String sql = "SELECT theme_member_code FROM theme_member WHERE member_code=? AND theme_member_name=?";
      //멤버코드와 멤버네임을 통해 해당theme_member_code 가져오기
     String sql2 = "SELECT a.theme_member_code FROM theme_member a LEFT JOIN theme_member c ON(a.super_theme_member_code = c.theme_member_code) WHERE c.theme_member_code=? GROUP BY a.theme_member_name";
      //위 sql문은 멤버코드와 멤버네임을 통해 theme_member_code들 가져오기
      String sql3 = "DELETE FROM theme_member WHERE theme_member_code=?";
      String sql4 = "DELETE FROM theme_member WHERE super_theme_member_code=?";
     //해당 멤버코드에 해당하는 행 삭제하기
     Connection con = null;
      PreparedStatement stmt = null;
      PreparedStatement stmt2 = null;
      PreparedStatement stmt3 = null;
      PreparedStatement stmt4 = null;
      ResultSet rs = null;
      ResultSet rs2 = null;
      ResultSet rs3 = null;
      ResultSet rs4 = null;
      
      ArrayList<Integer> list = null; //삭제 대상코드 넣기
      LinkedList<Integer> queue = null; //삭제 대상코드 넣기
      
      try {
         con=DbManager.getConnection();
         list = new ArrayList<>();
         queue = new LinkedList<>();
         
         
         
         stmt=con.prepareStatement(sql);
         stmt.setInt(1, vo.getMember_code());
         stmt.setString(2, vo.getThemeMember_name());
         rs = stmt.executeQuery(); 
         //rs에 제일 상위테마코드 하나 들어있음
         
         
         
         if(rs.next()) {
            list.add(rs.getInt(1));
            queue.push(rs.getInt(1));
         }
         //선택한(제일상위)테마코드를 큐에 넣기
         
         stmt3 = con.prepareStatement(sql3);
         stmt3.setInt(1, rs.getInt(1));
         rs3 = stmt3.executeQuery();
         //큐에서 코드하나 빼서 삭제
         
         while(!queue.isEmpty()) {
            int code = queue.poll(); //큐에서 코드 하나 빼기
            
            stmt4 = con.prepareStatement(sql4);
            stmt4.setInt(1, code);
            rs4 = stmt4.executeQuery();
            
            
            stmt2 = con.prepareStatement(sql2);
            stmt2.setInt(1, code);
            rs2 = stmt2.executeQuery();
            //그 코드의 하위코드들 뽑기
            
            
            while(rs2.next()) {
              list.add(rs2.getInt(1));
              queue.push(rs2.getInt(1));
            }
            //하위 코드들을 큐에 넣기 
         }
      }
      catch(NamingException e) {
         e.printStackTrace();
      }
      catch(SQLException e) {
         e.printStackTrace();
      }
      finally {
         DbManager.close(rs3, stmt3);
         DbManager.close(rs2, stmt2);
         DbManager.close(rs, stmt, con);
      }
   }
   
   public void updateThemeName(ThemeMemberVO m,String theme) {
	      String sql="UPDATE theme_member SET theme_member_name='"+m.getThemeMember_name()+"' WHERE member_code='"+m.getMember_code()+"' AND theme_member_name='"+theme+"'";
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
	    public void updateThemeRelation(ThemeMemberVO m) {
	      String sql="UPDATE theme_member SET super_theme_member_code='"+m.getThemeMember_code()+"' where member_code='"+m.getMember_code()+"' AND theme_member_name='"+m.getThemeMember_name()+"'";
	      Connection con = null;
	      Statement stmt=null;
	      ResultSet rs=null;
			System.out.println(m.getMember_code());
			System.out.println(m.getSuper_themeMember_code());
			System.out.println(m.getThemeMember_code());
			System.out.println(m.getThemeMember_name());
			 
	      
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
    public boolean isTheme(int code, String themeName) {
        String sql="SELECT member_code FROM theme_member WHERE theme_member_name='"+themeName+"' AND member_code='"+code+"'";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        boolean result = false;
        try {
          con=DbManager.getConnection();
          stmt=con.createStatement();
          rs=stmt.executeQuery(sql);
          if(rs.next()) {
             result = true;
          }
        }
        catch (NamingException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } 
        catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        finally {
          DbManager.close(rs, stmt, con);
        }   
        return result;
     }
}