package com.bb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/IndiMemberServlet")
public class IndiMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");

		RsBiz biz = new RsBizImpl();

		HttpSession session = request.getSession();

		if (command.equals("resume")) {
			MemberDto login = (MemberDto)session.getAttribute("login");
			List<RsDto> resumes = biz.selectResumeList(login.getMember_no());

			request.setAttribute("resumes", resumes);

			dispatch("resume.jsp", request, response);

		} else if (command.equals("resume-detail")) {

			int rs_no = Integer.parseInt(request.getParameter("rs_no"));

			RsDto resume = biz.selectResumeDetail(rs_no);
			List<RsAcademicDto> academic_list = biz.selectAcademicList(rs_no);
			List<RsCareerDto> career_list = biz.selectCareerList(rs_no);
			List<RsLicenseDto> license_list = biz.selectLicenseList(rs_no);
			

			request.setAttribute("resume", resume);
			request.setAttribute("ac_list", academic_list);
			request.setAttribute("cr_list", career_list);
			request.setAttribute("lc_list", license_list);

			dispatch("resume-detail.jsp", request, response);

		} else if (command.equals("resume-insert")) {

			response.sendRedirect("resume-insert.jsp");

		} else if (command.equals("rs_ac_update")) {
			MemberDto loginDto = (MemberDto)session.getAttribute("login");
			int member_no = loginDto.getMember_no();
			
			int rs_no = Integer.parseInt(request.getParameter("rs_no"));
			
			String[] ac_no = (request.getParameterValues("rs_ac_no")==null)?null:request.getParameterValues("rs_ac_no");
			String[] rs_ac_name = (request.getParameterValues("rs_ac_name")==null)?null:request.getParameterValues("rs_ac_name");
			String[] rs_ac_dept = (request.getParameterValues("rs_ac_dept")==null)?null:request.getParameterValues("rs_ac_dept");
			String[] rs_ac_grad = (request.getParameterValues("rs_ac_grad")==null)?null:request.getParameterValues("rs_ac_grad");
			String[] start_year = (request.getParameterValues("rs_ac_start_year")==null)?null:request.getParameterValues("rs_ac_start_year");
			String[] end_year = (request.getParameterValues("rs_ac_end_year")==null)?null:request.getParameterValues("rs_ac_end_year");
			String[] start_month = (request.getParameterValues("rs_ac_start_month")==null)?null:request.getParameterValues("rs_ac_start_month");
			String[] end_month = (request.getParameterValues("rs_ac_end_month")==null)?null:request.getParameterValues("rs_ac_end_month");
			
			int[] rs_ac_start_year = null;
			int[] rs_ac_start_month = null;
			int[] rs_ac_end_year = null;
			int[] rs_ac_end_month = null;
			if(start_year != null) {
				rs_ac_start_year = Arrays.stream(start_year).mapToInt(Integer::parseInt).toArray();
				rs_ac_start_month = Arrays.stream(start_month).mapToInt(Integer::parseInt).toArray();
				rs_ac_end_year = Arrays.stream(end_year).mapToInt(Integer::parseInt).toArray();
				rs_ac_end_month = Arrays.stream(end_month).mapToInt(Integer::parseInt).toArray();
			}

			List<RsAcademicDto> ac_update_list = new ArrayList<RsAcademicDto>();
			List<RsAcademicDto> ac_insert_list = new ArrayList<RsAcademicDto>();
			
			
			int[] rs_ac_no;
			int ac_insert = 0;
			int ac_update = 0;
			int ac_delete = 0;
			if(ac_no != null) {
				rs_ac_no = Arrays.stream(ac_no).mapToInt(Integer::parseInt).toArray();
				
				//update
				for(int i=0; i<rs_ac_no.length; i++) {
					RsAcademicDto ac_dto = new RsAcademicDto(rs_ac_no[i], rs_no,  
							rs_ac_name[i], rs_ac_dept[i], rs_ac_grad[i],
							rs_ac_start_year[i], rs_ac_start_month[i], rs_ac_end_year[i], rs_ac_end_month[i]);
					
					ac_update_list.add(ac_dto);
				}
				
				ac_update = biz.updateAcademic(ac_update_list);
				
				//delete
				List<RsAcademicDto> ac_no_list = biz.selectAcNo(rs_no);
				if(ac_no_list.size() > 0) {
				
					for(int i=0; i<ac_no_list.size(); i++) {
						RsAcademicDto dto = ac_no_list.get(i);
						int list_val = dto.getRs_ac_no();
						int result = 0;
						
						for(int j=0; j<rs_ac_no.length; j++) {
							if(rs_ac_no[j] == list_val) {
								result++;
							}
						}
						if(result == 0) {
							ac_delete = biz.deleteAcademic(list_val);
						}
					}
				}
				
				//insert
				if(rs_ac_no.length < rs_ac_name.length) {
					for (int i=rs_ac_no.length; i<rs_ac_name.length; i++) {
						RsAcademicDto ac_dto = new RsAcademicDto(rs_no,
								rs_ac_name[i], rs_ac_dept[i], rs_ac_grad[i],
								rs_ac_start_year[i], rs_ac_start_month[i], rs_ac_end_year[i], rs_ac_end_month[i]);

						ac_insert_list.add(ac_dto);
					}
					
					ac_insert = biz.insertAcademic(ac_insert_list);
				}
				
			} else {
				ac_delete = biz.deleteAcademicAll(rs_no);
				
				if(rs_ac_name != null) {
					//insert
					for (int i=0; i<rs_ac_name.length; i++) {
						RsAcademicDto ac_dto = new RsAcademicDto(rs_no,
								rs_ac_name[i], rs_ac_dept[i], rs_ac_grad[i],
								rs_ac_start_year[i], rs_ac_start_month[i], rs_ac_end_year[i], rs_ac_end_month[i]);

						ac_insert_list.add(ac_dto);
					}
					ac_insert = biz.insertAcademic(ac_insert_list);
				}
			}
			
			response.getWriter().println(rs_no);


		} else if(command.equals("rs_cr_update")) {
			
			MemberDto loginDto = (MemberDto)session.getAttribute("login");
			int member_no = loginDto.getMember_no();
			
			int rs_no = Integer.parseInt(request.getParameter("rs_no"));
			
			String[] cr_no = (request.getParameterValues("rs_cr_no")==null)?null:request.getParameterValues("rs_cr_no");
			String[] rs_cr_name = (request.getParameterValues("rs_cr_name")==null)?null:request.getParameterValues("rs_cr_name");
			String[] rs_cr_duty = (request.getParameterValues("rs_cr_duty")==null)?null:request.getParameterValues("rs_cr_duty");
			String[] rs_cr_dept = (request.getParameterValues("rs_cr_dept")==null)?null:request.getParameterValues("rs_cr_dept");
			String[] start_year = (request.getParameterValues("rs_cr_start_year")==null)?null:request.getParameterValues("rs_cr_start_year");
			String[] start_month = (request.getParameterValues("rs_cr_start_month")==null)?null:request.getParameterValues("rs_cr_start_month");
			String[] end_year = (request.getParameterValues("rs_cr_end_year")==null)?null:request.getParameterValues("rs_cr_end_year");
			String[] end_month = (request.getParameterValues("rs_cr_end_month")==null)?null:request.getParameterValues("rs_cr_end_month");
			
			int[] rs_cr_start_year = null;
			int[] rs_cr_start_month = null;
			int[] rs_cr_end_year = null;
			int[] rs_cr_end_month = null;
			if(start_year != null) {
				rs_cr_start_year = Arrays.stream(start_year).mapToInt(Integer::parseInt).toArray();
				rs_cr_start_month = Arrays.stream(start_month).mapToInt(Integer::parseInt).toArray();
				rs_cr_end_year = Arrays.stream(end_year).mapToInt(Integer::parseInt).toArray();
				rs_cr_end_month = Arrays.stream(end_month).mapToInt(Integer::parseInt).toArray();
			}

			List<RsCareerDto> cr_update_list = new ArrayList<RsCareerDto>();
			List<RsCareerDto> cr_insert_list = new ArrayList<RsCareerDto>();
			
			int[] rs_cr_no;
			int cr_insert = 0;
			int cr_update = 0;
			int cr_delete = 0;
			if(cr_no != null) {
				rs_cr_no = Arrays.stream(cr_no).mapToInt(Integer::parseInt).toArray();
				
				//update
				for(int i=0; i<rs_cr_no.length; i++) {
					RsCareerDto cr_dto = new RsCareerDto(rs_cr_no[i], rs_no,  
							rs_cr_name[i], rs_cr_duty[i], rs_cr_dept[i],
							rs_cr_start_year[i], rs_cr_start_month[i], rs_cr_end_year[i], rs_cr_end_month[i]);
					
					cr_update_list.add(cr_dto);
				}
				
				cr_update = biz.updateCareer(cr_update_list);
				
				//delete
				List<RsCareerDto> cr_no_list = biz.selectCrNo(rs_no);
				if(cr_no_list.size() > 0) {
					for(int i=0; i<cr_no_list.size(); i++) {
						RsCareerDto dto = cr_no_list.get(i);
						int list_val = dto.getRs_cr_no();
						int result = 0;
						
						for(int j=0; j<rs_cr_no.length; j++) {
							if(rs_cr_no[j] == list_val) {
								result++;
							}
						}
						if(result == 0) {
							cr_delete = biz.deleteCareer(list_val);
						}
					}
				}
				
				//insert
				if(rs_cr_no.length < rs_cr_name.length) {
					for (int i=rs_cr_no.length; i<rs_cr_name.length; i++) {
						RsCareerDto ac_dto = new RsCareerDto(rs_no,
								rs_cr_name[i], rs_cr_duty[i], rs_cr_dept[i],
								rs_cr_start_year[i], rs_cr_start_month[i], rs_cr_end_year[i], rs_cr_end_month[i]);

						cr_insert_list.add(ac_dto);
					}
					
					cr_insert = biz.insertCareer(cr_insert_list);

				}				
				
			} else {
				cr_delete = biz.deleteCareerAll(rs_no);
				
				if(rs_cr_name != null) {
					//insert
					for (int i=0; i<rs_cr_name.length; i++) {
						RsCareerDto cr_dto = new RsCareerDto(rs_no,
								rs_cr_name[i], rs_cr_duty[i], rs_cr_dept[i],
								rs_cr_start_year[i], rs_cr_start_month[i], rs_cr_end_year[i], rs_cr_end_month[i]);

						cr_insert_list.add(cr_dto);
					}
					cr_insert = biz.insertCareer(cr_insert_list);
				}
			}
			
			response.getWriter().println(rs_no);

		} else if(command.equals("rs_lc_update")) {
			
			MemberDto loginDto = (MemberDto)session.getAttribute("login");
			int member_no = loginDto.getMember_no();
			
			int rs_no = Integer.parseInt(request.getParameter("rs_no"));
			
			String[] lc_no = (request.getParameterValues("rs_lc_no")==null)?null:request.getParameterValues("rs_lc_no");
			String[] rs_lc_name = (request.getParameterValues("rs_lc_name")==null)?null:request.getParameterValues("rs_lc_name");
			String[] rs_lc_inst = (request.getParameterValues("rs_lc_inst")==null)?null:request.getParameterValues("rs_lc_inst");
			String[] date_year = (request.getParameterValues("rs_lc_date_year")==null)?null:request.getParameterValues("rs_lc_date_year");
			String[] date_month = (request.getParameterValues("rs_lc_date_month")==null)?null:request.getParameterValues("rs_lc_date_month");
			String[] date_day = (request.getParameterValues("rs_lc_date_day")==null)?null:request.getParameterValues("rs_lc_date_day");
			
			
			List<RsLicenseDto> lc_update_list = new ArrayList<RsLicenseDto>();
			List<RsLicenseDto> lc_insert_list = new ArrayList<RsLicenseDto>();
			
			int[] rs_lc_no;
			int lc_insert = 0;
			int lc_update = 0;
			int lc_delete = 0;
			if(lc_no != null) {
				rs_lc_no = Arrays.stream(lc_no).mapToInt(Integer::parseInt).toArray();
				
				//update
				for(int i=0; i<rs_lc_no.length; i++) {
					String rs_lc_date = date_year[i]+"-"+date_month[i]+"-"+date_day[i];

					RsLicenseDto lc_dto = new RsLicenseDto(rs_lc_no[i], rs_no,  
							rs_lc_name[i], rs_lc_inst[i], rs_lc_date);
							
					lc_update_list.add(lc_dto);
				}
				
				lc_update = biz.updateLicense(lc_update_list);
				
				//delete 
				List<RsLicenseDto> lc_no_list = biz.selectLcNo(rs_no);
				if(lc_no_list.size() > 0) {
					for(int i=0; i<lc_no_list.size(); i++) {
						RsLicenseDto dto = lc_no_list.get(i);
						int list_val = dto.getRs_lc_no();
						int result = 0;
						
						for(int j=0; j<rs_lc_no.length; j++) {
							if(rs_lc_no[j] == list_val) {
								result++;
							}
						}
						if(result == 0) {
							lc_delete = biz.deleteLicense(list_val);
						}
					}	
				}
				
				//insert
				if(rs_lc_no.length < rs_lc_name.length) {
					for (int i=rs_lc_no.length; i<rs_lc_name.length; i++) {
						String rs_lc_date = date_year[i]+"-"+date_month[i]+"-"+date_day[i];

						RsLicenseDto lc_dto = new RsLicenseDto(rs_no,
								rs_lc_name[i], rs_lc_inst[i], rs_lc_date);

						lc_insert_list.add(lc_dto);
					}
					
					lc_insert = biz.insertLicense(lc_insert_list);
				}
				
				
			} else {
				lc_delete = biz.deleteLicenseAll(rs_no);
				
				if(rs_lc_name != null) {
					//insert
					for (int i=0; i<rs_lc_name.length; i++) {
						String rs_lc_date = date_year[i]+"-"+date_month[i]+"-"+date_day[i];

						RsLicenseDto lc_dto = new RsLicenseDto(rs_no,
								rs_lc_name[i], rs_lc_inst[i], rs_lc_date);

						lc_insert_list.add(lc_dto);
					}
					lc_insert = biz.insertLicense(lc_insert_list);
				}
			}
			
			response.getWriter().println(rs_no);

		}else if(command.equals("self_update")) {
			
			int rs_no = Integer.parseInt(request.getParameter("rs_no"));
			String selfintro = (request.getParameter("rs_selfintro") == null)?"" : request.getParameter("rs_selfintro");
			RsDto dto = new RsDto(rs_no, selfintro);
			System.out.println(rs_no);
			System.out.println(selfintro);
			if(biz.updateSelfintro(dto)>0) {
				jsResponse("수정 성공", "indimember.do?command=resume-detail&rs_no="+rs_no, response);
			} else {
				jsResponse("수정 실패", "indimember.do?command=resume-detail&rs_no="+rs_no, response);
			}
			
		} else if(command.equals("delete_resume")) {
			
			int rs_no = Integer.parseInt(request.getParameter("rs_no"));
			if(biz.deleteResume(rs_no)>0) {
				jsResponse("이력서 삭제 성공", "indimember.do?command=resume", response);
			} else{
				jsResponse("이력서 삭제 실패", "indimember.do?command=resume", response);
			}
			
		}


	}

	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String result = "<script> alert(\"" + msg + "\"); location.href=\"" + url + "\"; </script> ";
		response.getWriter().append(result);
	}

}
