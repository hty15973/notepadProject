package kr.co.team.vo;

public class GroupVO {
	private int group_code;
	private int group_leader_code;
	private String group_name;
	private String regdate;
	public GroupVO() {
		super();
	}
	public int getGroup_code() {
		return group_code;
	}
	public void setGroup_code(int group_code) {
		this.group_code = group_code;
	}
	public int getGroup_leader_code() {
		return group_leader_code;
	}
	public void setGroup_leader_code(int group_leader_code) {
		this.group_leader_code = group_leader_code;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + group_code;
		result = prime * result + group_leader_code;
		result = prime * result + ((group_name == null) ? 0 : group_name.hashCode());
		result = prime * result + ((regdate == null) ? 0 : regdate.hashCode());
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
		GroupVO other = (GroupVO) obj;
		if (group_code != other.group_code)
			return false;
		if (group_leader_code != other.group_leader_code)
			return false;
		if (group_name == null) {
			if (other.group_name != null)
				return false;
		} else if (!group_name.equals(other.group_name))
			return false;
		if (regdate == null) {
			if (other.regdate != null)
				return false;
		} else if (!regdate.equals(other.regdate))
			return false;
		return true;
	}
	
}
