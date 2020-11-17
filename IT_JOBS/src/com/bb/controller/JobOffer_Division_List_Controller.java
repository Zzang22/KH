package com.bb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bb.dto.JobOfferDivisionListDto;
import com.bb.dto.MemberDto;
import com.bb.dto.RsDto;
import com.bb.model.biz.JobOfferDivisionListBiz;
import com.bb.model.biz.JobOfferDivisionListBizImpl;
import com.bb.model.dao.JobOfferDivisionListDao;
import com.bb.model.dao.JobOfferDivisionListDaoImpl;

@WebServlet("/JobOffer_Division_List_Controller")
public class JobOffer_Division_List_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		JobOfferDivisionListBiz biz = new JobOfferDivisionListBizImpl();
		
		JobOfferDivisionListDto dto = null;
		
		List<JobOfferDivisionListDto> list = null;
		
		String command = request.getParameter("command");
		
		//HttpSession
		HttpSession session = request.getSession();

		try {
			if (command.equals("joboffer_division")) {
				
				response.sendRedirect("joboffer_division.jsp");

			} else if (command.equals("joboffer_division_list")) {
				
				String[] saf = request.getParameterValues("field");
				int[] field = new int[saf.length];
				for (int i = 0; i < saf.length; i++) {
					field[i] = Integer.parseInt(saf[i]);
				}
				
				int career = Integer.parseInt(request.getParameter("career"));
				
				int min_salary = Integer.parseInt(request.getParameter("min_salary").replace(",", ""));
				
				int max_salary = Integer.parseInt(request.getParameter("max_salary").replace(",", ""));
				
				if (field.length == 1) {
					if(career != 0 && min_salary != 0 && max_salary != 0) {
						biz = new JobOfferDivisionListBizImpl();
						dto = new JobOfferDivisionListDto();
						dto.setField1(field[0]);
						dto.setCareer(career);
						dto.setMin_salary(min_salary);
						dto.setMax_salary(max_salary);
						list = biz.selectList(dto);
						request.setAttribute("list", list);
						dispatch("joboffer_division_list.jsp", request, response);
					}
				} else if (field.length == 2) {
					if(career != 0 && min_salary != 0 && max_salary != 0) {
						biz = new JobOfferDivisionListBizImpl();
						dto = new JobOfferDivisionListDto();
						dto.setField1(field[0]);
						dto.setField2(field[1]);
						dto.setCareer(career);
						dto.setMin_salary(min_salary);
						dto.setMax_salary(max_salary);
						list = biz.selectList(dto);
						request.setAttribute("list", list);
						dispatch("joboffer_division_list.jsp", request, response);
					}
				} else if (field.length == 3) {
					if(career != 0 && min_salary != 0 && max_salary != 0) {
						biz = new JobOfferDivisionListBizImpl();
						dto = new JobOfferDivisionListDto();
						dto.setField1(field[0]);
						dto.setField2(field[1]);
						dto.setField3(field[2]);
						dto.setCareer(career);
						dto.setMin_salary(min_salary);
						dto.setMax_salary(max_salary);
						list = biz.selectList(dto);
						request.setAttribute("list", list);
						dispatch("joboffer_division_list.jsp", request, response);
					}
				} else if (field.length == 4) {
					if(career != 0 && min_salary != 0 && max_salary != 0) {
						biz = new JobOfferDivisionListBizImpl();
						dto = new JobOfferDivisionListDto();
						dto.setField1(field[0]);
						dto.setField2(field[1]);
						dto.setField3(field[2]);
						dto.setField4(field[3]);
						dto.setCareer(career);
						dto.setMin_salary(min_salary);
						dto.setMax_salary(max_salary);
						list = biz.selectList(dto);
						request.setAttribute("list", list);
						dispatch("joboffer_division_list.jsp", request, response);
					}
				} else if (field.length == 5) {
					if(career != 0 && min_salary != 0 && max_salary != 0) {
						biz = new JobOfferDivisionListBizImpl();
						dto = new JobOfferDivisionListDto();
						dto.setField1(field[0]);
						dto.setField2(field[1]);
						dto.setField3(field[2]);
						dto.setField4(field[3]);
						dto.setField5(field[4]);
						dto.setCareer(career);
						dto.setMin_salary(min_salary);
						dto.setMax_salary(max_salary);
						list = biz.selectList(dto);
						request.setAttribute("list", list);
						dispatch("joboffer_division_list.jsp", request, response);
					}
				} else if (field.length == 6) {
					if(career != 0 && min_salary != 0 && max_salary != 0) {
						biz = new JobOfferDivisionListBizImpl();
						dto = new JobOfferDivisionListDto();
						dto.setField1(field[0]);
						dto.setField2(field[1]);
						dto.setField3(field[2]);
						dto.setField4(field[3]);
						dto.setField5(field[4]);
						dto.setField6(field[5]);
						dto.setCareer(career);
						dto.setMin_salary(min_salary);
						dto.setMax_salary(max_salary);
						list = biz.selectList(dto);
						request.setAttribute("list", list);
						dispatch("joboffer_division_list.jsp", request, response);
					}
				} else if (field.length == 7) {
					if(career != 0 && min_salary != 0 && max_salary != 0) {
						biz = new JobOfferDivisionListBizImpl();
						dto = new JobOfferDivisionListDto();
						dto.setField1(field[0]);
						dto.setField2(field[1]);
						dto.setField3(field[2]);
						dto.setField4(field[3]);
						dto.setField5(field[4]);
						dto.setField6(field[5]);
						dto.setField7(field[6]);
						dto.setCareer(career);
						dto.setMin_salary(min_salary);
						dto.setMax_salary(max_salary);
						list = biz.selectList(dto);
						request.setAttribute("list", list);
						dispatch("joboffer_division_list.jsp", request, response);
					}
				} else if (field.length == 8) {
					if(career != 0 && min_salary != 0 && max_salary != 0) {
						biz = new JobOfferDivisionListBizImpl();
						dto = new JobOfferDivisionListDto();
						dto.setField1(field[0]);
						dto.setField2(field[1]);
						dto.setField3(field[2]);
						dto.setField4(field[3]);
						dto.setField5(field[4]);
						dto.setField6(field[5]);
						dto.setField7(field[6]);
						dto.setField8(field[7]);
						dto.setCareer(career);
						dto.setMin_salary(min_salary);
						dto.setMax_salary(max_salary);
						list = biz.selectList(dto);
						request.setAttribute("list", list);
						dispatch("joboffer_division_list.jsp", request, response);
					}
				} else if (field.length == 9) {
					if(career != 0 && min_salary != 0 && max_salary != 0) {
						biz = new JobOfferDivisionListBizImpl();
						dto = new JobOfferDivisionListDto();
						dto.setField1(field[0]);
						dto.setField2(field[1]);
						dto.setField3(field[2]);
						dto.setField4(field[3]);
						dto.setField5(field[4]);
						dto.setField6(field[5]);
						dto.setField7(field[6]);
						dto.setField8(field[7]);
						dto.setField9(field[8]);
						dto.setCareer(career);
						dto.setMin_salary(min_salary);
						dto.setMax_salary(max_salary);
						list = biz.selectList(dto);
						request.setAttribute("list", list);
						dispatch("joboffer_division_list.jsp", request, response);
					}
				} else if (field.length == 10) {
					if(career != 0 && min_salary != 0 && max_salary != 0) {
						biz = new JobOfferDivisionListBizImpl();
						dto = new JobOfferDivisionListDto();
						dto.setField1(field[0]);
						dto.setField2(field[1]);
						dto.setField3(field[2]);
						dto.setField4(field[3]);
						dto.setField5(field[4]);
						dto.setField6(field[5]);
						dto.setField7(field[6]);
						dto.setField8(field[7]);
						dto.setField9(field[8]);
						dto.setField10(field[9]);
						dto.setCareer(career);
						dto.setMin_salary(min_salary);
						dto.setMax_salary(max_salary);
						list = biz.selectList(dto);
						request.setAttribute("list", list);
						dispatch("joboffer_division_list.jsp", request, response);
					}
				} else if (field.length == 11) {
					if(career != 0 && min_salary != 0 && max_salary != 0) {
						biz = new JobOfferDivisionListBizImpl();
						dto = new JobOfferDivisionListDto();
						dto.setField1(field[0]);
						dto.setField2(field[1]);
						dto.setField3(field[2]);
						dto.setField4(field[3]);
						dto.setField5(field[4]);
						dto.setField6(field[5]);
						dto.setField7(field[6]);
						dto.setField8(field[7]);
						dto.setField9(field[8]);
						dto.setField10(field[9]);
						dto.setField11(field[10]);
						dto.setCareer(career);
						dto.setMin_salary(min_salary);
						dto.setMax_salary(max_salary);
						list = biz.selectList(dto);
						request.setAttribute("list", list);
						dispatch("joboffer_division_list.jsp", request, response);
					}
					
				} else if (field.length == 12) {
					if(career != 0 && min_salary != 0 && max_salary != 0) {
						biz = new JobOfferDivisionListBizImpl();
						dto = new JobOfferDivisionListDto();
						dto.setField1(field[0]);
						dto.setField2(field[1]);
						dto.setField3(field[2]);
						dto.setField4(field[3]);
						dto.setField5(field[4]);
						dto.setField6(field[5]);
						dto.setField7(field[6]);
						dto.setField8(field[7]);
						dto.setField9(field[8]);
						dto.setField10(field[9]);
						dto.setField11(field[10]);
						dto.setField12(field[11]);
						dto.setCareer(career);
						dto.setMin_salary(min_salary);
						dto.setMax_salary(max_salary);
						list = biz.selectList(dto);
						request.setAttribute("list", list);
						dispatch("joboffer_division_list.jsp", request, response);
					}
				}
				
			} else if (command.equals("joboffer_division_detail")) {
				//로그인 객체 가져오기
				int jo_no = Integer.parseInt(request.getParameter("jo_no"));
				
				JobOfferDivisionListDao dao = new JobOfferDivisionListDaoImpl();
				
				int res = dao.hitUp(jo_no);
				
				JobOfferDivisionListDto jo_dto = new JobOfferDivisionListDto();
				
				jo_dto = biz.selectOne(jo_no);
				
				if (res > 0) {
					request.setAttribute("jo_dto", jo_dto);
				}
				
				MemberDto login = (MemberDto) session.getAttribute("login");
				
				int chk_res = 0;
				
				if(login == null) {
					System.out.println("login null");
					chk_res = 2;
				} else {
					chk_res = biz.interestCheck(login.getMember_no(), jo_no);
					request.setAttribute("login", login);
				}
				System.out.println("chk_res = "+chk_res);
				request.setAttribute("chk_res", chk_res);

				dispatch("joboffer_division_detail.jsp", request, response);

				
			} else if(command.equals("insert_interest_job")) {
				int jo_no = Integer.parseInt(request.getParameter("jo_no"));
				
				MemberDto login = (MemberDto) session.getAttribute("login");
				int member_no = login.getMember_no();
				
				int res = biz.insertInterestJob(member_no, jo_no);
				if(res>0) {
					request.setAttribute("chk_res", 1);
					System.out.println("insert성공");
				} else {
					System.out.println("insert실패");
				}
				
			} else if(command.equals("delete_interest_job")) {
				int jo_no = Integer.parseInt(request.getParameter("jo_no"));
				
				MemberDto login = (MemberDto) session.getAttribute("login");
				int member_no = login.getMember_no();
				
				int res = biz.deleteInterestJob(member_no, jo_no);
				if(res>0) {
					request.setAttribute("chk_res", 0);
					System.out.println("delete성공");
				} else {
					System.out.println("delete실패");
				}
				
			}else if (command.equals("apply")) {
	            
	            MemberDto login = (MemberDto) session.getAttribute("login");
	            
	            if (login == null) {
	            	jsResponse("로그인이 필요한 서비스입니다", "loginpopup.jsp", response);
	            } else {
	               int jo_no = Integer.parseInt(request.getParameter("jo_no"));
	               request.setAttribute("jo_no", jo_no);
	               int member_no = login.getMember_no();
	               List<RsDto> myRsList = new ArrayList<RsDto>();
	               myRsList = biz.myResumeList(member_no);
	               request.setAttribute("list", myRsList);
	               dispatch("my_rs_list.jsp", request, response);
	            }
	            
	         } else if (command.equals("applyRes")) {
	            int jo_no = Integer.parseInt(request.getParameter("jo_no"));
	            int rs_no = Integer.parseInt(request.getParameter("selectedResume"));
	            
	            int res = 0 ;
	            res = biz.applyResume(rs_no, jo_no);
	            
	            if (res > 0) {
	            	jsResponse("지원에 성공하였습니다", "login_result.jsp", response);
	            } else {
	            	jsResponse("지원에 실패하였습니다.관리자에게 문의해주세요.", "JDL.do?command=joboffer_division_detail&jo_no="+jo_no, response);
	            }
	            
	         }
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			dispatch("error.jsp", request, response);
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
