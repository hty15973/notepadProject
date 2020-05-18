package kr.co.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import kr.co.team.controller.DbManager;
import kr.co.team.vo.GroupVO;

public class GroupDAO {
	public GroupVO insert(GroupVO m) {
		String sql="insert into groups values(default,?,?,default)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con=DbManager.getConnection();
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, m.getGroup_leader_code());
			stmt.setString(2, m.getGroup_name());
			stmt.executeUpdate();
			int code=this.getLastInsertId(con);
			m.setGroup_code(code);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbManager.close(stmt, con);
		}
		return m;
	
	 }
	 public GroupVO searchBythemeNameAndCode(GroupVO m) {
		 String sql="select*from groups where group_name='"+m.getGroup_name()+"'and group_leader_code='"+m.getGroup_leader_code()+"'";
		 Connection con = null;
		 Statement stmt=null;
		 ResultSet rs=null;
		 
		 GroupVO groupVO =null;
		 try {
			con=DbManager.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);

			if(rs.next()) {
				groupVO=new GroupVO();
				groupVO.setGroup_code(rs.getInt(1));
				groupVO.setGroup_leader_code(rs.getInt(2));
				groupVO.setGroup_name(rs.getString(3));
				groupVO.setRegdate(rs.getString(4));
				
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
		 
		 return groupVO;
	 }
	 public ArrayList<String> searchBythemeName(GroupVO m) {
		 String sql="SELECT a.id from member a INNER JOIN groups b ON(a.member_code=b.group_leader_code) WHERE b.group_name='"+m.getGroup_name()+"' ORDER BY a.member_name";

		 Connection con = null;
		 Statement stmt=null;
		 ResultSet rs=null;
		 
		 ArrayList<String> leaderNameList=new ArrayList<>();
		 try {
			con=DbManager.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);

			while(rs.next()) {
				
				String leaderName=null;
				leaderName=rs.getString(1);
				leaderNameList.add(leaderName);
				
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

		 return leaderNameList;
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
		}finally {
			DbManager.close(rs, stmt, con);
		}

		DbManager.close(rs, stmt);
		return id;
	}

	public ArrayList<GroupVO> getGroupList(int code) {
		String sql = "SELECT b.group_code, b.group_name from group_to_member_list a INNER JOIN groups b using(group_code) WHERE a.member_code='"
				+ code + "'";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ArrayList<GroupVO> groupList = new ArrayList<>();
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				GroupVO group = new GroupVO();
				group.setGroup_code(rs.getInt(1));
				group.setGroup_name(rs.getString(2));
				groupList.add(group);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbManager.close(rs, stmt, con);
		}

		return groupList;
	}
	
	public boolean checkLeader(int code, int groupCode) {
		boolean result = false;
		String sql = "SELECT member.member_code FROM member JOIN groups ON (member.member_code=groups.group_leader_code AND groups.group_code='"+groupCode+"')";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				if(code == rs.getInt(1)) {
					result = true;
				}
			}
			
		}
		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbManager.close(rs, stmt, con);
		}
		return result;
	}
	public void delegate(int code, int groupCode) {
		String sql = "UPDATE groups SET group_leader_code='"+code+"'WHERE group_code='"+groupCode+"'";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbManager.close(rs, stmt, con);
		}
	}
	
	public void delete(int groupCode) {
		String sql="DELETE FROM groups WHERE group_code='"+groupCode+"'";
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			stmt.executeQuery(sql);
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
	public boolean searchLeader(String groupName, int code) {
		boolean result = false;
		String sql = "SELECT * FROM groups WHERE group_leader_code='"+code+"' AND group_name='"+groupName+"'";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				result = true;
			}
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbManager.close(rs, stmt, con);
		}
		return result;
	}
}
