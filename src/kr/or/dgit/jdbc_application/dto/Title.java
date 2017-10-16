package kr.or.dgit.jdbc_application.dto;

public class Title {
	private int titleNo;
	private String titlename;

	public Title() {
		// TODO Auto-generated constructor stub
	}

	public int getTitleNo() {
		return titleNo;
	}

	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}

	public String getTitlename() {
		return titlename;
	}

	public void setTitlename(String titlename) {
		this.titlename = titlename;
	}

	public Title(int titleNo, String titlename) {
		this.titleNo = titleNo;
		this.titlename = titlename;
	}

	/*@Override
	public String toString() {
		return String.format("%s",  titlename);
	}*/
	
	
	@Override
	public String toString() {
		return String.format("%s %s", titleNo, titlename);
	}
	
	public Object[] toArray(){
		return new Object[]{titleNo, titlename};
	}
	

	public Title(int titleNo) {
		this.titleNo = titleNo;
	}

	

}
