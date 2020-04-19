package indi.xg.learn.jvm;

/**
 * 递归调用，模拟线程栈内存溢出
 * 设置参数：-XX:ThreadStackSize=1m
 * 一个线程栈1M内存是足够的，打印结果显示调用了6554次才出现栈内存溢出，
 * 一般系统设置-XX:ThreadStackSize=256k就够了
 *
 * 栈内存溢出是没办法通过gc日志和内存快照分析出来的
 * 栈内存溢出直接打印异常信息，StackOverflowError，
 * 这里直接就告诉你哪个方法调用而导致栈内存溢出的，
 * 所以线上只要做好异常日志的持久化，然后查看异常日志就可以发现问题了
 */
public class ThreadStackOOM {

    static int count = 0;

    public static void main(String[] args) {
        work();
    }

    // 递归调用
    public static void work() {
        System.out.println("第" + ++count + "调用此方法");
        work();
    }
}
