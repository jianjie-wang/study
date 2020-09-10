package com.example.study.practice.thread;

import java.util.concurrent.*;

/**
 * @program: study
 * @description:
 * @author: WangJJ
 * @create: 2020-08-18 10:23
 **/
public class CallableService implements Callable<String> {

    private int tickets = 10;

    @Override
    public String call() throws Exception {
            for(int x = 0 ; x < tickets ; x ++){
                if(tickets > 0 ){
                    System.out.println("卖票,tickets = " + this.tickets --) ;
                }
            }
        return "票已卖光" ;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> result = threadPool.submit(new CallableService());
        System.out.println("Future返回的结果："+result);
        threadPool.shutdown();

        CallableService m1 = new CallableService ();
        FutureTask<String> f1 = new FutureTask<String>(m1) ;//目的是为了取得call()方法的返回值
        //FutureTask类是Runnable接口的子类，所以可以使用Thread类的构造来接收FutureTask的实例化对象
        new Thread(f1).start() ;
        //多线程执行完毕后可以取得返回值，依靠FutureTask的父接口Future中的get()方法完成
        System.out.println("线程1的返回结果：" + f1.get()) ;


        ExecutorService pool = Executors.newFixedThreadPool(5);
        // 构建完成服务
        CompletionService<String> completionService = new ExecutorCompletionService<>(pool);
        completionService.submit(new CallableService());

        String result1 = completionService.take().get();
        System.out.println("返回的结果："+result1);
        pool.shutdown();
    }
}
