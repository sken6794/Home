package holy.vo;

public class FilmVO {
	
	private String filmnum;
	private String filtitle;
	private String filmcontent;
	private String filmruntime;
	private int filmprice;
	
	public FilmVO() {
		// TODO Auto-generated constructor stub
	}

	public FilmVO(String filmnum, String filtitle, String filmcontent, String filmruntime, int filmprice) {
		super();
		this.filmnum = filmnum;
		this.filtitle = filtitle;
		this.filmcontent = filmcontent;
		this.filmruntime = filmruntime;
		this.filmprice = filmprice;
	}

	public String getFilmnum() {
		return filmnum;
	}

	public void setFilmnum(String filmnum) {
		this.filmnum = filmnum;
	}

	public String getFiltitle() {
		return filtitle;
	}

	public void setFiltitle(String filtitle) {
		this.filtitle = filtitle;
	}

	public String getFilmcontent() {
		return filmcontent;
	}

	public void setFilmcontent(String filmcontent) {
		this.filmcontent = filmcontent;
	}

	public String getFilmruntime() {
		return filmruntime;
	}

	public void setFilmruntime(String filmruntime) {
		this.filmruntime = filmruntime;
	}

	public int getFilmprice() {
		return filmprice;
	}

	public void setFilmprice(int filmprice) {
		this.filmprice = filmprice;
	}
	
	
	
}
