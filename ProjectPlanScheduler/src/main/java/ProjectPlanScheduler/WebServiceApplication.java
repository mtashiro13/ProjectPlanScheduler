package ProjectPlanScheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ProjectPlanScheduler.Service", "ProjectPlanScheduler.controller", "ProjectPlanScheduler.domain.mapper"})
@EntityScan("ProjectPlanScheduler.domain")
@EnableJpaRepositories("ProjectPlanScheduler.repository")
public class WebServiceApplication extends SpringBootServletInitializer{

	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebServiceApplication.class);
    }
    public static void main(String[] args) {
    	SpringApplication.run(WebServiceApplication.class, args);
    }
}
