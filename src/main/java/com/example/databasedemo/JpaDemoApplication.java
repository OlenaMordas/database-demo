package com.example.databasedemo;

import com.example.databasedemo.entity.Person;
import com.example.databasedemo.jdbc.PersonJdbcDao;
import com.example.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users {} ", repository.findAll());
		logger.info("User id 10001 => {} ", repository.findById(10001));
		repository.deleteById(10002);
		logger.info("Inserting => {} ",
				repository.update(new Person(10004, "John Doe", "Zurich", new Date())));
		logger.info("Updated => {} ",
				repository.update(new Person(10003, "Anna Fox", "Ostin", new Date())));
		logger.info("All users {} ", repository.findAll());
	}
}
