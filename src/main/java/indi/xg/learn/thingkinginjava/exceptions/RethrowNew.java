package indi.xg.learn.thingkinginjava.exceptions;

/**
 * 重新抛出异常，捕获到一个异常后，抛出一个新的异常，而不是捕获的这个异常
 * 相当于调用了fillInStackTrace()，之前的异常对象无用了，异常抛出的栈轨迹是新异常的栈轨迹
 */
public class RethrowNew {
    public static void f() throws OneException {
        System.out.println("Originating the exception in f()");
        // 这里新建一个异常，被f()方法抛出，跑到main方法，
        // 在main方法的try..catch内被捕获，所以异常的抛出轨迹就是f()->main()
        // 从打印的异常信息里，就可以看到异常最开始是从那个栈帧(方法)被抛出的
        throw new OneException("thrown from f()");
    }

    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneException e) {
                System.out.println("Caught in inner try, e.printStackTrace()");
                e.printStackTrace(System.out);
                // 这里抛出的是一个新的异常，它的起始位置就是main()，它并不知道f()方法
                // 所以它的栈轨迹就只是main()
                throw new TwoException("from inner try");
            }
        } catch (TwoException e) {
            System.out.println("Caught in outer try, e.printStackTrace()");
            // 这里打印的栈轨迹是main()
            e.printStackTrace(System.out);
        }
    }

}

class OneException extends Exception {
    public OneException(String s) {
        super(s);
    }
}

class TwoException extends Exception {
    public TwoException(String s) {
        super(s);
    }
}
