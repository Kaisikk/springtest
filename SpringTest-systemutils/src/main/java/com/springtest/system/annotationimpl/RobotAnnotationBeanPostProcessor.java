package com.springtest.system.annotationimpl;

import com.springtest.system.annotation.Robot;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class RobotAnnotationBeanPostProcessor implements BeanPostProcessor {

    // мапа хранит имя бина и класс бина
    private Map<String, Class> map = new HashMap<>();

    public RobotAnnotationBeanPostProcessor() {
    }

    /**
     * Метод, который сработает до инициализации бина
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        // пробегаюсь по всем классам, которые будут созданные из бинов
        // беру у них класс
        Class<?> beanClass = bean.getClass();
        // проверка, аннотирован ли мой класс аннотацией @Robot
        if(beanClass.isAnnotationPresent(Robot.class)){
            // если аннотация стоит - кладу мой объект в мапу
            map.put(beanName, beanClass);
            System.out.println("Объект попал в мапу");
        }
        return bean;
    }

    /**
     * Метод, который сработает после инициализации бина
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // пробегаюсь по мапе с объектами
        Class beanClass = map.get(beanName);
        if(beanClass != null){
            // метод newProxyInstance создает объект из нового класса, который он сгенерит налету
            // принимает ClassLoader с помощью которого объект загрузится в heap
            // принимает список интерфейсов, которые объект должен реализовывать
            // принимает объект, который будет инкапсулировать логику, которая попадет во все методы нового класса, который сгенерится налету
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                // тут описывается логика будет в каждом методе класса, который сгенерится налету
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("Тестирование работы прокси класса");
                    long before = System.nanoTime();
                    Object retVal = method.invoke(bean, args);
                    long after = System.nanoTime();
                    System.out.println(after - before);
                    System.out.println("Прокси класс работает успешно");
                    return retVal;
                }
            });
        }

        return bean;
    }
}
