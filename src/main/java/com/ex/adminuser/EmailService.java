package com.ex.adminuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private MailSender mailsender;
	
	@Autowired
	UserRepository repo;
	private String Otp;

	public void sendSimpleEmail( String toEmail) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		int randomOtp   =(int) (Math.random()*900000)+100000;
        Otp = String.valueOf(randomOtp);
        System.out.println(Otp);
		
        String body = "Your OTP is" +Otp;
		message.setFrom("chikusimba2594@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject("OTP Verification");
		
		mailsender.send(message);
//		UserEntity ums = repo.findByEmail(toEmail);
//		ums.setOtp(Otp);
//		repo.save(ums);
		System.out.println("Mail send..");
	}

	public boolean verifyOtp(int otp2) {
		if(otp2 == Integer.parseInt(Otp)) {
            return true;
		}
		return false;
	}
}
