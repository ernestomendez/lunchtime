package mx.com.dxesoft.lunchtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class LunchtimeApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LunchtimeApplication.class, args);
        new SpringApplicationBuilder()
                .sources(LunchtimeApplication.class)
                .profiles("dev")
                .run(args);
	}
}
