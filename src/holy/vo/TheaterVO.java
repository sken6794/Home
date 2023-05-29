package holy.vo;

public class TheaterVO {
	private String theanum;
	private int theaseat;
	
	public TheaterVO() {
		// TODO Auto-generated constructor stub
	}

	public TheaterVO(String theanum, int theaseat) {
		super();
		this.theanum = theanum;
		this.theaseat = theaseat;
	}

	public String getTheanum() {
		return theanum;
	}

	public void setTheanum(String theanum) {
		this.theanum = theanum;
	}

	public int getTheaseat() {
		return theaseat;
	}

	public void setTheaseat(int theaseat) {
		this.theaseat = theaseat;
	}
	
	
}	
