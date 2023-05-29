package holy.vo;

public class TicketingVO {
	private String tickno;
	private String tickseat;
	private String tickdate;
	private int tickcount;
	private int tickprice;
	private String paymehod;
	private ScheduleVO scvo;
	private HmemberVO memvo;
	
	public TicketingVO() {
		// TODO Auto-generated constructor stub
	}

	public TicketingVO(String tickno, String tickseat, String tickdate, int tickcount, int tickprice, String paymehod,
			ScheduleVO scvo, HmemberVO memvo) {
		super();
		this.tickno = tickno;
		this.tickseat = tickseat;
		this.tickdate = tickdate;
		this.tickcount = tickcount;
		this.tickprice = tickprice;
		this.paymehod = paymehod;
		this.scvo = scvo;
		this.memvo = memvo;
	}

	public String getTickno() {
		return tickno;
	}

	public void setTickno(String tickno) {
		this.tickno = tickno;
	}

	public String getTickseat() {
		return tickseat;
	}

	public void setTickseat(String tickseat) {
		this.tickseat = tickseat;
	}

	public String getTickdate() {
		return tickdate;
	}

	public void setTickdate(String tickdate) {
		this.tickdate = tickdate;
	}

	public int getTickcount() {
		return tickcount;
	}

	public void setTickcount(int tickcount) {
		this.tickcount = tickcount;
	}

	public int getTickprice() {
		return tickprice;
	}

	public void setTickprice(int tickprice) {
		this.tickprice = tickprice;
	}

	public String getPaymehod() {
		return paymehod;
	}

	public void setPaymehod(String paymehod) {
		this.paymehod = paymehod;
	}

	public ScheduleVO getScvo() {
		return scvo;
	}

	public void setScvo(ScheduleVO scvo) {
		this.scvo = scvo;
	}

	public HmemberVO getMemvo() {
		return memvo;
	}

	public void setMemvo(HmemberVO memvo) {
		this.memvo = memvo;
	}

	
	
	
}
