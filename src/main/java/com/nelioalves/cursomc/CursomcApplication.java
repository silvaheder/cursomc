package com.nelioalves.cursomc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	//mysql://b91c9ae9c9977f:9d2a7098@us-cdbr-east-02.cleardb.com/heroku_51fb91e284838a8?reconnect=true
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
