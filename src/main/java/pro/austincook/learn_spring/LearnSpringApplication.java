package pro.austincook.learn_spring;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pro.austincook.learn_spring.elearningplatform.dataaccess.AuthorRepository;
import pro.austincook.learn_spring.elearningplatform.dataaccess.VideoRepository;
import pro.austincook.learn_spring.elearningplatform.model.entity.AuthorEntity;
import pro.austincook.learn_spring.elearningplatform.model.entity.VideoResourceEntity;

import java.util.Arrays;

@SpringBootApplication
public class LearnSpringApplication {

	public static void main(String[] args) {
		// Here in main, I am manually fetching beans
		// See the CommandLineRunner below for another/better way of doing it

		// Starts up spring
		var ctx = SpringApplication.run(LearnSpringApplication.class, args);

		// DON'T do this - Use dependency injection instead
//		MyFirstClass myFirstClass = new MyFirstClass();
//		System.out.println(myFirstClass.sayHello());

		// Instead - do this:
		MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
		System.out.println(myFirstClass.sayHello());

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		System.out.println("Java Version: " + myFirstService.getJavaVersion());
		System.out.println("OS Name: " + myFirstService.getOsName());
		System.out.println("OS Version: " + myFirstService.getOsVersion());
		System.out.println(myFirstService.readProperty()); // read properties from application.properties file
		System.out.println(myFirstService.readProperties());
		System.out.println(myFirstService.getCustomPropertyInt());
	}

	// E-Learning Platform REST API
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository,
			VideoRepository videoRepository
	) {
		return args -> {
			// save an author
//			AuthorEntity author = AuthorEntity.builder()
//					.firstName("Austin")
//					.lastName("Cook")
//					.age(24)
//					.email("name@email.com")
//					.build();
//			authorRepository.save(author);

			// save a video resource
//			VideoResourceEntity videoResourceEntity = VideoResourceEntity.builder()
//					.name("video1")
//					.length(5)
//					.build();
//			videoRepository.save(videoResourceEntity);

			// save 50 authors with fake data
//			for (int i = 0; i < 50; i++) {
//				Faker faker = new Faker();
//				AuthorEntity author = AuthorEntity.builder()
//					.firstName(faker.name().firstName())
//					.lastName(faker.name().lastName())
//					.age(faker.number().numberBetween(19,50))
//					.email("name" + i + "@email.com")
//					.build();
//				authorRepository.save(author);
//			}

			// update Author with id=1 to have new info
//			AuthorEntity author = AuthorEntity.builder()
//					.id(1)
//					.firstName("Austin")
//					.lastName("Cook")
//					.age(24)
//					.email("austin.cook.id@gmail.com")
//					.build();
//			authorRepository.save(author);

			// use custom query in AuthorRepository
//			authorRepository.updateAuthorAge(1, 26);

			// use custom query in AuthorRepository
//			authorRepository.updateAllAuthorAge(100);

			// use named query for AuthorEntity
			authorRepository.findByAgeNamedQuery(100)
					.forEach(System.out::println);

//			System.out.println(authorRepository.findAllByFirstName("Damaris"));
//			System.out.println(authorRepository.findAllByFirstNameInIgnoreCase(Arrays.asList("damaris", "phil", "none")));
		};
	}
}
