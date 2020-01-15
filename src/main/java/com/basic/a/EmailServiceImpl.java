package com.basic.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("EmailService")
public class EmailServiceImpl implements EmailService{

		
	@Autowired
	private EmailDao EmailDao;
	
	@Override
	@Transactional
	public EmailVO selectEmail(String email_num) throws Exception {
		return EmailDao.selectEmail(email_num);
	}

	@Override
	public int insertEmail(EmailVO vo) throws Exception {
		
		return 0;
	}

}