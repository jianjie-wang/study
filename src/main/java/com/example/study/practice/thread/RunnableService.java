package com.example.study.practice.thread;

import org.springframework.stereotype.Service;

/**
 * @program: esen-wxmp
 * @description:
 * @author: WangJJ
 * @create: 2020-07-01 16:06
 **/
@Service
public class RunnableService implements Runnable{

    public void run() {
        for (int i = 0 ; i<=20; i++){
            System.out.println("Runnable线程："+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        RunnableService runnableService= new RunnableService();
        new Thread(runnableService,"滴滴").start();
        new Thread(runnableService,"哒哒").start();
    }
}
