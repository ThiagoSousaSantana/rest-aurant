package br.com.thiagosousa.account.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.thiagosousa.account.kafka.sender.Sender;
import br.com.thiagosousa.account.models.User;
import br.com.thiagosousa.account.repositories.UserRepository;

@Component
public class UserServiceImpl implements UserService{
	
	@Value("${spring.kafka.topic.userCreated}")
	private String USER_CREATED_TOPIC;
	 
	private UserRepository userRepository;
	private Sender sender;
	 
	public UserServiceImpl(UserRepository userRepository, Sender sender) {
		super();
		this.userRepository = userRepository;
		this.sender = sender;
	}

	@Override
	public User registerUser(User input) {
	    User createdUser = userRepository.save(input);
	    sender.send(USER_CREATED_TOPIC, createdUser);
	    return createdUser;
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

}
