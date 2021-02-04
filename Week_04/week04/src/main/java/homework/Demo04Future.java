package homework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo04Future {
    private volatile static int result=0;
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start=System.currentTimeMillis();
        Callable callable = new CallableDemo();
        FutureTask task = new FutureTask(callable);

        Thread t1 = new Thread(task);
        t1.start();
        result = (int)task.get();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

   static class CallableDemo implements Callable<Integer>{
       @Override
       public Integer call() throws Exception {
           return Integer.valueOf(FiboCal.sum());
       }
   }
}
