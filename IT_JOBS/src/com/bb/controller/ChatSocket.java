package com.bb.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


import com.bb.dto.ChatDto;
import com.bb.dto.ChatUserDto;
import com.bb.dto.MemberDto;
import com.bb.model.biz.ChatBiz;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



// WebSocket server를 생성하기 위한 URL, handshake 설정하기 위한 클래스 지정
@ServerEndpoint(value="/chatsocket", configurator = HttpSessionConfigurator.class)
public class ChatSocket {
	
	// Collections.synchronizedMap : 동기화 된 맵. 멀티쓰레드 환경에서 안전하게 사용하기 위해서 (스레드로부터 안전하게 보호)
	private static Map<Session, EndpointConfig> configs = Collections.synchronizedMap(new HashMap<Session, EndpointConfig>());
	//handshake를 거치고 handleOpen 호출
	
	private static Map<Session, Integer> chatUserMap = new HashMap<Session, Integer>();
		
	private static Map<Integer, List<JsonObject>> chatDataMap = new HashMap<Integer, List<JsonObject>>(); //백업
	
	ChatBiz biz = new ChatBiz(); 
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	@OnOpen
	public void handleOpen(Session userSession, EndpointConfig config) {
		
		System.out.println("[클라이언트가 접속했습니다.]");
	
		if (!configs.containsKey(userSession)) {
			configs.put(userSession, config);
		}
		
	}
	

