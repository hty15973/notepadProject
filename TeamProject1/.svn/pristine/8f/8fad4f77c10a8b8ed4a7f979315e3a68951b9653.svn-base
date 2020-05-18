package kr.co.team.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import kr.co.team.controller.DbManager;
import kr.co.team.vo.ThemeMemberNotepadVO;

public class ThemeMemberNotepadDAO {
	public ArrayList<String> getList(int code){
		String sql = "SELECT DISTINCT DATE(notepad.regdate) FROM notepad JOIN theme_member ON (notepad.theme_member_code=theme_member.theme_member_code AND theme_member.member_code='"+code+"')";
		ArrayList<String> dates = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ThemeMemberNotepadVO vo = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				dates.add(rs.getString(1));
			}
		}
		catch(NamingException e) {
			e.printStackTrace();
			System.out.println("¿¡·¯");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbManager.close(rs, stmt, con);
		}
		return dates;
	}
	
	public ArrayList<ThemeMemberNotepadVO> getContent(int code, String date){
		String sql = "SELECT theme_member.theme_member_name, notepad.content, notepad.regdate FROM theme_member JOIN notepad ON (notepad.theme_member_code=theme_member.theme_member_code AND DATE(notepad.regdate)= '"+ date +"' AND theme_member.member_code='"+ code +"') ORDER BY notepad.regdate";
		
		ArrayList<ThemeMemberNotepadVO> nameContent = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ThemeMemberNotepadVO vo = null;
		
		try {
			con = DbManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				vo = new ThemeMemberNotepadVO();
				vo.setContent(rs.getString("content"));
				vo.setThemeMember_name(rs.getString("theme_member_name"));
				vo.setRegdate(rs.getString("regdate"));
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
}
