package br.com.thiagosousa.account.kafka.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import br.com.thiagosousa.account.models.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Sender {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void send(String topic, User payload) {
        log.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }
}
