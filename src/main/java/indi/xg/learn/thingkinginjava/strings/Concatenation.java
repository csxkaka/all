package indi.xg.learn.thingkinginjava.strings;

/**
 * 字符串拼接的底层实现
 */
public class Concatenation {

    /**
     * 通过javap -c Concatenation反编译这个.class文件：
     * 发现编译器自动创建了一个StringBuilder对象，然后通过这个对象的append()方法拼接字符串，
     * 因为编译器知道使用StringBuilder来拼接字符串会更快。
     * 但在循环中使用字符串拼接，就有问题了
     * @param args
     */
    public static void main(String[] args) {
        String mango = "mango";
        String s = "abd" + mango + "def" + 47;
        System.out.println(s);
    }
}
