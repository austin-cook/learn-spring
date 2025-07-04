package pro.austincook.learn_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {
    private final MyFirstClass myFirstClass;
    private Environment environment;

    // inject a property
    @Value("${my.custom.property.2}")
    private String customProperty2;
    @Value("${my.custom.property.int}")
    private Integer customPropertyInt;

    public MyFirstService(@Qualifier("mySecondBean") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        return "the dependency is saying: " + myFirstClass.sayHello();
    }

    public String getJavaVersion() {
        return this.environment.getProperty("java.version");
    }

    public String getOsName() {
        return this.environment.getProperty("os.name");
    }

    public String getOsVersion() {
        return this.environment.getProperty("os.version");
    }

    // reads the property from application.properties file
    public String readProperty() {
        return "my.custom.property: " + environment.getProperty("my.custom.property");
    }

    public String readProperties() {
        return readProperty() + ", my.custom.property2: " + customProperty2;
    }

    public Integer getCustomPropertyInt() {
        return customPropertyInt;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
