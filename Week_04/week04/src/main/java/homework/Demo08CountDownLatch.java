package homework;

import java.util.concurrent.CountDownLatch;

public class Demo08CountDownLatch {
    private volatile static int result=0;
    private volatile static  CountDownLatch signal = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread t1 = new Thread(() ->{
            result = FiboCal.sum();
            signal.countDown();
        });
        t1.start();
        signal.countDown();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
