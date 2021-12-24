package com.EmailAutomation.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.EmailAutomation.Entity.User;

@Component
public class MailService {
	
	@Autowired
	ExcelService excelService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendMail(User user) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailId());
		mail.setSubject(user.getSubject());
		mail.setText(user.getMessage());
		System.out.println("Sending mail to "+user.getEmailId());
		javaMailSender.send(mail);
		System.out.println("---------------Sending mail----------------");
		System.out.println("Mail successfully sent to "+user.getEmailId()+"\n\n");
		
	}
	
	public void sendToAll() throws IOException {
		List<User> allUsers=excelService.readExcel();
		for(User user : allUsers) {
			this.sendMail(user);
		}
			
	}

}
