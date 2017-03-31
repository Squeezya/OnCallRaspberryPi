package bi.internal.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OncallApplication {

	public static void main(String[] args) {
		SpringApplication.run(OncallApplication.class, args);
	}
}
