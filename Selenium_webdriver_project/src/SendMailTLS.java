
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailTLS {
	public static void main(String[] args) throws IOException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("ganesan186",
								"srinivasanganesan");
					}
				});

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ganesan186@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("ganesan.s2@cognizant.com"));
			message.setSubject("Testing Subject");
			
			
						
			
			final String EoL = System.getProperty("line.separator");
			List<String> lines = Files.readAllLines(Paths.get("/home/ganesh/Desktop/1.html"),
			        Charset.defaultCharset());

			StringBuilder sb = new StringBuilder();
			for (String line : lines) {
			    sb.append(line).append(EoL);
			}
			final String content = sb.toString();
			
			Multipart multiPart = new MimeMultipart("alternative");
			
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hello", "utf-8");

			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(content, "text/html; charset=utf-8");

			//multiPart.addBodyPart(textPart); 
			
			multiPart.addBodyPart(htmlPart); 
			message.setContent(multiPart);

			
			//message.setDataHandler(new DataHandler(new String(content.getBytes(), "UTF-8"), "text/html; charset=UTF-8"));
			//message.setContent(content);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}