package br.com.thiagosousa.emailservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.thiagosousa.emailservice.models.Mail;

@Repository
public interface MailRepository extends CrudRepository<Mail, Long>{
	
}
