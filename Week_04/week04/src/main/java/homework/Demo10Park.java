package homework;

import java.util.concurrent.locks.LockSupport;

public class Demo10Park {
    private volatile static int result=0;
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread mainThred = Thread.currentThread();
        Thread t1 = new Thread(() ->{
            result = FiboCal.sum();
            LockSupport.unpark(mainThred);
        });
        t1.start();
        LockSupport.park();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
