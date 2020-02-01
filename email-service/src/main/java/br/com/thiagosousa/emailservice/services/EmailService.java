package br.com.thiagosousa.emailservice.services;

import br.com.thiagosousa.emailservice.models.dto.UserDto;

public interface EmailService {

	void sendSimpleMessage(UserDto input);

}
