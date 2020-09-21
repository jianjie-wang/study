package com.example.study.practice.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-09-21 17:26
 *  BeanPostProcessor接口提供了初始化bean时的前置接口和后置接口，
 * 只需要实现BeanPostProcessor中对应的接口就可以bean初始化前后做自己的逻辑处理。
 * （BeanPostProcessor的前置和后置方法会在每个bean初始化的时候调用，不推荐使用）
 **/
@Component
public class BeanPost implements BeanPostProcessor {

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("BeanPostProcessor Before init:{} " + beanName);
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("BeanPostProcessor after init: {}" + beanName);
//        return bean;
//    }

}
