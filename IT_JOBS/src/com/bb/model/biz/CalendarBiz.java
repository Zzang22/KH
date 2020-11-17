package com.bb.model.biz;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.bb.dto.CalendarDto;
import com.bb.dto.Interest_JobDto;
import com.bb.model.dao.CalendarDao;
import com.bb.model.dao.CalendarInterDao;

public class CalendarBiz {
	private String toDates;
	private CalendarDao caldao = new CalendarDao();
	private CalendarInterDao interdao = new CalendarInterDao();

	public String getToDates() {
		return toDates;
	}

	public void setToDates(String cal_mdate) {
		// mdate(YYYYMMDDHHmm)가 넘어오는데 mdate의 형식을
		// yyyy-MM-dd hh:mm:00 변환
		//System.out.println("biz-cal_mdate확인 : "+cal_mdate); // 얘가 문제! 
		String m = cal_mdate.substring(0, 4) + "-" + cal_mdate.substring(4, 6) + "-" + cal_mdate.substring(6, 8) + " "
				+ cal_mdate.substring(8, 10) + ":" + cal_mdate.substring(10) + ":00";

		// SimpleDateFormat은 로케일 구분 방식으로 날짜를 형식화하고 구문 분석하기위한 구체적인 클래스입니다.
		// 형식화 (날짜-> 텍스트), 구문 분석 (텍스트-> 날짜) 및 정규화를 허용합니다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH시mm분"); // 날짜를 문자열(yyyy년MM월dd일 HH시mm분)로 바꾸고 있다.

		// 현재 구할 떼 사용함. 날짜 형식
		Timestamp tm = Timestamp.valueOf(m); // String을 날짜로 바꿨다. yyyy-MM-dd hh:mm:00으로 변환
		toDates = sdf.format(tm); // format 메서드를 통해서 yyyy년MM월dd일 HH시mm분 로 리턴
	
	}
	// '6' -> '06' 한자리 숫자를 두자리로  
	public static String isTwo(String msg) {
		return (msg.length() < 2) ? "0" + msg : msg;
	}

	public static String fontColor(int date, int dayOfWeek) {
		String color = "";

		if ((dayOfWeek - 1 + date) % 7 == 0) { // dayOfWeek-1+date)%7 == 0 1일의 요일의 값 -1+ 당월 dayOfWeek-1 해당요일 -1
			color = "blue";         // 토요일은 파란색
		} else if ((dayOfWeek - 1 + date) % 7 == 1) {
			color = "red";          // 일요일은 빨간색
		} else {
			color = "black";         //평일 검은색
		}

		return color;
	}

	public static String getCalView(int i, List<CalendarDto> clist) { 
		// clist yyyyMM 해당년 해당월에 모든 일정이 담아져 있다. 근데 그룹핑되어져있다(일별로)
		//System.out.println("biz-clist확인:"+clist);																
		String res = "";

		String day = isTwo(i + ""); // 오늘 날짜
	//	System.out.println("day확인:"+day);  //여기까지는 값 잘 들어옴..
		
	
		for (CalendarDto dto : clist) {
			 //yyyyMMddHHmm -> dd
		//	System.out.println("mdate확인:" + dto.getCal_mdate()); //mdate null값뜬다!! 여기가 문제!!!
			if (dto.getCal_mdate().substring(6, 8).equals(day)) { // 1일 부터 마지막 날 까지 돈다. 오늘 날짜와 짤라온 월일이 같다면
				res += "<p>" + ((dto.getCal_title().length() > 6) ? dto.getCal_title().substring(0, 6) + "..."
						: dto.getCal_title())  +"</p>";
			}
			
		}
		
		//System.out.println("res확인:"+res);
		return res;

	}
	
	public static String getDeadline(int i, List<Interest_JobDto> ilist, String yyyyMM) {
		String res ="";
		String day = isTwo(i+""); 
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		//System.out.println("biz-ilist확인:"+ilist); // deadline이 null인데.... 
		
		for(Interest_JobDto dto : ilist) {
			String deadline = transFormat.format(dto.getJo_deadline());
			//System.out.println("biz-deadline확인: "+deadline);  //여기까지 왔어
			if(deadline.substring(0,6).equals(yyyyMM)) {
				if(deadline.substring(6, 8).equals(day)) {
					res += "<p class='blink'>"+dto.getMember_name()+"<br/>공고 마감!" +"</p>";
				}
				
			}
		}
		
		return res;
	}
    
	//일정 추가
	public int insertCalBoard(CalendarDto dto) {

		return caldao.insertCalBoard(dto);
	}

	// 등록 일정 리스트
	public List<CalendarDto> selectCalendarList(String yyyyMMdd, int member_no) {
		return caldao.selectCalendarList(yyyyMMdd, member_no);
	}

	// 달력에 보이는 list
	public List<CalendarDto> calendarViewList(int member_no, String yyyyMM) {
		return caldao.calendarViewList(member_no, yyyyMM);
	}

	// 일정 하루에 일정 몇개인지
	public int calendarViewCount(int member_no, String yyyyMMdd) {
		return caldao.calendarViewCount(member_no, yyyyMMdd);
	}

	//일정 리스트에서 글 누르면 글 보이는 페이지 selectOne
	public CalendarDto selectOneBoard(int cal_no) {
		return caldao.selectOneBoard(cal_no);
	}
	//선택 삭제
	public int multiDelete(String[] cal_nos) {
		return caldao.multiDelete(cal_nos);
	}
	//deadline 가져오기
	public List<Interest_JobDto> interestJobDeadline(int member_no){
		return interdao.interestJobDeadline(member_no);
	}
	//등록한 일정 수정하기
	public int updateCalendar(CalendarDto dto) {
		
		return caldao.updateCalendar(dto);
	}
	
}