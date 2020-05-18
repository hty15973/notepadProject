package kr.co.team.vo;

public class ThemeMemberVO {
	private int themeMember_code;
	private int member_code;
	private String themeMember_name;
	private int super_themeMember_code;
	public ThemeMemberVO() {
		super();
	}
	public int getThemeMember_code() {
		return themeMember_code;
	}
	public void setThemeMember_code(int themeMember_code) {
		this.themeMember_code = themeMember_code;
	}
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public String getThemeMember_name() {
		return themeMember_name;
	}
	public void setThemeMember_name(String themeMember_name) {
		this.themeMember_name = themeMember_name;
	}
	public int getSuper_themeMember_code() {
		return super_themeMember_code;
	}
	public void setSuper_themeMember_code(int super_themeMember_code) {
		this.super_themeMember_code = super_themeMember_code;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + member_code;
		result = prime * result + super_themeMember_code;
		result = prime * result + themeMember_code;
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
		ThemeMemberVO other = (ThemeMemberVO) obj;
		if (member_code != other.member_code)
			return false;
		if (super_themeMember_code != other.super_themeMember_code)
			return false;
		if (themeMember_code != other.themeMember_code)
			return false;
		if (themeMember_name == null) {
			if (other.themeMember_name != null)
				return false;
		} else if (!themeMember_name.equals(other.themeMember_name))
			return false;
		return true;
	}
	
}
