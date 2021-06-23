//package com.bandsmile.crud.security;//package com.basmiletech.basmiletech.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.messaging.support.ChannelInterceptor;
//import org.springframework.messaging.support.MessageHeaderAccessor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.util.MultiValueMap;
//import org.teklend.web.security.WebSocketAuthenticatorService;
//
//import javax.naming.AuthenticationException;
//import java.util.List;
//import java.util.Map;
//
//
//public class RmeSessionChannelInterceptor implements ChannelInterceptor {
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//
//	@Autowired
//	@Qualifier("jwtUserDetailsService")
//	private UserDetailsService userDetailsService;
//	@Autowired
//	WebSocketAuthenticatorService webSocketAuthenticatorService;
//
//	@Override
//	public Message<?> preSend(Message<?> message, MessageChannel channel) {
//
//
//
//		MessageHeaders headers = message.getHeaders();
//		// StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
//		final StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
//		MultiValueMap<String, String> multiValueMap = headers.get(StompHeaderAccessor.NATIVE_HEADERS,
//				MultiValueMap.class);
//
//		if (multiValueMap != null && multiValueMap.size() > 0) {
//			for (Map.Entry<String, List<String>> head : multiValueMap.entrySet()) {
//				// System.out.println(head.getKey() + "#" + head.getValue());
//				if (head.getKey().equals("Authorization")) {
//					String authToken = null;
//					String requestHeader = head.getValue().get(0);
//					// System.out.println( "***********" + head.getValue());
//					if (requestHeader != null && requestHeader.startsWith("bearer ")) {
//						authToken = requestHeader.substring(7);
//						// System.out.println( "##########" + authToken);
//						String	username = jwtTokenUtil.getUsernameFromToken(authToken);
//						if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//							final UserDetails userDetails;
//							try {
//								userDetails = userDetailsService.loadUserByUsername(username);
//							} catch (UsernameNotFoundException e) {
//								return null;
//							}
//							if (jwtTokenUtil.validateToken(authToken, userDetails)) {
//								System.out.println("valid token");
//								try {
//									final UsernamePasswordAuthenticationToken user = webSocketAuthenticatorService
//											.getAuthenticatedOrFail(username);
//									accessor.setUser(user);
//
//								} catch (AuthenticationException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//
//								return message;
//							}
//						}
//					} else {
//						System.out.println("token null or bearer dosen't exist");
//						return null;
//					}
//				}
//
//			}
//		}
//		System.out.println("No header");
//		return null;
//	}
//}
