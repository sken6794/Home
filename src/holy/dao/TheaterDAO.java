package holy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import holy.main.MovieDBProperties;
import holy.vo.TheaterVO;

public class TheaterDAO { 
	
	private String url = MovieDBProperties.URL;
	private String uid = MovieDBProperties.UID;
	private String upw = MovieDBProperties.UPW;
	
	
	public TheaterDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("CLASS FOR NAME ERR");
		}	
	}
	
	
	public List<TheaterVO> getTheater() { // 매개변수 뭘로 받아오는지..

		String sql = "SELECT * FROM THEATER";
		List<TheaterVO> list = new ArrayList<>(); 
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
				//String theanum, int theaseat
				String theaNum = rs.getString("theanum");

				int theaSeat = rs.getInt("theaseat");
				
				//1행에 대한 값을 저장
				TheaterVO vo = new TheaterVO(theaNum,theaSeat);
				
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
	

}
