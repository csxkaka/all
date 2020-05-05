package indi.xg.learn.thingkinginjava.exceptions;

/**
 * 自定义异常，多个构造器，重写getMessage()
 * @author chenshixue
 * @date 2020/5/5
 */
public class ExtraFeatures {
    public static void f() throws MyException2 {
        System.out.println("Throwing MyException2 From f()");
        throw new MyException2();
    }
    public static void g() throws MyException2 {
        System.out.println("Throwing MyException2 From g()");
        throw new MyException2("Originated in g()");
    }
    public static void h() throws MyException2 {
        System.out.println("Throwing MyException2 From h()");
        throw new MyException2("Originated in h()", 47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (MyException2 e) {
            // 异常对象里有一个detailMessage属性，在打印异常信息时，会调用getMessage()方法
            e.printStackTrace(System.out);
        }
    }
}

class MyException2 extends Exception {
    private int x;
    public MyException2() {

    }
    public MyException2(String msg) {
        super(msg);
    }
    public MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }

    public int val() {
        return x;
    }

    @Override
    public String getMessage() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
}
