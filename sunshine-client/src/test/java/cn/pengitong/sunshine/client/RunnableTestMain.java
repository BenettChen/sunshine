package cn.pengitong.sunshine.client;

import java.util.concurrent.*;

public class RunnableTestMain {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
//        CompletableFuture completableFuture = CompletableFuture.supplyAsync()

        
        /**
         * execute(Runnable x) 没有返回值。可以执行任务，但无法判断任务是否成功完成。
         */
        pool.execute(new RunnableTest("Task1")); 
        
        /**
         * submit(Runnable x) 返回一个future。可以用这个future来判断任务是否成功完成。请看下面：
         */
        Future future = pool.submit(new RunnableTest("Task2"));
        
        try {
            if(future.get()==null){//如果Future's get返回null，任务完成
                System.out.println("任务完成");
            }
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
            //否则我们可以看看任务失败的原因是什么
            System.out.println(e.getCause().getMessage());
        }

    }

}

 class RunnableTest implements Runnable {
    
    private String taskName;
    
    public RunnableTest(final String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Inside "+taskName);
        throw new RuntimeException("RuntimeException from inside " + taskName);
    }

}