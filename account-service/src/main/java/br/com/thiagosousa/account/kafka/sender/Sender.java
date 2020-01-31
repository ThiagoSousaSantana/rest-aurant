package br.com.thiagosousa.account.kafka.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import br.com.thiagosousa.account.models.User;

public class Sender {
	 
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
 
    public void send(String topic, User payload) {
        kafkaTemplate.send(topic, payload);
    }
}
