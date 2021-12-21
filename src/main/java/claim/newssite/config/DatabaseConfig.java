package claim.newssite.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Configuration
@EnableJpaRepositories(basePackages = "claim.newssite")
@ComponentScan
public class DatabaseConfig {

}
