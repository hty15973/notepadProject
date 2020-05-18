package kr.co.team.vo;

import java.util.HashMap;

public class MemberVO {
	private int member_code;
	private String member_name;
	private String id;
	private String pass;
	private String email;
	public MemberVO() {
		super();
	}
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + member_code;
		result = prime * result + ((member_name == null) ? 0 : member_name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (member_code != other.member_code)
			return false;
		if (member_name == null) {
			if (other.member_name != null)
				return false;
		} else if (!member_name.equals(other.member_name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}
	
	public HashMap<String, Object> convertMap(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("member_code", member_code);
		map.put("member_name", member_name);
		map.put("id", id);
		map.put("pass", pass);
		map.put("email", email);
		return map;
	}
	
}
