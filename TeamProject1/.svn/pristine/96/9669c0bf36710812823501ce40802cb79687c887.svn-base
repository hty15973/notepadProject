package kr.co.team.vo;

import java.util.HashMap;

public class ThemeMemberNotepadVO {
	private String themeMember_name;
	private String regdate;
	private String content;
	public ThemeMemberNotepadVO() {
		super();
	}
	public String getThemeMember_name() {
		return themeMember_name;
	}
	public void setThemeMember_name(String themeMember_name) {
		this.themeMember_name = themeMember_name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((regdate == null) ? 0 : regdate.hashCode());
		result = prime * result + ((themeMember_name == null) ? 0 : themeMember_name.hashCode());
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
		ThemeMemberNotepadVO other = (ThemeMemberNotepadVO) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (regdate == null) {
			if (other.regdate != null)
				return false;
		} else if (!regdate.equals(other.regdate))
			return false;
		if (themeMember_name == null) {
			if (other.themeMember_name != null)
				return false;
		} else if (!themeMember_name.equals(other.themeMember_name))
			return false;
		return true;
	}
	
	public HashMap<String, Object> convertMap(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("themeMember_name",themeMember_name);
		map.put("regdate", regdate);
		map.put("content", content);
		return map;
	}
}
