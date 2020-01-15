package com.basic.a;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {


	@Resource(name = "emailService")
	private EmailService emailService;
	
	
	@Autowired
	private JavaMailSender mailSender;

	
	
	// mailForm
	@RequestMapping(value = "/mailForm")
	public String mailForm() {

		return "/mailForm";
	}

	// mailSending 코드
	@RequestMapping(value = "/mail/mailSending")
	public String mailSending(HttpServletRequest request) {
															// db에 저장은 어떻게 할 것인가? insert기능 필요
        int ranNum[] = new int[6];
        for (int i = 0; i < ranNum.length; i++) {
			ranNum[i] = (int)(Math.random() * 9);
			for (int j = 0; j < i; j++) {
				if(ranNum[i] == ranNum[j]) {
					j--;
					break;
				}
			}
		}
        for (int i = 0; i < ranNum.length; i++) {						// 난수 6자리
		}	
        String str = Arrays.toString(ranNum).replaceAll("[^0-9]","");   // 배열을 문자형으로 변환
        System.out.println( str );
	
        
		String setfrom = "koncmii@gmail.com";
		String tomail = request.getParameter("tomail"); // 받는 사람 이메일
		String title = "회원가입 인증 이메일 입니다."; // 제목
		String content = System.getProperty("line.separator")+
	            		" 인증번호는 : " + str + " 입니다. "
	            		+ System.getProperty("line.separator");
        
		
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 생략x
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 생략o
			messageHelper.setText(content);; // 메일 내용(인증번호)
			mailSender.send(message);
			System.out.println(ranNum);
		} catch (Exception e) {
			System.out.println(e);
		}

        return "mailForm";
	}
	
	// mailChecking 코드
	@RequestMapping(value = "/mail/mailChecking")
	public String mailChecking(HttpServletRequest request, Model model) {
																			// db에 저장된걸 jsp화면에 안보이게 뿌리고 여기서 두 번호를 비교한다.
//		model.addAllAttributes(emailService.selectEmail());
		String number = request.getParameter("number");    // 회원이 페이지에 입력한 인증번호
														   // 홈페이지에서 발송한 인증번호  // db에서 받아오는걸로?
	
		
		return "/good";
		
//		}
	}

}
