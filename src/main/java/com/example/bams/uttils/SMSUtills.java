package com.example.bams.uttils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import com.twilio.Twilio;

@Service
public class SMSUtills {

	@Value("${ACCOUNT_SID}")
	private String ACCOUNT_SID;

	@Value("${AUTH_TOKEN}")
	private String AUTH_TOKEN;

	@Value("${FROM_PHONENUMBER}")
	private String FROM_PHONENUMBER;

	public String SendSMS(String msg, String to) {

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new PhoneNumber(to), // to
				new PhoneNumber(FROM_PHONENUMBER), // from
				msg).create();

		return message.getSid();
	}
}
