package kr.co.team.vo;

public class GroupToMemberListVO {
	private int groupToMemberList_code;
	private int group_code;
	private int member_code;
	public GroupToMemberListVO() {
		super();
	}
	public int getGroupToMemberList_code() {
		return groupToMemberList_code;
	}
	public void setGroupToMemberList_code(int groupToMemberList_code) {
		this.groupToMemberList_code = groupToMemberList_code;
	}
	public int getGroup_code() {
		return group_code;
	}
	public void setGroup_code(int group_code) {
		this.group_code = group_code;
	}
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + groupToMemberList_code;
		result = prime * result + group_code;
		result = prime * result + member_code;
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
		GroupToMemberListVO other = (GroupToMemberListVO) obj;
		if (groupToMemberList_code != other.groupToMemberList_code)
			return false;
		if (group_code != other.group_code)
			return false;
		if (member_code != other.member_code)
			return false;
		return true;
	}
	
}
