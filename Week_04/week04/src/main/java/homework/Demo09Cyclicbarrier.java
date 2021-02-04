package homework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Demo09Cyclicbarrier {
    private volatile static int result=0;
    private volatile static CyclicBarrier barrier = new CyclicBarrier(2);
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        long start=System.currentTimeMillis();
        Thread t1 = new Thread(() ->{
            result = FiboCal.sum();
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        barrier.await();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
