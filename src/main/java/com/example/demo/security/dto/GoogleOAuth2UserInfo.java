package com.example.demo.security.dto;

import com.example.demo.common.type.AuthType;
import lombok.Getter;

import java.util.Map;

@Getter
public class GoogleOAuth2UserInfo extends OAuth2UserInfo{

	private final String name;
	private final String email;
	private final AuthType authType;


	public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
		super(attributes);
		this.email = (String)attributes.get("email");
		this.authType = AuthType.GOOGLE;
		this.name = (String) attributes.get("name");
	}


}