	@OnMessage
	public void handleMessage(String msg, Session userSession){
		
		EndpointConfig userConfig = configs.get(userSession);
		HttpSession httpSession = (HttpSession) userConfig.getUserProperties().get("session");
		MemberDto login = (MemberDto) httpSession.getAttribute("login");
		int member_no = login.getMember_no();
		
		if(msg.charAt(0) != '{') {
			// msg => room_no / 서버로 접속했을 때 session,방번호 매핑		
			int room_no = Integer.parseInt(msg);
			chatUserMap.put(userSession, room_no);
			
			ChatUserDto dto = new ChatUserDto(room_no, member_no);
			// 0: 이전입장 , 1: 처음입장
			if(biz.selectPrevChk(dto)==0) {
				// chatDataMap data를 client로 보내기
				if(chatDataMap.containsKey(room_no)) {
					List<JsonObject> dataList = chatDataMap.get(room_no);
					
					for(JsonObject jsonData: dataList) {
						try {
							userSession.getBasicRemote().sendText(jsonData+"");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				Date date = new Date();
				String regdate = format.format(date);
				
				String member_id = login.getMember_id();
				
				String str = "{\"room_no\":\""+room_no+"\",\"content\":\"입장\",\"regdate\":\""+regdate+"\",\"data\":\"0\",\"member_no\":2,\"member_id\":\""+member_id+"\",\"count\":0}"; 
				JsonElement element = JsonParser.parseString(str);
				JsonObject jsonData = element.getAsJsonObject();
				
				
				// chatDataMap에 jsonData추가
				List<JsonObject> jsonlist = null;
				if(!chatDataMap.containsKey(room_no)) {
					jsonlist = new ArrayList<JsonObject>();
					
				} else {
					jsonlist = chatDataMap.get(room_no);
				}
				
				jsonlist.add(jsonData);
				chatDataMap.put(room_no, jsonlist);
					
				
				synchronized(configs) {
					
					Iterator<Session> sessions = chatUserMap.keySet().iterator();
					
					while(sessions.hasNext()) {
						Session session = sessions.next();
						
						if(room_no == chatUserMap.get(session)) {
							try {
								session.getBasicRemote().sendText(jsonData+"");
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
			
			
			
		} else {
			// msg => JsonData
			
			// Json타입 메세지 받기
			String member_id = login.getMember_id();
			
			JsonElement element = JsonParser.parseString(msg);
			JsonObject jsonData = element.getAsJsonObject();
			jsonData.addProperty("member_no", member_no);
			jsonData.addProperty("member_id", member_id);
			
			int room_no = jsonData.get("room_no").getAsInt();

			// chatDataMap에 jsonData추가
			List<JsonObject> jsonlist = null;
			if(!chatDataMap.containsKey(room_no)) {
				jsonlist = new ArrayList<JsonObject>();
				jsonData.addProperty("count", 1);
				
			} else {
				jsonlist = chatDataMap.get(room_no);
				JsonObject obj = jsonlist.get(jsonlist.size()-1);
				int count = obj.get("count").getAsInt();
				jsonData.addProperty("count", ++count);
				
			}
			
			jsonlist.add(jsonData);
			chatDataMap.put(room_no, jsonlist);
				
			
			// 해당 방번호에 데이터보내기
			// 동기화 : 하나의 일 처리를 수행하는동안 사용자의 변경이 일어나면 NullPointer 에러 발생
			synchronized(configs) {
				
				Iterator<Session> sessions = chatUserMap.keySet().iterator();
				
				while(sessions.hasNext()) {
					Session session = sessions.next();
					
					if(room_no == chatUserMap.get(session) && session != userSession) {
						try {
							session.getBasicRemote().sendText(jsonData+"");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
					
	}
	
	
	@OnClose
	public void handleClose(Session userSession) {
		
		if(chatUserMap.containsKey(userSession)) {
			int room_no = chatUserMap.get(userSession);
			
			EndpointConfig config = configs.get(userSession);
			HttpSession httpSession = (HttpSession) config.getUserProperties().get("session");
			MemberDto login = (MemberDto) httpSession.getAttribute("login");
			int member_no = login.getMember_no();

			// chatDataMap에 해당room data가 있으면 insert
			if(chatDataMap.get(room_no)!=null) {
				List<JsonObject> jsonlist = chatDataMap.get(room_no);

				List<ChatDto> list = new ArrayList<ChatDto>();
				
				for(JsonObject obj: jsonlist) {
					int member_no_res = obj.get("member_no").getAsInt();
					String member_id = obj.get("member_id").getAsString();
					String chat_content = obj.get("content").getAsString();
					String regdate = obj.get("regdate").getAsString();
					
					ChatDto dto = new ChatDto(room_no, member_no_res, member_id, chat_content, regdate);
					list.add(dto);
				}
				
				
				int res = biz.insertChat(list);
				if(res>0) {
					chatDataMap.remove(room_no);
					
					// last_chat_no update
					int last_chat_no = biz.selectLastChat(room_no);
					ChatUserDto dto = new ChatUserDto(room_no, member_no, last_chat_no);
					
					if(biz.updateLastChat(dto)>0) {
						System.out.println("[클라이언트가 접속을 해제했습니다.] db update 성공");
					} else {
						// 방을 나갔을 경우
						
						// 해당 방에 유저가있으면(db) ? db에 퇴장 data insert, chatusermap에 해당 room이 있으면 ? session에게 퇴장 메세지 전송(전송만)
						
						
						if(biz.selectUserCount(room_no) > 0) {
							Date date = new Date();
							String regdate = format.format(date);
							String member_id = login.getMember_id();
						
							ChatDto chatDto = new ChatDto(room_no, 2, member_id, "퇴장", regdate);		
							List<ChatDto> chatList = new ArrayList<ChatDto>();
							chatList.add(chatDto);
							
							biz.insertChat(chatList);
							
							if(chatUserMap.containsValue(room_no)) {
								String str = "{\"room_no\":\""+room_no+"\",\"content\":\"퇴장\",\"regdate\":\""+regdate+"\",\"data\":\"0\",\"member_no\":2,\"member_id\":\""+member_id+"\",\"count\":0}"; 
								JsonElement element = JsonParser.parseString(str);
								JsonObject jsonData = element.getAsJsonObject();
								
								synchronized(configs) {
									
									Iterator<Session> sessions = chatUserMap.keySet().iterator();
									
									while(sessions.hasNext()) {
										Session session = sessions.next();
										
										if(room_no == chatUserMap.get(session) && session != userSession) {
											try {
												session.getBasicRemote().sendText(jsonData+"");
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									}
								}
							}
						}
						
						
						System.out.println("[클라이언트가 접속을 해제했습니다.] db update 실패 -> 나가기");
					}
					
				} else {
					System.out.println("[클라이언트가 접속을 해제했습니다.] db insert 실패");
				}
				
			} else {
				// 디비에 저장된 마지막chat_no -> last_chat_no
				ChatUserDto dto = new ChatUserDto(room_no, member_no);
				if(biz.updateLastChatData(dto)>0) {
					System.out.println("[클라이언트가 접속을 해제했습니다.] db data update 성공");
				} else {
					System.out.println("[클라이언트가 접속을 해제했습니다.] db data update 실패");
				}
			}
		} else {
			System.out.println("[클라이언트가 접속을 해제했습니다.] my_chat");
		}
		configs.remove(userSession);
		chatUserMap.remove(userSession);
	}

	
	@OnError
	public void handleError(Throwable e, Session userSession) {
		e.printStackTrace();
	}
	

}
