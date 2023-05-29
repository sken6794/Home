package holy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import holy.main.MovieDBProperties;
import holy.vo.FilmVO;
import holy.vo.HmemberVO;
import holy.vo.ScheduleVO;
import holy.vo.TheaterVO;
import holy.vo.TicketListVO;
import holy.vo.TicketingVO;

public class TicketDAO {
		
	private String url = MovieDBProperties.URL;
	private String uid = MovieDBProperties.UID;
	private String upw = MovieDBProperties.UPW;
	
	
	public TicketDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("CLASS FOR NAME ERR");
		}	
	}
	
	
	public List<TicketListVO> getTicket(String id) {
		
		String sql = "select t.tickno, t.tickseat, t.tickdate, t.tickcount,\r\n"
				+ "    t.tickprice, t.paymehod, t.memid, s.schedate, s.schetime, s.theanum,\r\n"
				+ "    f.filmtitle, f.filmruntime\r\n"
				+ "from ticketing t\r\n"
				+ "join schedule s on t.schenum = s.schenum\r\n"
				+ "join film f on s.filmnum = f.filmnum\r\n"
				+ "where t.memid = ?";
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TicketListVO> list = new ArrayList();
		TicketListVO tvo = null;
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				TicketingVO tickvo = new TicketingVO();
				ScheduleVO svo = new ScheduleVO();
				FilmVO fvo = new FilmVO();
				HmemberVO mvo = new HmemberVO();
				tvo = new TicketListVO();
				TheaterVO thvo = new TheaterVO();
				tickvo.setTickno(rs.getString("tickno"));
				tickvo.setTickseat(rs.getString("tickseat"));
				tickvo.setTickdate(rs.getString("tickdate"));
				tickvo.setTickcount(rs.getInt("tickcount"));
				tickvo.setTickprice(rs.getInt("tickprice"));
				tickvo.setPaymehod(rs.getString("paymehod"));
				svo.setSchedate(rs.getString("schedate"));
				svo.setSchetime(rs.getString("schetime"));
				fvo.setFiltitle(rs.getString("filmtitle"));
				fvo.setFilmruntime(rs.getString("filmruntime"));
				mvo.setMemid(rs.getString("memid"));
				tickvo.setMemvo(mvo);
				thvo.setTheanum(rs.getString("theanum"));
				svo.setTheatervo(thvo);
				
				tvo.setFvo(fvo);
				tvo.setSvo(svo);
				tvo.setTickvo(tickvo);
				
				list.add(tvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list; 
	}
	
	
}
