package example.T1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
