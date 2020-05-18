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
import kr.co.team.vo.MemberVO;

public class MemberDAO {
	
	public void register(MemberVO m) { // 회원가입
		
		String sql = "INSERT INTO member VALUES (default, ?, ?,PASSWORD(?),?)"; //member_code , member_name, id, pass, email순서
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.prepareStatement(sql);
		
			stmt.setString(1, m.getMember_name());
			stmt.setString(2, m.getId());
			stmt.setString(3,  m.getPass());
			stmt.setString(4, m.getEmail());
			stmt.executeUpdate();

		}
		catch(NamingException e) {
			e.printStackTrace();
			System.out.println("에러");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbManager.close(stmt,con);
		}

	}
	
	public MemberVO login(MemberVO m) {  //로그인
		String sql = "SELECT * FROM member WHERE id= '" + m.getId() + "' AND pass = PASSWORD('"+ m.getPass() +"')";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				member = new MemberVO();
				member.setEmail(rs.getString("email"));
				member.setPass(rs.getString("pass"));
				member.setMember_code(rs.getInt("member_code"));
				member.setMember_name(rs.getString("member_name"));
				member.setId(rs.getString("id"));
			}
						
		}
		catch(NamingException e) {
			e.printStackTrace();
			System.out.println("에러");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbManager.close(stmt, con);
		}
		return member;
	}
	public MemberVO delete(MemberVO m) {  //로그인
		String sql = "DELETE FROM member WHERE member_code='"+m.getMember_code()+"'";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);	
		}
		catch(NamingException e) {
			e.printStackTrace();
			System.out.println("에러");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbManager.close(stmt, con);
		}
		return member;
	}
	
	public MemberVO duplicateId(MemberVO m) { // 회원가입시 아이디 중복검사
		String sql = "SELECT id FROM member WHERE id='" + m.getId() + "'";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				member = new MemberVO();
				member.setId(m.getId());
				
			}
			
		}
		catch(NamingException e) {
			e.printStackTrace();
			System.out.println("에러");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbManager.close(stmt, con);
		}
		return member;
	}
	
	public MemberVO findIDByEmail(MemberVO m) { //email을 통한 아이디찾기
		String sql = "SELECT id FROM member WHERE email='"+m.getEmail()+"'";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
			}
		}
		catch(NamingException e) {
			e.printStackTrace();
			System.out.println("에러");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbManager.close(rs, stmt, con);
		}
		return member;
		
	}
	
	public MemberVO findPass(MemberVO m) {
		String sql = "SELECT pass FROM member WHERE email='"+m.getEmail()+"' AND id='"+m.getId()+"'";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				member = new MemberVO();
				member.setPass(rs.getString("pass"));
			}
			
		}
		catch(NamingException e) {
			e.printStackTrace();
			System.out.println("에러");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbManager.close(stmt, con);
		}
		return member;
		
		
	}
	
	
	public int getLastInsertId(Connection con) throws SQLException {
		String sql = "SELECT LAST_INSERT_ID()";
		Statement stmt = null;
		ResultSet rs = null;
		int id = 0;
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			id = rs.getInt(1);
		}
		DbManager.close(rs, stmt);
		return id;
	}
	public String serachByID(String keyword){
		String sql = "SELECT * FROM member WHERE id='"+keyword+"'";
		Connection con =null;
		Statement stmt =null;
		ResultSet rs = null;
		MemberVO member =new MemberVO();
		try {
			con=DbManager.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				member.setEmail(rs.getString("email"));
				member.setId(rs.getString("id"));
				member.setMember_code(rs.getInt("member_code"));
				member.setMember_name(rs.getString("member_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbManager.close(rs,stmt,con);
		}
		
		return member.getId();
	}
	public String searchByCode(int memberCode) {
		String sql = "SELECT * FROM member WHERE member_code='"+memberCode+"'";
		Connection con =null;
		Statement stmt =null;
		ResultSet rs = null;
		MemberVO member =new MemberVO();
		try {
			con=DbManager.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				member.setEmail(rs.getString("email"));
				member.setId(rs.getString("id"));
				member.setMember_code(rs.getInt("member_code"));
				member.setMember_name(rs.getString("member_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbManager.close(rs,stmt,con);
		}
		
		return member.getId();
	}
	public ArrayList<MemberVO>getGroupMemberList(String code){
		 String sql="SELECT member_code,id FROM group_to_member_list inner join member using(member_code)WHERE group_code='"+code+"' ORDER BY id";
		 Connection con = null;
		 Statement stmt=null;
		 ResultSet rs=null;
		 
		 ArrayList<MemberVO> groupMemberList=new ArrayList<>();
		 try {
			con=DbManager.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);

			while(rs.next()) {
				MemberVO groupMember=new MemberVO();
				groupMember.setMember_code(rs.getInt(1));
				groupMember.setId(rs.getString(2));
				groupMemberList.add(groupMember);
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

			 return groupMemberList;
			}
		
	
}
