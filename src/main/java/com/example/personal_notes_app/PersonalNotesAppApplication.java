package com.example.personal_notes_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PersonalNotesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalNotesAppApplication.class, args);
	}

	@Bean
	public PlatformTransactionManager platformTransactionManager(MongoDatabaseFactory databaseFactory){
		return new MongoTransactionManager(databaseFactory);
	}
}
