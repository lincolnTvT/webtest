package com.newrank.webtest;

import java.util.concurrent.*;

/**
 * @program: webtest
 * @description: 测试线程异常捕获
 * @author: ren
 * @create: 2019-07-16 14:42
 **/
public class TestThread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Future future = executorService.submit(new ChildThread());
        try {
            future.get();
        } catch (InterruptedException e) {
            System.out.println(String.format("handle exception in child thread. %s", e));
        } catch (ExecutionException e) {
            System.out.println(String.format("handle exception in child thread. %s", e));
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
        System.out.println("main soft done");
    }
}

class ChildThread implements Callable<String> {
    public String call() throws Exception {
        System.out.println("do something 1");
        Thread.sleep(10000);
        exceptionMethod();
        System.out.println("do something 2");
        return "test result";
    }

    private void exceptionMethod() {
        throw new RuntimeException("ChildThread1 exception");
    }
}
