package com.neuedu.olms.mapper;

import com.neuedu.olms.po.Token;

public interface TokenMapper {
	public void add(Token token);
	
	public void update(Token token);
	
	public Token getTokenByTokenStr(String tokenStr);
	
	public Token getTokenByUserId(Long userId);
}
