package homework;

import java.util.concurrent.Semaphore;

public class Demo05Semaphore {
    private volatile static int result=0;
    private volatile static Semaphore sem = new Semaphore(1);
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        sem.acquire();
        Thread t1 = new Thread(() ->{
            result = FiboCal.sum();
            sem.release();
        });
        t1.start();
//        Thread.sleep(1);
        try {
            sem.acquire();
            System.out.println("异步计算结果为："+result);
            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        }catch (InterruptedException e){

        }finally {
            sem.release();
        }


    }
}
