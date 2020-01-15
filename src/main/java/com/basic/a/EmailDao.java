package com.basic.a;

import org.apache.ibatis.annotations.Mapper;

import com.basic.a.EmailVO;

@Mapper
public interface EmailDao {

	public EmailVO selectEmail(String email_num)throws Exception;
	
	public int insertEmail(EmailVO vo) throws Exception;
}
