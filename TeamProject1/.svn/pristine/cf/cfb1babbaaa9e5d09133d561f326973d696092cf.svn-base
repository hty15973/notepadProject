package kr.co.team.vo;

public class NotepadVO {
	private int notepad_code;
	private int themeMember_code;
	private String regdate;
	private String latest;
	private String content;
	public NotepadVO() {
		super();
	}
	public int getNotepad_code() {
		return notepad_code;
	}
	public void setNotepad_code(int notepad_code) {
		this.notepad_code = notepad_code;
	}
	public int getThemeMember_code() {
		return themeMember_code;
	}
	public void setThemeMember_code(int themeMember_code) {
		this.themeMember_code = themeMember_code;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getLatest() {
		return latest;
	}
	public void setLatest(String latest) {
		this.latest = latest;
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
		result = prime * result + ((latest == null) ? 0 : latest.hashCode());
		result = prime * result + notepad_code;
		result = prime * result + ((regdate == null) ? 0 : regdate.hashCode());
		result = prime * result + themeMember_code;
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
		NotepadVO other = (NotepadVO) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (latest == null) {
			if (other.latest != null)
				return false;
		} else if (!latest.equals(other.latest))
			return false;
		if (notepad_code != other.notepad_code)
			return false;
		if (regdate == null) {
			if (other.regdate != null)
				return false;
		} else if (!regdate.equals(other.regdate))
			return false;
		if (themeMember_code != other.themeMember_code)
			return false;
		return true;
	}
	
}
