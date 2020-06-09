package com.example.bams.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bams.model.User;
import com.example.bams.uttils.SMSUtills;

@Service
public class SMSService {

	@Autowired
	SMSUtills smsUtills;

	public void sendApproveSMS(User user, int id) {

		String msg = "\"Greenting from BAMS..........!" + "Dear" + user.getName() + user.getLastName() + "\r\n"
				+ "Congratulation Your Account got Approved \"\r\n" + "<p>Please find your Customer below :" + id
				+ "\r\n" + "any issue contact for customarcare 180098569997 or write us care@bams.com \r\n"
				+ "Thanks for choosing BAMS System";

		smsUtills.SendSMS(msg, user.getPhonenumber());
	}

	public void sendRejectSMS(User user, int id) {

		String msg = "Greenting from BAMS..........!" + "Dear" + user.getName() + user.getLastName() + ""
				+ "Sorry for inconvenience caused"
				+ "regreate to informed to Your application is rejected with BAMS it's not meet with our internal criteria"
				+ "any issue contact for customarcare 180098569997 or write us care@bams.com"
				+ "Thanks for choosing BAMS System";

		smsUtills.SendSMS(msg, user.getPhonenumber());
	}
}
