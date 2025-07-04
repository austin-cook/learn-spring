package pro.austincook.learn_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {
    @Bean
	public MyFirstClass mySecondBean() {
		return new MyFirstClass("Second bean");
	}

	@Bean
	@Primary
	@Profile("dev")
	public MyFirstClass myDevBean() {
		return new MyFirstClass("Dev bean");
	}

	@Bean
	@Primary
	@Profile("test")
	public MyFirstClass myTestBean() {
		return new MyFirstClass("Test bean");
	}
}
