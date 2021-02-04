package homework;

public class Demo03ShareValue {
    private volatile static int result=0;
    private volatile static boolean done = false;
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Thread t1 = new Thread(() ->{
            result = FiboCal.sum();
            done = true;
        });
        t1.start();
        while(!done);
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
