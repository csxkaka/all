package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 不通过外部类的方法创建内部类，
 * 而是使用.new直接在外部类中创建内部类对象
 *
 *
 * 对于非静态内部类（嵌套类），对象的创建一定是通过外部类的对象来创建的，一定是现有外部类再有内部类
 * 因为内部类需要一个秘密的引用来指向外部类的对象，从而可以直接访问外部类成员
 * @author chenshixue
 * @date 2020/5/2
 */
public class DotNew {

    public class Inner {

    }

    public void f() {
        DotNew dn = new DotNew();
//        Inner inner = dn.new Inner();
        DotNew.Inner inner = dn.new Inner();
    }

    public static void main(String[] args) {

        // 不管是在外部类的普通方法还是静态方法中
        // 都可以通过外部类对象的引用调用new来创建内部类的对象
        DotNew dn = new DotNew();
        // 这里必须是通过外部类的对象来创建的
//        Inner inner = dn.new Inner();
        DotNew.Inner inner = dn.new Inner();

    }
}
