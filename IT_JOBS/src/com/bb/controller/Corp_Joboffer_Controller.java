package com.bb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bb.dto.JobOfferDivisionListDto;
import com.bb.dto.JobofferDto;
import com.bb.dto.MemberDto;
import com.bb.dto.MemberDto_ForCorp;
import com.bb.model.biz.JobOfferDivisionListBiz;
import com.bb.model.dao.CorporationDao;
import com.bb.model.dao.JobOfferDao;
import com.bb.model.dao.JobOfferDivisionListDao;
import com.bb.model.dao.JobOfferDivisionListDaoImpl;

@WebServlet("/Corp_Joboffer")
public class Corp_Joboffer_Controller extends HttpServlet {
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
		System.out.println("(" + command + ")");
		JobOfferDao dao = new JobOfferDao();

		JobOfferDivisionListBiz biz = null;
		JobOfferDivisionListDto jdto = null;
		List<JobOfferDivisionListDto> jlist = null;

		CorporationDao dao2 = new CorporationDao();

//------<기업공고 등록 메인>-----------------------------------------
		try {
			if (command.equals("joboffer_main")) {
				MemberDto login = (MemberDto) request.getSession().getAttribute("login");
				// #{jo_field_no} #{jo_career_no})#{member_id}
				String member_id = login.getMember_id();
				System.out.println(member_id);
				List<JobofferDto> list = dao.JobOfferList(member_id);
				request.setAttribute("list", list);
				dispatch("joboffer_main.jsp", request, response);

//-----<기업 공고등록 양식 페이지>--------------------------------------
			} else if (command.equals("joboffer_reg")) {
				// "member_id", jo_title, field_name, career_name, jo_salary, jo_content,
				// jo_deadline,
				// joboffer_reg_res
				MemberDto login = (MemberDto) request.getSession().getAttribute("login");
				request.setAttribute("login", login);
				JobofferDto dto = new JobofferDto();

				request.setAttribute("dto", dto);
				List<JobofferDto> list = dao.Jo_Field_name_list();
				List<JobofferDto> list2 = dao.Jo_Career_name_list();
				request.setAttribute("list", list);
				request.setAttribute("list2", list2);
				dispatch("joboffer_reg.jsp", request, response);

//------<기업공고등록 결과>--------------------------------------------	

			} else if (command.equals("joboffer_reg_res")) {
				String member_id = request.getParameter("member_id");
				String jo_title = request.getParameter("jo_title");
				String field_name = request.getParameter("field_name");
				String career_name = request.getParameter("career_name");
				int jo_salary = Integer.parseInt(request.getParameter("jo_salary"));
				String jo_content = request.getParameter("jo_content");
				Date jo_deadline = java.sql.Date.valueOf(request.getParameter("jo_deadline"));

				Integer membership = dao2.IsMemberShip(member_id);
				membership = membership == null ? 0 : membership;
				System.out.println("멤버쉽 : " + membership);

				Integer offerlimit = dao2.jobofferlimit(member_id);
				offerlimit = offerlimit == null ? 0 : offerlimit;
				// 해서 결과가 1보다 크거나 같으면 (if count >= 1)
				// if membership == null && count >= 1 글 인서트 시 경고문과 함께 인서트가 되지 않게..
				if (offerlimit >= 1 && membership == 0) {
					jsResponse("일반회원은 게시글을 1개 이상 작성할 수 없습니다.", "offer.do?command=joboffer_main", response);
				} else if(membership >= 1){

					JobofferDto dto = new JobofferDto(member_id, jo_title, field_name, career_name, jo_salary,
							jo_content, jo_deadline);

					int res = dao.JobOfferInsert(dto);
					if (res > 0) {
						jsResponse("글 등록 성공!", "offer.do?command=joboffer_main", response);
						jsResponse("수정 성공", "corp_main.jsp", response);
					} else {
						jsResponse("글 등록 실패!", "offer.do?command=joboffer_reg&member_id=" + member_id, response);
					}
				}
//-----내가등록한공고 detail----------------------------------------------------------
			} else if (command.equals("detail")) {

				int jo_no = Integer.parseInt(request.getParameter("jo_no"));
				System.out.println("detail : " + jo_no);
				JobOfferDivisionListDao jdao = new JobOfferDivisionListDaoImpl();
				int res = jdao.hitUp(jo_no);

				if (res > 0) {
					request.setAttribute("jo_no", jo_no);
					dispatch("Corp_JobOfferDetail.jsp", request, response);
				}

//------공고 수정---------------------------------------------------------------------
			} else if (command.equals("joboffer_update")) {
				// joboffer_update&jo_no
				int jo_no = Integer.parseInt(request.getParameter("jo_no"));
				System.out.println("jo_no : " + jo_no);

				List<JobofferDto> list = dao.Jo_Field_name_list();
				List<JobofferDto> list2 = dao.Jo_Career_name_list();

				request.setAttribute("list", list);
				request.setAttribute("list2", list2);
				dispatch("jobofferUpdate.jsp", request, response);
//----공고 삭제------------------------------------------------------------------------				
			} else if (command.equals("joboffer_del")) {
				int jo_no = Integer.parseInt(request.getParameter("jo_no"));
				System.out.println("del : " + jo_no);

				int res = dao.JobOfferDel(jo_no);
				if (res > 0) {
					jsResponse("글이 삭제되었습니다.", "offer.do?command=joboffer_main", response);
				} else {
					jsResponse("글 삭제 실패", "offer.do?command=detail&jo_no=" + jo_no, response);
				}
			} else if (command.equals("jobofferUpdate_res")) {
				int jo_no = Integer.parseInt(request.getParameter("jo_no"));
				String jo_title = request.getParameter("jo_title");
				String field_name = request.getParameter("field_name");
				String career_name = request.getParameter("career_name");
				int jo_salary = Integer.parseInt(request.getParameter("jo_salary"));
				String jo_content = request.getParameter("jo_content");
				Date jo_deadline = java.sql.Date.valueOf(request.getParameter("jo_deadline"));
				JobofferDto dto = new JobofferDto(jo_title, jo_content, field_name, career_name, jo_salary, jo_deadline,
						jo_no);
				int res = dao.JobOfferUpdate(dto);

				if (res > 0) {
					jsResponse("수정 성공", "offer.do?command=joboffer_main", response);
				} else {
					jsResponse("데이터 전송 실패", "joboffer_update&jo_no=" + jo_no, response);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			dispatch("error.jsp", request, response);
		}

	}

	public void dispatch(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispach = request.getRequestDispatcher(path);
		dispach.forward(request, response);
	}

	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String res = "<script>alert('" + msg + "'); location.href='" + url + "';</script>";
		out.print(res);
	}
}
