package spring.logging;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author o.nakraynikov
 */
@EnableAutoConfiguration
@ComponentScan
public class TestConfiguration {
    @Bean
    public LoggingAnnotationProcessor loggingAnnotationProcessor(){
        return new LoggingAnnotationProcessor();
    }
}
