package indi.xg.learn.thingkinginjava.exceptions;

/**
 * 自定义异常
 * 新建一个类继承异常类就可以了，最好是继承意思接近的异常类
 * @author chenshixue
 * @date 2020/5/5
 */
public class InheritingException {

    public void f() throws SimpleException {
        System.err.println("Throw SimpleException From f()");
        // 这里手动创建一个异常，并且从这里抛出去，抛到一个更大的环境，也就是f()方法，
        // 因为没有捕获这个异常，所以f()就一定要继续抛出去，
        // 如果f()方法后没有throws SimpleException，那么编译是通不过的
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingException sed = new InheritingException();
        // 这里编译是通不过的，因为f()方法直接手动抛出了一个异常，没有处理
        // 这个异常就会继续往上抛，抛给了main方法，但main()没有继续往上抛，也没有处理此异常，所以编译不能通过
        // main方法后加上throws SimpleException就不会出现编译问题
        // 手动抛出的异常会一层一层往上抛，直到抛给main()线程，main线程再抛给虚拟机，如果出现异常，而虚拟机又无法处理
        // 就会导致程序中止
//        sed.f();
        try {
            // 因为在catch里捕获了异常，所以编译可以通过
            sed.f();
        } catch (SimpleException e) {
            // 对异常信息的打印可以用System.err流，这样异常更容易被发现
            System.err.println("Caught it!");

            // 不加参数，就是默认将错误信息发送给System.err流
            e.printStackTrace();

//            e.printStackTrace(System.out);
        }
    }
}

// 定义一个类，继承一个异常类，这个类也就是一个异常类了，可以添加不同的构造方法
class SimpleException extends Exception {

    public SimpleException() {

    }

    public SimpleException(String msg) {
        // 使用super关键字调用基类构造器
        super(msg);
    }
}