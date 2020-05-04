package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 内部类中this的使用
 * @author chenshixue
 * @date 2020/5/2
 */
public class DotThis {

    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        int i = 0;
        public DotThis outer() {
            // 如果是单独的this，指的是内部类Inner对象的引用
            this.i = 5;
            System.out.println(this.i);

            // 在内部类生成外部类对象的引用
            return DotThis.this;

        }
    }
    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();

        // 通过调用外部类的方法生成内部类对象
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
