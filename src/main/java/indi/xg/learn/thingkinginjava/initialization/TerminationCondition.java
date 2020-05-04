package indi.xg.learn.thingkinginjava.initialization;

/**
 * finalize()的用法:
 * 大多数情况下，都是不需要手动执行垃圾回收的
 * 这里介绍了一种finalize()方法用到的场景。
 * finalize()不是我们自己new的某个实例对象来调用的，而是通过执行System.gc()去请求垃圾回收器来调用，
 * 垃圾回收器来执行finalize()方法，我们可以在finalize()里写一些代码逻辑，这些逻辑都是在垃圾会收前执行的。
 */
public class TerminationCondition {

    /**
     * 这段代码的意思就是，每次来回收书时签入了
     * @param args
     */
    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();

        new Book(true);

        /*
         * 执行了System.gc()就是，垃圾收集器才有可能来调用finalize()方法，执行垃圾回收
         */
        System.gc();
    }
}

/**
 * 每一本书被创建后都是签出状态，好比借出去一本书
 */
class Book {
    boolean checkedOut = false;

    public Book(boolean checkout) {
        this.checkedOut = checkout;
    }

    void checkIn() {
        checkedOut = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (checkedOut) {
            System.out.println("操作失败，本书未签入！");
        }

        // 一般都是调用父类的finalize()方法
//        super.finalize();
    }
}
