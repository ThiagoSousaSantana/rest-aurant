package br.com.thiagosousa.emailservice.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.thiagosousa.emailservice.models.Mail;

public interface MailRepository extends CrudRepository<Mail, Long>{

}
