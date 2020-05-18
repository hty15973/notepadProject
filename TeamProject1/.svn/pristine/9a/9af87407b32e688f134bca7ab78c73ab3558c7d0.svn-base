package kr.co.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import kr.co.team.controller.DbManager;
import kr.co.team.vo.ThemeMemberVO;

public class GroupToMemberThemeDAO {
	public void delete(int code, int groupCode) {
		String sql = "DELETE FROM group_to_member_theme WHERE theme_member_code in (SELECT theme_member_code FROM theme_member WHERE member_code=?) AND group_code=?";
		//멤버 코드를 통해 theme_member_code 다 찾고 그것들로 group_to_member_theme에서 해당하는것들 삭제쿼리
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con=DbManager.getConnection();
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, code);
			stmt.setInt(2, groupCode);
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
	public ArrayList<ThemeMemberVO> getRelation(String memberCode, String theme,String groupCode,String type) {
		String sql = null;
		if(type.equals("front")) {
			sql="SELECT a.theme_member_code,a.theme_member_name,max(latest) d FROM theme_member a LEFT OUTER JOIN notepad b USING(theme_member_code) left outer join theme_member c ON(a.super_theme_member_code=c.theme_member_code) WHERE c.member_code='"+memberCode+"' and c.theme_member_name='"+theme+"' Group BY a.theme_member_name ORDER BY d desc";
			System.out.println(3);
		}else if(type.equals("themeHome")){
			sql="SELECT a.theme_member_code,b.theme_member_name FROM group_to_member_theme a inner join theme_member b using(theme_member_code) WHERE a.group_code='"+groupCode+"' AND member_code='"+memberCode+"' ORDER BY b.theme_member_name";
			System.out.println(4);
		}
		 Connection con = null;
		 Statement stmt=null;
		 ResultSet rs=null;
		 ArrayList<ThemeMemberVO> b=new ArrayList<>();
		 
		 ThemeMemberVO themeMemberVO=null;
		 try {
			con=DbManager.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);

			while(rs.next()) {
				ThemeMemberVO a=new ThemeMemberVO();
				a.setThemeMember_code(rs.getInt(1));
				a.setThemeMember_name(rs.getString(2));
				b.add(a);
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				
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
	
	public void insert(int groupCode, int code, String themeName) {
		String sql = "INSERT INTO group_to_member_theme VALUES(DEFAULT,(SELECT theme_member_code FROM theme_member WHERE member_code='"+code+"' AND theme_member_name='"+themeName+"'),"+groupCode+");";
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			con=DbManager.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
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
			DbManager.close(stmt, con);
		}
	}
	public void delete(ThemeMemberVO vo) {
		String sql="DELETE FROM group_to_member_theme WHERE theme_member_code=(SELECT theme_member_code FROM theme_member WHERE member_code=? AND theme_member_name=?)";
		 Connection con = null;
		 PreparedStatement stmt = null;
		 
		 try {
			con=DbManager.getConnection();
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, vo.getMember_code());
			stmt.setString(2, vo.getThemeMember_name());
			stmt.executeUpdate();
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
			 DbManager.close(stmt,con);
		 }
	}
	
	public void delete(int code, int groupCode, String themeName) {
		String sql = "DELETE FROM group_to_member_theme WHERE theme_member_code=(SELECT theme_member_code FROM theme_member WHERE member_code=? AND theme_member_name=?) AND group_code=?";
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con=DbManager.getConnection();
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, code);
			stmt.setString(2, themeName);
			stmt.setInt(3, groupCode);
			stmt.executeUpdate();
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
			 DbManager.close(stmt,con);
		 }
	}
	public int count(int groupCode, int code, String themeName) {
		int count = 0;
		String sql = "SELECT * FROM group_to_member_theme WHERE theme_member_code = (SELECT theme_member_code FROM theme_member WHERE member_code='"+code+"' AND theme_member_name='"+themeName+"') AND group_code='"+groupCode+"'";
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			con=DbManager.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				count++;
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
			DbManager.close(stmt, con);
		}
		
		return count;
	}
}
