package br.com.thiagosousa.account.services;

import br.com.thiagosousa.account.models.User;

public interface UserService {
	User registerUser(User input);
	Iterable<User> findAll();
}
