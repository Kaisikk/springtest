package com.springtest.system.annotationimpl;

import com.springtest.system.annotation.InjectInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Реализация аннотации @Robot
 * BeanPostProcessor позволяет настраивать бины до попадания в контейнер, для реализации аннотации надо унаследоваться от него
 */
public class InjectIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    /**
     * Вызывается перед созданием бина
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        // вытаскиваю все field из объекта, который будет создаваться с помощью бина
       Field[] fields = bean.getClass().getDeclaredFields();
       for(Field field : fields){
           // вытаскиваю все аннотации InjectInt из объекта
          InjectInt injectInt = field.getAnnotation(InjectInt.class);
          // если injectInt не null, значит аннотация стояла
           if(injectInt != null){
               // получение значений указанных над аннотацией
               int min =  injectInt.min();
               int max = injectInt.max();
               Random random = new Random();
               int i = min + random.nextInt(max - min);
               // указывается, если нужно менять поля т.к они в классе Field private
               field.setAccessible(true);
               // получение reflection (чотобы ошибки не прокидывать)
               // указывается для какого поля дается значение, в какой объект положить поле, само значение
               ReflectionUtils.setField(field, bean, i);
           }
       }
        return bean;
    }

    /**
     * Вызывается после уничтожения бина
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
