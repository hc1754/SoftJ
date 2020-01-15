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

	// mailSending �ڵ�
	@RequestMapping(value = "/mail/mailSending")
	public String mailSending(HttpServletRequest request) {
															// db�� ������ ��� �� ���ΰ�? insert��� �ʿ�
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
        for (int i = 0; i < ranNum.length; i++) {						// ���� 6�ڸ�
		}	
        String str = Arrays.toString(ranNum).replaceAll("[^0-9]","");   // �迭�� ���������� ��ȯ
        System.out.println( str );
	
        
		String setfrom = "koncmii@gmail.com";
		String tomail = request.getParameter("tomail"); // �޴� ��� �̸���
		String title = "ȸ������ ���� �̸��� �Դϴ�."; // ����
		String content = System.getProperty("line.separator")+
	            		" ������ȣ�� : " + str + " �Դϴ�. "
	            		+ System.getProperty("line.separator");
        
		
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // ����x
			messageHelper.setTo(tomail); // �޴»�� �̸���
			messageHelper.setSubject(title); // ����o
			messageHelper.setText(content);; // ���� ����(������ȣ)
			mailSender.send(message);
			System.out.println(ranNum);
		} catch (Exception e) {
			System.out.println(e);
		}

        return "mailForm";
	}
	
	// mailChecking �ڵ�
	@RequestMapping(value = "/mail/mailChecking")
	public String mailChecking(HttpServletRequest request, Model model) {
																			// db�� ����Ȱ� jspȭ�鿡 �Ⱥ��̰� �Ѹ��� ���⼭ �� ��ȣ�� ���Ѵ�.
//		model.addAllAttributes(emailService.selectEmail());
		String number = request.getParameter("number");    // ȸ���� �������� �Է��� ������ȣ
														   // Ȩ���������� �߼��� ������ȣ  // db���� �޾ƿ��°ɷ�?
	
		
		return "/good";
		
//		}
	}

}
