package indi.xg.learn.thingkinginjava.generics.coffee;

public class Coffee {
    // 每创建一个对象，都会初始化id，counter只会在类加载时初始化一次，
    // 但因为初始化id时，进行了counter++，所以每创建一个对象，counter都会加1，
    // 进而可知，每个对象的id，都比前一个对象的id大1
    // 要牢记static属性是属于类的，同时不要看到final就以为都是不变的，

    // 不加static的final只是保证每个对象的这个属性是不变的
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
