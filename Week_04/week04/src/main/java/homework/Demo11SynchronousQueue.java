package homework;

import java.util.concurrent.SynchronousQueue;

public class Demo11SynchronousQueue {
    private volatile static int result=0;
    private volatile static  SynchronousQueue queue = new SynchronousQueue();
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread t1 = new Thread(() ->{
            int value = FiboCal.sum();
            try {
                queue.put(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        result = (int)queue.take();

        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
