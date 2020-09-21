package com.example.study.practice.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-09-21 16:45
 * ===============执行顺序================
 * ① BeanPostProcessor的postProcessBeforeInitialization方法(不推荐使用)
 * ② 类中添加了注解@PostConstruct 的方法
 * ③ InitializingBean的afterPropertiesSet方法
 * ④ bean的指定的初始化方法： init-method                          构造函数-->依赖注入-->init-method，只有一个类完整的实例被创建出来后，才能走初始化方法。
 * ⑤ BeanPostProcessor的postProcessAftrInitialization方法(不推荐使用)
 **/
@Component
public class Annotation  {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //② 
    @PostConstruct
    public void init() {
        log.info("=================================:{}"," @PostConstruct");
        new Thread(this::worker1).start();
        new Thread(this::worker2).start();
    }

    private void worker1(){
        log.info("---------------------------------:{}"," worker1");
    }

    private void worker2(){
        log.info("---------------------------------:{}"," worker2");
    }

}
