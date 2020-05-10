package indi.xg.learn.thingkinginjava.typeinfo;

/**
 * 泛化的Class引用
 */
public class GenericClassReference {
    public static void main(String[] args) {
        // 没有加泛化，会出现警告，int虽不是引用类型，也是有Class引用的
        Class intClass = int.class;
        // 泛型引用也有自动装箱机制
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        // 因为intClass没有加泛化，所以它可以表示任意类型
        intClass = double.class;

        // genericIntClass使用了泛化，规定了必须使用int或Integer，所以下面的代码编译无法通过
//        genericIntClass = double.class;

        // 为了放松泛化带来的类型限制，可以使用通配符 '?'，通配符表示任何事物
        Class<?> anyClass = int.class;
        // anyClass就可以表示任意类型了，而且不会出现黄色警告
        anyClass = double.class;
        anyClass = String.class;

        // 一般情况下，使用通配符都是更好的选择

    }
}
