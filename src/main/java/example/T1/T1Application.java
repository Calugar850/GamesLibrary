package example.T1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.T1.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main  class that start the application
 */
@SpringBootApplication
public class T1Application implements CommandLineRunner {
	/**
	 * main method
	 * @param args string
	 */
	public static void main(String[] args) {
		SpringApplication.run(T1Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

	}
}
