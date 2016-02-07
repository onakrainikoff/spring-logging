package spring.logging;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * Обработка аннотации @Logging
 * Автоматическое создание логгеров
 *
 * @author o.nakraynikov
 */
public class LoggingAnnotationProcessor implements BeanPostProcessor {

    /**
     * Обрабатываем бины с аннотацией @Logging
     * @param bean бин
     * @param beanName имя
     * @return бин
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Class clazz = bean.getClass();
        do {
            for (Field field : clazz.getDeclaredFields()) {
                Logging annotation = field.getAnnotation(Logging.class);
                if (annotation!= null) {
                    boolean accessible = field.isAccessible();
                    field.setAccessible(true);
                    try {
                        if(!annotation.value().isEmpty()){
                            field.set(bean, LoggerFactory.getLogger(annotation.value()));
                        } else {
                            field.set(bean, LoggerFactory.getLogger(clazz));
                        }
                    } catch (IllegalAccessException e) {
                        LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
                    }
                    field.setAccessible(accessible);
                }
            }
            clazz = clazz.getSuperclass();
        } while (clazz != null);
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }

}
