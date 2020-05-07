package indi.xg.learn.thingkinginjava.exceptions;

/**
 * 重新抛出异常，将捕获的异常重新抛出，抛出的是同一个异常
 */
public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("originating the exception in f()");
        throw new Exception("thrown from f()");
    }
    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g(),e.printStackTrace()");
            e.printStackTrace(System.out);
            // 重新抛出异常，这个异常与f()方法中新建的异常是同一个对象
            throw e;
        }
    }
    public static void h() throws Exception{
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside h(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            // g()catch代码内的 throw e 抛出的异常在这里被捕获，打印的信息和g()方法打印的异常信息一样
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (Exception e) {
            // h()catch代码内的 throw (Exception) e.fillInStackTrace() 抛出的异常在这里被捕获
            // e.fillInStackTrace()方法的意思是，重新抛出的异常的栈轨迹信息被重新填充了，虽然还是同一个异常对象，
            // 但打印的信息和之前不一样了
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
