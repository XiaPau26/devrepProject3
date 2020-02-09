package model.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SendMail {

	private static JavaMailSenderImpl mailSender;

	@Autowired
	public SendMail() {
		mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("ziyu.ye97@gmail.com");
		mailSender.setPassword("");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
	}

	public static void sendEmailConfirmationInscription(String to, String url)
			throws AddressException, MessagingException, IOException {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("Confirmation de l'inscription");
		message.setText("Votre inscription est validé.\n Veuillez payer en cliquant sur le lien suivant : " + url);
		mailSender.send(message);
	}

	public static void sendEmailRefusInscription(String to) throws AddressException, MessagingException, IOException {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("Refus de l'inscription");
		message.setText(
				"Votre justification n'est pas correct ou justificatif vide. Veuillez remplir un nouveau formulaire avec un nouveau justificatif");
		mailSender.send(message);
	}

	public static void sendEmailToAdmin() throws AddressException, MessagingException, IOException {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("p.xia1997@gmail.com");
		message.setSubject("Validation des inscriptions");
		message.setText(
				"Veuillez se diriger vers l'interface admin pour valider les formulaires. \n http://localhost:8080/admin");
		mailSender.send(message);
	}

	public static void sendEmailConfirmationPaiement(String to)
			throws AddressException, MessagingException, IOException {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("Confirmation de paiement");
		message.setText("Votre paiement est bien effectué.\n Une facture vous sera envoyée ultérieurement.");
		mailSender.send(message);
	}
}
