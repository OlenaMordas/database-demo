package com.example.databasedemo;

import com.example.databasedemo.entity.Person;
import com.example.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication //uncomment when using it
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users {} ", personJdbcDao.findAll());
		logger.info("User id 10001 => {} ", personJdbcDao.findById(10001));
		logger.info("Deleted => {} ", personJdbcDao.deleteById(10002));
		logger.info("Inserting => {} ",
				personJdbcDao.insertPerson(new Person(10004, "John Doe", "Zurich", new Date())));
		logger.info("Updated => {} ",
				personJdbcDao.updatePerson(new Person(10003, "Anna Fox", "Ostin", new Date())));
	}
}
