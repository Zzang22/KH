package com.bb.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bb.dto.ApplicantDto;
import com.bb.dto.CorporationDto;
import com.bb.dto.MemberDto;
import com.bb.model.biz.MemberBiz;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

@WebServlet("/Member_Controller")
public class Member_Controller extends HttpServlet {
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
		System.out.println("[" + command + "]");
		

		MemberBiz biz = new MemberBiz();
		HttpSession session = request.getSession();

//-----------<개인 회원가입 페이지로 이동>----------------------------		
		if (command.equals("join")) {
			response.sendRedirect("member_join.jsp");
//-----------<개인회원 아이디 중복확인>----------------------------				
		} else if (command.equals("member_idchk")) {
			String member_id = request.getParameter("member_id");

			Integer res = biz.MemberidCheck(member_id);

			res = res == null ? 0 : res;

			boolean idnotused = true;

			if (res > 0) {
				idnotused = false;
			} else {
				idnotused = true;
			}

			System.out.println(idnotused);

			response.sendRedirect("member_idchk.jsp?idnotused=" + idnotused);

//-----------<개인회원가입 양식 페이지>----------------------------
		} else if (command.equals("member_join")) {
			// 받은 정보들 dao로 보내고, 다시 결과 중 member_no받아서 form태그 안에 hidden으로 넣기
			// member_no, member_id, member_pw, member_name, member_birthday
			// member_postcode, member_addr, member_phone, member_email
			String member_id = request.getParameter("member_id");
			String member_pw = request.getParameter("member_pw");
			String member_name = request.getParameter("member_name");
			int member_birthday = Integer.parseInt(request.getParameter("member_birthday"));
			String member_postcode = request.getParameter("member_postcode");
			String member_addr = request.getParameter("member_addr");
			String member_phone = request.getParameter("member_phone");
			String member_email = request.getParameter("member_email");

			MemberDto dto = new MemberDto(0, member_id, member_pw, member_name, member_birthday, member_postcode,
					member_addr, member_phone, member_email, null, null);

			int res = biz.MemberJoinInsert(dto);
			if (res > 0) {
				jsResponse("IT JOBS에 회원가입해주셔서 감사합니다.", "member.do?command=member_login", response);
			} else {
				jsResponse("전송실패", "member.do?command=join", response);
			}
//-----------<회원 자체 로그인>----------------------------
		} else if (command.equals("member_login")) {

			String member_id = request.getParameter("member_id");
			String member_pw = request.getParameter("member_pw");

			MemberDto dto = biz.login(member_id, member_pw);

			if (dto==null||dto.getMember_id()==null) {
				
				String err = "아이디 또는 비밀번호가 일치하지 않습니다.";
				request.setAttribute("err", err);
				dispatch("loginpopup.jsp", request, response);
				
			} else if (dto.getMember_id() != null) {

				session.setAttribute("login", dto);
				session.setMaxInactiveInterval(-1);
				// 세션 무한대로 지정

				if (dto.getMember_role().equals("ADMIN")) {
					response.sendRedirect("adminmain.jsp");
				} else if (dto.getMember_role().equals("USER")) {
					response.sendRedirect("login_result.jsp");
				} else if (dto.getMember_role().equals("CORP")) {
					dispatch("corp_main.jsp", request, response);
				}
			}
//-----------<회원 자체 로그아웃>----------------------------	
		} else if (command.equals("member_logout")) {
			session.invalidate();
			response.sendRedirect("index.jsp");
//-----------<네이버 로그인>----------------------------		
		} else if (command.equals("naver_login")) {
			String clientId = "D3Kx4mjlM0CX8U8Is2DW";// 애플리케이션 클라이언트 아이디값";
			String clientSecret = "ddw84saok5";// 애플리케이션 클라이언트 시크릿값";
			String code = request.getParameter("code");
			String state = request.getParameter("state");
			String redirectURI = URLEncoder.encode("http://localhost:8787/IT_JOBS_before(1.0)/member.do?command=naver_login",
					"UTF-8");
			String apiURL;
			apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
			apiURL += "client_id=" + clientId;
			apiURL += "&client_secret=" + clientSecret;
			apiURL += "&redirect_uri=" + redirectURI;
			apiURL += "&code=" + code;
			apiURL += "&state=" + state;
			String access_token;
			String refresh_token;

			System.out.println("apiURL="+apiURL);

			try {
				URL url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				int responseCode = con.getResponseCode();
				BufferedReader br;
				System.out.print("responseCode="+responseCode);
				if (responseCode == 200) { // 정상 호출
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else { // 에러 발생
					br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
				String inputLine;
				StringBuffer res = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					res.append(inputLine);
				}
				br.close();

				// responseCode==200 => 오류가 없이 정상작동 됐을 경우
				if (responseCode == 200) {
					String json = res.toString();

					JSONParser parser = new JSONParser();
					Object obj = parser.parse(json);
					JSONObject jsonObj = (JSONObject) obj;

					access_token = (String) jsonObj.get("access_token");
					refresh_token = (String) jsonObj.get("refresh_token");

					String token = access_token; // 네이버 로그인 접근 토큰;
					String header = "Bearer " + token; // Bearer 다음에 공백 추가

					String apiurl = "https://openapi.naver.com/v1/nid/me";

					Map<String, String> requestHeaders = new HashMap<>();
					requestHeaders.put("Authorization", header);
					String responseBody = get(apiurl, requestHeaders);

					Object responseObj = parser.parse(responseBody);
					JSONObject resObj = (JSONObject) responseObj;
					JSONObject resobj = (JSONObject) resObj.get("response");

					// get 안에 들어가는 값은 네이버 api 값 그대로 써야함
					String naverId = (String) resobj.get("id");
					String email = (String) resobj.get("email");
					String name = (String) resobj.get("name");

					MemberDto dto = new MemberDto();

					dto.setMember_id(naverId);
					dto.setMember_email(email);
					dto.setMember_name(name);

					// 아이디 중복체크 0보다 크면 회원가입 되어있는거
					if (biz.MemberidCheck(naverId) > 0) {
						session.setAttribute("login", dto);
						session.setMaxInactiveInterval(-1);
						response.sendRedirect("login_result.jsp");
					} else {
						int snsres = biz.snslogin(dto);
						if (snsres > 0) {
							System.out.println("db등록완료");
							response.sendRedirect("login_result.jsp");
						}
					}

				}
			} catch (Exception e) {
				System.out.println(e);
			}
// -----------<구글 로그인>----------------------------
		} else if (command.equals("google_login")) {

			try {
				String idToken = request.getParameter("id_token");
				GoogleIdToken.Payload payLoad = getPayload(idToken);
				String name = (String) payLoad.get("name");
				String id = payLoad.getSubject();
				String email = payLoad.getEmail();
					
				// 아이디 중복체크 0보다 크면 회원가입 되어있는거
				if (biz.check(id) != null) {
					MemberDto dto = new MemberDto();
					
					dto = biz.check(id);
					session.setAttribute("login", dto);
					session.setMaxInactiveInterval(-1);
					response.sendRedirect("index.jsp");
				} else {
					
					MemberDto dto = new MemberDto();
					dto.setMember_id(id);
					dto.setMember_email(email);
					dto.setMember_name(name);

					int snsres = biz.snslogin(dto);
					if (snsres > 0) {
						System.out.println("db등록완료");
						response.sendRedirect("login.jsp");
					}

				}

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
// -----------<지원한 공고보기>----------------------------
		} else if (command.equals("my_apply")) {
	         MemberDto login = (MemberDto) request.getSession().getAttribute("login");
	         int member_no = login.getMember_no();
	         List<ApplicantDto> list = biz.myApply(member_no);
	         request.setAttribute("list", list);
	         dispatch("my_apply.jsp", request, response);
	         
// -----------<개인회원 정보수정>----------------------------         
	      } else if (command.equals("memberUpdate")) {
	    	    MemberDto login = (MemberDto)request.getSession().getAttribute("login");
				String member_id = login.getMember_id();
				MemberDto dto = biz.check(member_id);
				System.out.println("멤버아이디"+login.getMember_id());
				request.setAttribute("dto", dto);
				System.out.println(dto);
				dispatch("member_modify.jsp", request, response);
	    	   
	      } else if (command.equals("member_update")) {
	    	  
				String member_name = request.getParameter("member_name");
				String member_pw = request.getParameter("member_pw");
				
				String birthday = (request.getParameter("member_birthday")==null)?"0":request.getParameter("member_birthday");
				String member_postcode = request.getParameter("member_postcode");
				String member_addr = request.getParameter("member_addr");
				String member_phone = request.getParameter("member_phone");
				String member_email = request.getParameter("member_email");
				
				String member_id = request.getParameter("member_id");
				
				int member_birthday = 0;
				
				if(birthday != null) {
					member_birthday = Integer.parseInt(birthday);
				}
				
				MemberDto dto = new MemberDto(member_id, member_pw, member_name, member_birthday, member_postcode,
						member_addr, member_phone, member_email);
				
				int res = biz.memberUpdate(dto);
				if (res > 0) {
					jsResponse("수정 성공", "login_result.jsp", response);
					
				} else {
					jsResponse("전송 실패", "member.do?command=memberUpdate", response);
				} 
	      } else if(command.equals("user_main")) {
	    	  
	    	  MemberDto login = (MemberDto)request.getSession().getAttribute("login");
	    	  String member_role = login.getMember_role();
	    	 // System.out.println("role확인:"+member_role);
	    	  if(member_role.equals("USER")) {
	    		  response.sendRedirect("login_result.jsp");
	    	  }else if(member_role.equals("ADMIN")) {
	    		  response.sendRedirect("adminmain.jsp");
	    	  }
	      }
				
	}
	

	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

// alert 찍기
	public void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String res = "<script>alert('" + msg + "'); location.href='" + url + "';</script>";

		out.print(res);
	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
		}
	}

	private static final String GOOGLE_CLIENT_ID = "797227422952-p3mr2b5ebjn9ol262r4617c1e9evovpu.apps.googleusercontent.com";

	public static GoogleIdToken.Payload getPayload(String tokenString) throws Exception {

		JacksonFactory jacksonFactory = new JacksonFactory();
		GoogleIdTokenVerifier googleIdTokenVerifier = new GoogleIdTokenVerifier(new NetHttpTransport(), jacksonFactory);

		GoogleIdToken token = GoogleIdToken.parse(jacksonFactory, tokenString);

		if (googleIdTokenVerifier.verify(token)) {
			GoogleIdToken.Payload payload = token.getPayload();
			if (!GOOGLE_CLIENT_ID.equals(payload.getAudience())) {
				throw new IllegalArgumentException("Audience mismatch");
			} else if (!GOOGLE_CLIENT_ID.equals(payload.getAuthorizedParty())) {
				throw new IllegalArgumentException("Client ID mismatch");
			}
			return payload;
		} else {
			throw new IllegalArgumentException("id token cannot be verified");
		}
	}

}
