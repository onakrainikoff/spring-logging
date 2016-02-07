package spring.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация получения логгера из контейнера
 *
 * @author o.nakraynikov
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {

    /**
     * Логгер
     * @return имя логера, если не указано то по имени класса
     */
    String value() default "";
}
