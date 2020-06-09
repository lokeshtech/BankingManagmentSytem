package com.example.bams.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.bams.model.User;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void approvalSendEmail(User user,int id) throws MessagingException, IOException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		String htmlMsg = "Greenting from BAMS..........!<br/>" + "<h3>Dear"+user.getName() + user.getLastName() + "</h3>"
				+ "<br/><p>Congratulation Your Account got Approved</p> "
				+ "<p>Please find your Customer below : <br/> "+ id +"</p> </br>"
				+ "any issue contact for customarcare 180098569997 or write us care@bams.com </br>"
				+ "Thanks for choosing BAMS System";
		helper.setText(htmlMsg, true);
		helper.setTo(user.getEmail());
		helper.setSubject("BAMS Approval");
		javaMailSender.send(mimeMessage);

	}
	
	public void rejectSendEmail(User user) throws MessagingException, IOException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		String htmlMsg = "Greenting from BAMS..........!<br/>" + "<h3>Dear"+user.getName() + user.getLastName() + "</h3>"
				+ "<br/><p>Sorry for inconvenience caused</p> "
				+ "<p>regreate to informed to Your application is rejected with BAMS it's not meet with our internal criteria</p> </br>"
				+ "any issue contact for customarcare 180098569997 or write us care@bams.com </br>"
				+ "Thanks for choosing BAMS System";
		helper.setText(htmlMsg, true);
		helper.setTo(user.getEmail());
		helper.setSubject("BAMS Approval Rejected");
		javaMailSender.send(mimeMessage);

	}
}