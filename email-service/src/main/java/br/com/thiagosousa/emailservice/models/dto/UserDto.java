package br.com.thiagosousa.emailservice.models.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String username;
    private String password;
}
