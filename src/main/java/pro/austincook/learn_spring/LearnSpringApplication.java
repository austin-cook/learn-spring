package pro.austincook.learn_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringApplication {

	public static void main(String[] args) {
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

		// REST API

	}
}
