package br.com.thiagosousa.account.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.thiagosousa.account.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
}
