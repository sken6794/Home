package holy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import holy.main.MovieDBProperties;
import holy.vo.FilmVO;


public class FilmDAO {
	
	private String url = MovieDBProperties.URL;
	private String uid = MovieDBProperties.UID;
	private String upw = MovieDBProperties.UPW;

	// 생성자

	public FilmDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("CLASS FOR NAME ERR");
		}		
	}

	// 메서드 (데이터베이스 결과가 1행 => vo를 반환
	//		 데이터베이스 결과가 여러행 => List<VO>를 반환)
	public List<FilmVO> getMovie() { // 매개변수 뭘로 받아오는지..

		String sql = "SELECT * FROM FILM";
		List<FilmVO> list = new ArrayList<>(); 
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
				//String movie_no, String movie_name, String movie_content, String movie_run, int price
				String filmNum = rs.getString("filmnum");
				String filmTitle = rs.getString("filmtitle");
				String filmContent = rs.getString("filmcontent");
				String filmRuntime = rs.getString("filmruntime");
				int filmPrice = rs.getInt("filmPrice");
				
				//1행에 대한 값을 저장
				FilmVO vo = new FilmVO(filmNum,filmTitle,filmContent,filmRuntime,filmPrice);
				
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
