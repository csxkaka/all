package indi.xg.learn.thingkinginjava.generics;

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}

/**
 * 由于数组的特殊机制，需格外注意数组存储对象时的类型识别
 *
 * 数组对象可以保留有关他们包含的对象的类型信息，就好像数组对他们持有的对象是有意识的，
 * 因此在编译期检查和运行时检查之间，不能滥用数组
 */
public class CovariantArrays {
    public static void main(String[] args) {
        // 创建一个Apple数组，并赋值给一个Fruit数组引用，
        // Fruit是父类型的，这是完全每问题的，所以编译期也不会提示错误
        Fruit[] fruit = new Apple[10];

        // 由于数组的机制，一旦数组创建好后，就不能随意更改
        // 既然是Apple数组，那么就只能存Apple对象或Apple的子类对象，这里可以是Jonathan
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        System.out.println(fruit[0]);   // Apple@38af3868
        System.out.println(fruit[1]);   // Jonathan@77459877
        try {
            // 但不可以是别的，也不可以是其父类，Fruit是他的父类
            // 因为Apple数组指向的是Fruit引用，所以编译可以通过，但运行时就会抛出异常
            // java.lang.ArrayStoreException
            fruit[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            // 同样的，因为Orange和Apple是同级的，运行时也会抛出异常
            // 编译能通过也是因为引用是一个Fruit父类型的
            fruit[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
