package com.basic.a;



public interface EmailService {
	
	public EmailVO selectEmail(String email_num)throws Exception;
	
	public int insertEmail(EmailVO vo) throws Exception;
}
