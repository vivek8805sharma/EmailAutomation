package com.EmailAutomation.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmailAutomation.Service.ExcelService;
import com.EmailAutomation.Service.MailService;

@RestController
@RequestMapping("/api")
public class MailController {
	
	@Autowired
	MailService mailService;
	
	@Autowired
	ExcelService excelService;
	
	@PostMapping("/sendmail")
	public void sendMail() {
		try {
			mailService.sendToAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
