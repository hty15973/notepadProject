package kr.co.team.vo;

public class MessageVO {
	private int message_code;
	private int sender_code;
	private int receiver_code;
	private String content;
	private String regdate;
	private int isRead;
	public MessageVO() {
		super();
	}
	public int getMessage_code() {
		return message_code;
	}
	public void setMessage_code(int message_code) {
		this.message_code = message_code;
	}
	public int getSender_code() {
		return sender_code;
	}
	public void setSender_code(int sender_code) {
		this.sender_code = sender_code;
	}
	public int getReceiver_code() {
		return receiver_code;
	}
	public void setReceiver_code(int receiver_code) {
		this.receiver_code = receiver_code;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + isRead;
		result = prime * result + message_code;
		result = prime * result + receiver_code;
		result = prime * result + ((regdate == null) ? 0 : regdate.hashCode());
		result = prime * result + sender_code;
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
		MessageVO other = (MessageVO) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (isRead != other.isRead)
			return false;
		if (message_code != other.message_code)
			return false;
		if (receiver_code != other.receiver_code)
			return false;
		if (regdate == null) {
			if (other.regdate != null)
				return false;
		} else if (!regdate.equals(other.regdate))
			return false;
		if (sender_code != other.sender_code)
			return false;
		return true;
	}
}