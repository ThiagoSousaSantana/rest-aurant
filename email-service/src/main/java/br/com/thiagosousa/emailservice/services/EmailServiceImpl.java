package br.com.thiagosousa.emailservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import br.com.thiagosousa.emailservice.models.Mail;
import br.com.thiagosousa.emailservice.models.dto.UserDto;
import br.com.thiagosousa.emailservice.repositories.MailRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EmailServiceImpl implements EmailService {
  
	@Autowired
    public JavaMailSender emailSender;

    @Autowired
    public MailRepository mailRepository;

    @Override
    public void sendSimpleMessage(UserDto input) {
        try {

            Mail newMail = new Mail();
            newMail.setTo(input.getUsername());
            newMail.setSubject("User confirmation");
            newMail.setText(input.toString());

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(newMail.getTo());
            message.setSubject(newMail.getSubject());
            message.setText(newMail.getText());

            mailRepository.save(newMail);
            log.info("Sending e-mail to {}", input.getUsername());
            emailSender.send(message);
            log.info("Sent e-mail to {}", input.getUsername());
        } catch (MailException exception) {
            log.error(exception.getLocalizedMessage());
        }

    }
}