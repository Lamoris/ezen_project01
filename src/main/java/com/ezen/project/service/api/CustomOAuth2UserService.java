package com.ezen.project.service.api;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.ezen.project.Repository.MemberRepository;
import com.ezen.project.model.Member;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	HttpSession httpSession;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		OAuth2UserService delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);
		
		//어떤 회사의 로그인 OAUTH2 인지 확인
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		
		String UserNameAttributeName = userRequest.getClientRegistration()
				.getProviderDetails().getUserInfoEndpoint()
				.getUserNameAttributeName();
		
		
		String email;
		
		Map<String, Object> response = oAuth2User.getAttributes();
		
		if(registrationId.equals("naver")) {
			Map<String, Object> hash = (Map<String, Object>) response.get("response");
			
			email = (String) hash.get("email");
		}else if(registrationId.equals("google")) {
			email = (String) response.get("email");
		}else {
			throw new OAuth2AuthenticationException("허용되지 않은 인증입니다.");
		}
		
		Member member;
		Optional<Member> optionalMember =  memberRepository.findByEmail(email);
		if(optionalMember.isPresent()) {
			member = optionalMember.get();
		}else {
			member = new Member();
			member.setMemberEmail(email);
			//member.setRole(Role.MEMBER_USER);
			memberRepository.save(member);
		}
		httpSession.setAttribute("member", member);
		
		
		return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(member.getRole().toString())),
				oAuth2User.getAttributes(),
				UserNameAttributeName);
	}

}
