package indi.xg.learn.thingkinginjava.generics;

/**
 * 使用类型参数，结合通配符，自定义自己的方法，
 * @param <T>
 */
public class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }
    public T get() {
        return value;
    }
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);

        // 无法将要给泛型强转为父泛型，但可以转成Holder<? extends Fruit>
//        Holder<Fruit> fruit = apple;
        Holder<? extends Fruit> f = apple;
        Fruit p = f.get();
        // f.get()返回的是一个Fruit，其子类也可以，编译器知道要接收的是Fruit对象或它的子类对象
        d = (Apple) f.get();
        try {
            // 但是Orange和Fruit是平级的，不是Fruit的子类，虽然编译会通过，
            // 编译能通过是因为可以将Fruit类型强转为其子类型Orange，
            // 但运行就会抛异常，f.get得到的对象实际是Apple
            // 无法将Apple类型强转为Orange类型
            Orange c = (Orange) f.get();
        } catch (Exception e) {
            System.out.println(e);
        }

        // set方法接收的是一个类型参数，因为f的引用是一个Holder<? extends Fruit>
        // 所以此时的set方法接收的参数也变成了set(? extends Fruit)
        // 这就有问题了，编译器不知道set具体要接收什么类型，于是编译无法通过
//        f.set(new Apple());
//        f.set(new Fruit());

        // equals接收的是一个固定的Object，可以正常调用
        System.out.println(f.equals(d));
    }
}
