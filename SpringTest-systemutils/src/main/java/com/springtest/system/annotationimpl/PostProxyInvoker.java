package com.springtest.system.annotationimpl;

import com.springtest.system.annotation.PostProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

/**
 * Класс для запуска методов над которыми стоит аннотация PostProxy после полной настройки бина
 * В дженерике указывается на какой ивент из листенера смотреть
 */
public class PostProxyInvoker implements ApplicationListener<ContextRefreshedEvent> {

    // фабрика спринга чтобы вытащить объявления бинов
    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        // получение контекста
        ApplicationContext context = event.getApplicationContext();
        // достаю имена всех бинов
        String[] names = context.getBeanDefinitionNames();
        for(String name : names){
            // достаю объявление бина из фабрики
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            // достаю оригинальное название класса из бина
            String originalClassName = beanDefinition.getBeanClassName();
            try {
                // достаю класс у бина из фабрики
               Class<?> originalClass = Class.forName(originalClassName);
               // достаю все методы из класса
                Method[] methods = originalClass.getMethods();
                // иду по этим методам
                for (Method method : methods){
                    // если над методом висит аннотация, которую я создал
                if(method.isAnnotationPresent(PostProxy.class)){
                    // достаю оригинальный объект из класса, который был создан в контексте
                    // достаю bean по имени бина
                    Object bean = context.getBean(name);
                    // беру bean и достаю из него текущий класс(делаю так, потому что может быть создан объект прокси класса)
                    // потом достаю из него нужный мне метод
                    Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                    // запускаю этот метод
                    currentMethod.invoke(bean);
                }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
