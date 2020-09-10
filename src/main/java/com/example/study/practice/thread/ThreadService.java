package com.example.study.practice.thread;

import org.springframework.stereotype.Service;

/**
 * @program: esen-wxmp
 * @description:
 * @author: WangJJ
 * @create: 2020-07-01 15:40
 **/
@Service
public class ThreadService extends Thread{

    @Override
    public void run(){
        for (int i = 0; i <=20; i++){
            System.out.println("线程："+Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {
        Thread t1 = new ThreadService();
        Thread t2 = new ThreadService();
        Thread t3 = new ThreadService();

        t1.start();
        t2.start();
        t3.start();
    }
}
