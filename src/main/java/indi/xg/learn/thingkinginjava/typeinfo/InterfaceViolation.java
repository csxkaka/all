package indi.xg.learn.thingkinginjava.typeinfo;

public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        // 编译无法通过，虽然实际对象是B，但因向上转型了，只能执行实现了接口的方法，这其实是更安全的
//        a.g();
        // 将a向下转型后方能使用g()方法，这其实是一个不安全的行为，程序员可以利用这个，做很多接口提供方些不希望看到的
        // 如果你确实希望a不能访问A内方法之外的方法，那么可以将g()方法设为包访问权限，将A接口放在不同的包中
    }
}
interface A {
    void f();
}
class B implements A {
    @Override
    public void f() {

    }
    public void g() {}
}
