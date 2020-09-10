package com.example.study.practice.thread;

import org.springframework.stereotype.Service;

/**
 * @program: esen-wxmp
 * @description:
 * @author: WangJJ
 * @create: 2020-07-01 17:47
 **/
@Service
public class XianChengService {

    public void xianCheng(){

        //继承Thread类
        Thread t1 = new ThreadService();
        t1.start();

        Thread t2 = new ThreadService();
        t2.start();

        //实现Runnable接口
        RunnableService threadRunService = new RunnableService();
        Thread t3 = new Thread(threadRunService,"线程3");
        try {
            t3.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
    }


}
