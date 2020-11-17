package com.bb.controller;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bb.dto.MemberDto;
import com.bb.dto.RsAcademicDto;
import com.bb.dto.RsCareerDto;
import com.bb.dto.RsDto;
import com.bb.dto.RsLicenseDto;
import com.bb.model.biz.RsBiz;
import com.bb.model.biz.RsBizImpl;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/resumecontroller.do")
public class ResumeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		RsBiz biz = new RsBizImpl();
		HttpSession session = request.getSession();

		
		String path = "/Users/sara/Workspaces/workspace_Web/IT_JOBS/WebContent/resources/upload_img";
		//String path = "C:/Users/IBK/Desktop/KH/IT_JOBS/IT_JOBS/WebContent/resources/upload_img"; // 경로 입력!!!
		
		int size = 1024*1024*5; //파일 크기 5mb
		MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
		
		String command = multi.getParameter("command");
		
		if(command.equals("resume-insertform")) {
			
				// rs
				MemberDto memberdto = (MemberDto) session.getAttribute("login");
				int member_no = memberdto.getMember_no();
				
				String rs_img_name = multi.getFilesystemName("rs_img");
				String rs_img_path = path + "/" + rs_img_name;
				String rs_selfintro = multi.getParameter("rs_selfintro");
				String rs_title = multi.getParameter("rs_title");
				
				RsDto rs_dto = new RsDto(member_no, rs_img_name, rs_img_path, rs_selfintro, rs_title);
				
				
				int rs_no = biz.insertResume(rs_dto);
				if(rs_no > 0) {
					System.out.println("[resume] db저장 성공 , rs_no : "+rs_no);
				} else {
					System.out.println("[resume] db저장 실패");
				}
				
				// rs_ac
				String[] rs_ac_name = multi.getParameterValues("rs_ac_name");
				
				if(!rs_ac_name[0].isEmpty()) {
					String[] rs_ac_dept = multi.getParameterValues("rs_ac_dept");
					String[] rs_ac_grad = multi.getParameterValues("rs_ac_grad");
					String[] start_year = multi.getParameterValues("rs_ac_start_year");
					String[] end_year = multi.getParameterValues("rs_ac_end_year");
					String[] start_month = multi.getParameterValues("rs_ac_start_month");
					String[] end_month = multi.getParameterValues("rs_ac_end_month");
					
					int[] rs_ac_start_year = Arrays.stream(start_year).mapToInt(Integer::parseInt).toArray();
					int[] rs_ac_end_year = Arrays.stream(end_year).mapToInt(Integer::parseInt).toArray();
					int[] rs_ac_start_month = Arrays.stream(start_month).mapToInt(Integer::parseInt).toArray();
					int[] rs_ac_end_month = Arrays.stream(end_month).mapToInt(Integer::parseInt).toArray();

					
					List<RsAcademicDto> ac_list = new ArrayList<RsAcademicDto>();
					
					if(rs_ac_name.length != 0) {
						for(int i=0; i < rs_ac_name.length; i++) {
							RsAcademicDto ac_dto = new RsAcademicDto(rs_no, rs_ac_name[i], rs_ac_dept[i], rs_ac_grad[i], 
									rs_ac_start_year[i], rs_ac_start_month[i], rs_ac_end_year[i], rs_ac_end_month[i]); 
							
							ac_list.add(ac_dto);
						}
						
						int ac_res = biz.insertAcademic(ac_list);
						if(ac_res>0) {
							System.out.println("[academic] db저장 성공");
						} else {
							System.out.println("[academic] db저장 실패");
						}
					}
					
					
				}
				
				//rs_cr
				String[] rs_cr_name = multi.getParameterValues("rs_cr_name");
				if(!rs_cr_name[0].isEmpty()) {
					String[] rs_cr_duty = multi.getParameterValues("rs_cr_duty");
					String[] rs_cr_dept = multi.getParameterValues("rs_cr_dept");
					String[] cr_start_year = multi.getParameterValues("rs_cr_start_year");
					String[] cr_start_month = multi.getParameterValues("rs_cr_start_month");
					String[] cr_end_year = multi.getParameterValues("rs_cr_end_year");
					String[] cr_end_month = multi.getParameterValues("rs_cr_end_month");
					
					int[] rs_cr_start_year = Arrays.stream(cr_start_year).mapToInt(Integer::parseInt).toArray();
					int[] rs_cr_start_month = Arrays.stream(cr_start_month).mapToInt(Integer::parseInt).toArray();
					int[] rs_cr_end_year = Arrays.stream(cr_end_year).mapToInt(Integer::parseInt).toArray();
					int[] rs_cr_end_month = Arrays.stream(cr_end_month).mapToInt(Integer::parseInt).toArray();
					
					List<RsCareerDto> cr_list = new ArrayList<RsCareerDto>();
					
					if(rs_cr_name.length != 0) {
						for(int i=0; i < rs_cr_name.length; i++) {
							RsCareerDto cr_dto = new RsCareerDto(rs_no, rs_cr_name[i], rs_cr_duty[i], rs_cr_dept[i],
									rs_cr_start_year[i], rs_cr_start_month[i], rs_cr_end_year[i], rs_cr_end_month[i]);
							
							cr_list.add(cr_dto);
						}
						
						int cr_res = biz.insertCareer(cr_list);
						if(cr_res>0) {
							System.out.println("[career] db저장 성공");
						} else {
							System.out.println("[career] db저장 실패");
						}
					}
						
				}
				
				
				//rs_lc
				String[] rs_lc_name = multi.getParameterValues("rs_lc_name");
				if(!rs_lc_name[0].isEmpty()) {
					String[] rs_lc_inst = multi.getParameterValues("rs_lc_inst");
					String[] rs_lc_date_year = multi.getParameterValues("rs_lc_date_year");
					String[] rs_lc_date_month = multi.getParameterValues("rs_lc_date_month");
					String[] rs_lc_date_day = multi.getParameterValues("rs_lc_date_day");
					
					List<RsLicenseDto> lc_list = new ArrayList<RsLicenseDto>();
					
					if(rs_lc_name.length != 0) {
						for(int i=0; i < rs_lc_name.length; i++) {
							
							if(rs_lc_date_month[i].length()==1) {
								rs_lc_date_month[i] = "0" + rs_lc_date_month[i];
							}
							if(rs_lc_date_day[i].length()==1) {
								rs_lc_date_day[i] = "0" + rs_lc_date_day[i];
							}
							
							String rs_lc_date = rs_lc_date_year[i] +"-"+ rs_lc_date_month[i] +"-"+ rs_lc_date_day[i];

							RsLicenseDto lc_dto = new RsLicenseDto(rs_no, rs_lc_name[i], rs_lc_inst[i], rs_lc_date);
							
							lc_list.add(lc_dto);
						}
						
						int lc_res = biz.insertLicense(lc_list);
						if(lc_res>0) {
							System.out.println("[license] db저장 성공");
						} else {
							System.out.println("[license] db저장 실패");
						}
						
					}	
				}
				
				if(rs_no>0) {
					jsResponse("이력서 입력 성공", "indimember.do?command=resume", response );
				}else {
					jsResponse("이력서 입력 실패", "indimember.do?command=resume", response );
				}
				
		
		} else if(command.equals("rs_update")) {
			
			int rs_no = Integer.parseInt(multi.getParameter("rs_no"));
			
			String rs_img_name = multi.getFilesystemName("rs_img");
			String rs_img_path = path + "/" + rs_img_name;
			String rs_title = multi.getParameter("rs_title");
			
			RsDto rs_dto = new RsDto(rs_no, rs_img_name, rs_img_path, rs_title);
			
			int res = biz.updateResume(rs_dto);
			if(res>0) {
				jsResponse("수정 성공", "indimember.do?command=resume-detail&rs_no="+rs_no, response);
			} else {
				jsResponse("수정 실패", "indimember.do?command=resume-detail&rs_no="+rs_no, response);
			}
			
		}
		

	}
	
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String result = "<script> alert(\"" + msg + "\"); location.href=\""+url+"\"; </script> ";
		response.getWriter().append(result);
	}

}
