package com.springtest.system.annotationimpl;

import com.springtest.system.annotation.DeprecatedClass;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Класс для обработки аннотации DeprecatedClass
 * Класс нужен чтобы все бины из классов, которые помечены моей аннотаций заменялись на новую реализацию
 *
 */
public class DeprecationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * Метод отработает в тот момент когда появятся объявления бинов
     * Сами бины еще не появились и не настроились
     * Метод postProcessBeanFactory всегда запускается на этапе когда другие бины еще не созданные и есть только BeanDefinitions и BeanFactory
     *
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // получаю имена всех бинов
        String[] names = configurableListableBeanFactory.getBeanDefinitionNames();
        // бегу по именам бинов
        for(String name : names){
            // получаю объявление бина по его имени
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
            // получаю название класса, который должен создаться из бина
            String beanClassName = beanDefinition.getBeanClassName();
            try{
                // получаю класс бина
                Class<?> beanClass = Class.forName(beanClassName);
                // проверяю, стоит ли аннотация над моим классом
                DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
                if(annotation != null){
                    // если аннотация есть, устанавливаю новое название класса
                    // достаю из аннотации новый класс, беру его название и устанавливаю новый класс в бин
                    beanDefinition.setBeanClassName(annotation.newImpl().getName());
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
