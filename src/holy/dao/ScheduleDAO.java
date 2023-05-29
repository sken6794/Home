package holy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import holy.main.MovieDBProperties;
import holy.vo.FilmVO;
import holy.vo.HmemberVO;
import holy.vo.ScheduleVO;
import holy.vo.TheaterVO;

public class ScheduleDAO {
	
	
	private String url = MovieDBProperties.URL;
	private String uid = MovieDBProperties.UID;
	private String upw = MovieDBProperties.UPW;

	
	
	public ScheduleDAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("CLASS FOR NAME ERR");
		}		
		
	}
	
	public List<ScheduleVO> getSche(){
		String sql = "SELECT * FROM SCHEDULE";
		List<ScheduleVO> list = new ArrayList<>(); 
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {			
			//conn , pstmt ,resultset	
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt=conn.prepareStatement(sql);

			// 매개변수로 받아온 값

			rs= pstmt.executeQuery();

			while(rs.next()) {
				//String scheNum, String scheTime, int leftSeat, String theaNum, String filmNum
				String schenum = rs.getString(1);
				String schedate = rs.getString(2);
				String schetime = rs.getString(3);
				int lefeseat = rs.getInt(4);
				TheaterVO thenum = new TheaterVO();
				thenum.setTheanum(rs.getString(5));
				String filmnum = rs.getString(6);
				FilmVO filmvo = new FilmVO();
				filmvo.setFilmnum(filmnum);
				
				//1행에 대한 값을 저장
				ScheduleVO vo = new ScheduleVO(schenum, schedate, schetime, filmnum, thenum, filmvo);

				//리스트에 vo를 추가
				list.add(vo);				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}


		return list;
	}
		
		public int insertSche(ScheduleVO vo){
			String sql = "insert into schedule values(?,?,?,?,?,?)";
			int result = 0;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			
			try {			
				//conn , pstmt ,resultset	
				conn = DriverManager.getConnection(url, uid, upw);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, vo.getSchenum());
				pstmt.setString(2, vo.getSchedate());
				pstmt.setString(3, vo.getSchetime());
				pstmt.setString(4, vo.getLeftseat());
				pstmt.setString(5, vo.getTheatervo().getTheanum());
				pstmt.setString(6, vo.getFilmvo().getFilmnum());
				
				
				// 매개변수로 받아온 값
			
				result = pstmt.executeUpdate();

				

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}


			return result;
	}
	

}
