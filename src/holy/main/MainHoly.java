package holy.main;

import java.util.List;
import java.util.Scanner;

import holy.dao.HMemberDAO;
import holy.dao.FilmDAO;
import holy.vo.HmemberVO;
import holy.vo.FilmVO;




public class MainHoly {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		FilmDAO movieDAO = new FilmDAO();
		
		List<FilmVO> list = movieDAO.getMovie();
		
//		for(FilmVO a: list) {
//			System.out.println("영화번호 : "+a.getMovie_no()+", 영화이름 : "+a.getMovie_name()+", 러닝타임 : "+
//		a.getMovie_run()+"분 , 영화가격: "+a.getMovie_Price()+"원");
//		}
//		
//		HMemberDAO hmemberDAO = new HMemberDAO();
//		List<HmemberVO> list2 = hmemberDAO.getMovie();
//		for(HmemberVO a: list2) {
//			System.out.println("아이디 : "+a.getH_id()+", 회원이름 : "+a.getH_name()+", 전화번호 : "+
//		a.getH_phone()+" , 패스워드: "+a.getH_password());
//		}
		
		
		
	}

	
	
}
