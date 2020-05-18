package kr.co.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import kr.co.team.controller.DbManager;
import kr.co.team.vo.NotepadVO;
import kr.co.team.vo.ThemeMemberNotepadVO;
import kr.co.team.vo.ThemeMemberVO;

public class NotepadDAO {
	 public void insert(NotepadVO m) {
		String sql="insert into notepad values(default,?,default,default,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con=DbManager.getConnection();
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, m.getThemeMember_code());
			stmt.setString(2,m.getContent());
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
	 public void delete(ThemeMemberVO vo) {
		 String sql = "DELETE FROM notepad WHERE theme_member_code=(SELECT theme_member_code FROM theme_member WHERE member_code=? AND theme_member_name=?)";
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
	 public ArrayList<NotepadVO> getContent(String memberCode, String themeName){
		 String sql = "SELECT regdate, content FROM theme_member natural join notepad WHERE theme_member_name='"+themeName+"' AND member_code='"+memberCode+"' ORDER BY regdate";
				 
		ArrayList<NotepadVO> nameContent = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		NotepadVO vo = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				vo = new NotepadVO();
				vo.setContent(rs.getString(2));
				vo.setRegdate(rs.getString(1));
				nameContent.add(vo);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DbManager.close(rs, stmt, con);
		}
		return nameContent;
			
		
	 }
	 public void updateContent(NotepadVO notepadVO){
		String sql="UPDATE notepad SET content='"+notepadVO.getContent()+"' WHERE theme_member_code='"+notepadVO.getThemeMember_code()+"' AND regdate='"+notepadVO.getRegdate()+"'";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		NotepadVO vo = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DbManager.close(rs, stmt, con);
		}

			
	
			
	 }
}

