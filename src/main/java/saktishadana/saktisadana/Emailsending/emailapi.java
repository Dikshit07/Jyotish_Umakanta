package saktishadana.saktisadana.Emailsending;



import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


/**
 * Hello world!
 *
 */
public class emailapi 
{
   

      public emailapi(String msg, String subject, String to, String from) {
		//host :where to send
		//for gmail host is "smtp.gmail.com"
		String host ="smtp.gmail.com";
		Properties properties = System.getProperties();
//		System.out.println(properties);
		//setting important information to the properties object
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.transport.protocol", "smtp");

		
		//step 1:to get session object
		
		Session session =Session.getInstance(properties, new Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication("javadeveloper9610@gmail.com","skce cxir sziu jmwy");
						
					}
				}
		);
		// for debugging in console
		// session.setDebug(true);
		//step 2: compose the message
		MimeMessage mm = new MimeMessage(session);
		try
		{
			mm.setFrom(new InternetAddress(from));
			mm.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mm.setSubject(subject);
			mm.setText(msg);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//		step 3:
		try {
			Transport.send(mm);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}