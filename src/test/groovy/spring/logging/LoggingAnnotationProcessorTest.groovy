package spring.logging

import org.slf4j.Logger
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 *
 * @author o.nakraynikov
 */
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = TestConfiguration.class)
class LoggingAnnotationProcessorTest extends Specification {
    @Logging
    Logger log;
    @Logging("test")
    Logger log2;

    def "Тестируем postProcessBeforeInitialization"() {
        expect:
            log != null;
            log.name == LoggingAnnotationProcessorTest.name
            log2 != null;
            log2.name == 'test'
    }
}
