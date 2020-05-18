package kr.co.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import kr.co.team.controller.DbManager;
import kr.co.team.vo.GroupToMemberListVO;
import kr.co.team.vo.GroupVO;
import kr.co.team.vo.ThemeMemberVO;

public class GroupToMemberListDAO {
	public void delete(int code, int groupCode) {
		String sql="DELETE FROM group_to_member_list WHERE member_code=? AND group_code=?";
		//멤버코드와 그룹코드가 일치하면 그룹리스트에서 삭제쿼리
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
	
	public void insert(GroupVO m) {
		String sql="insert into group_to_member_list values(default,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con=DbManager.getConnection(); 
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, m.getGroup_code());
			stmt.setInt(2,m.getGroup_leader_code());
			stmt.executeUpdate();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
				themeMemberVO.setMember_code(rs.getInt("theme_member_code"));
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
	
	public int countList(int groupCode) {
		int count = 0;
		String sql="SELECT * FROM group_to_member_list WHERE group_code='"+groupCode+"'";
		Connection con = null;
		Statement stmt = null;
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
	
	public void insert(String groupName, int code, String receiverID) {
		String sql="INSERT INTO group_to_member_list VALUES(DEFAULT, (SELECT group_code FROM groups WHERE group_name=? AND group_leader_code=?), (SELECT member_code FROM member WHERE id=?))";
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con=DbManager.getConnection();
			stmt=con.prepareStatement(sql);
			stmt.setString(1, groupName);
			stmt.setInt(2, code);
			stmt.setString(3, receiverID);
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
	public void insert(String groupName, String receiverID, int code) {
		//요청시에는 내가 그 그룹이름에 들어가야함 receiverID가 그룹장임
		String sql ="INSERT INTO group_to_member_list VALUES(DEFAULT, (SELECT group_code FROM groups WHERE group_name=? AND group_leader_code=(SELECT member_code FROM member WHERE id=?)), ?)";
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con=DbManager.getConnection();
			stmt=con.prepareStatement(sql);
			stmt.setString(1, groupName);
			stmt.setString(2, receiverID);
			stmt.setInt(3, code);
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
