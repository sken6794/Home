package holy.vo;

public class HmemberVO {
	
	private String memid;
	private String mempw;
	private String memname;
	private String memphone;
	
	public HmemberVO() {
		// TODO Auto-generated constructor stub
	}

	public HmemberVO(String memid, String mempw, String memname, String memphone) {
		super();
		this.memid = memid;
		this.mempw = mempw;
		this.memname = memname;
		this.memphone = memphone;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public String getMempw() {
		return mempw;
	}

	public void setMempw(String mempw) {
		this.mempw = mempw;
	}

	public String getMemname() {
		return memname;
	}

	public void setMemname(String memname) {
		this.memname = memname;
	}

	public String getMemphone() {
		return memphone;
	}

	public void setMemphone(String memphone) {
		this.memphone = memphone;
	}
	
	
	
}
