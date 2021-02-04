package homework;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo06LockCondition {
    private volatile static int result=0;
    private static final Lock lock = new ReentrantLock();
    private static final Condition calDone  = lock.newCondition();
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread t1 = new Thread(() ->{
            lock.lock();
            try {
                result = FiboCal.sum();
                calDone.signal();
            }finally {
                lock.unlock();
            }

        });
        t1.start();
        lock.lock();
        try {
            calDone.await();
            System.out.println("异步计算结果为："+result);
            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        }finally {
            lock.unlock();
        }

    }
}
