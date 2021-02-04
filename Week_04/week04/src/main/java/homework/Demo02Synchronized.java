package homework;

public class Demo02Synchronized {
    private volatile static int result=0;
    private static Object monitor = new Object();
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread t1 = new Thread(() ->{
            synchronized (monitor){
                result = FiboCal.sum();
            }
        });
        t1.start();
        Thread.sleep(1);
        synchronized (monitor) {
            System.out.println("异步计算结果为："+result);
        }
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
