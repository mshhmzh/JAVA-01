package homework;

public class Demo01Join {
    private volatile static int result=0;
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread t1 = new Thread(() ->{
            result = FiboCal.sum();
        });
        t1.start();
        t1.join();
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
