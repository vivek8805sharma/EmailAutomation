package com.EmailAutomation.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private String emailId;
	private String subject;
	private String message;

}
