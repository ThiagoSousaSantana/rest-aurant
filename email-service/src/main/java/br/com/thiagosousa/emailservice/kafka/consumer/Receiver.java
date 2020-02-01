package br.com.thiagosousa.emailservice.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import br.com.thiagosousa.emailservice.models.dto.UserDto;
import br.com.thiagosousa.emailservice.services.EmailService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Receiver {
	
    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "${spring.kafka.topic.userCreated}")
    public void receive(UserDto payload) {
        log.info("received payload='{}'", payload);
        emailService.sendSimpleMessage(payload);
        latch.countDown();
    }
}
