package indi.xg.learn.thingkinginjava.strings;

/**
 * Java SE5之后的格式化输出，System.out.format()，System.out.printf()
 */
public class SimpleFormat {
    public static void main(String[] args) {

        /*
         * System.out.format()和System.out.printf()是一样的，System.out.printf()是保留了C的写法
         * 这两者返回的都是PrintStream，而System.out.println()没有返回值
         */
        int x = 5;
        double y = 5.332542;
        System.out.println("Row 1: [" + x + " " + y + "]");

        // 第一个参数为一个模板字符串，后面的是可变参数，每个参数对应模板中的一个格式修饰符，如x对应%d，y对应%f
        // %d表示接收一个整数，%f表示接收一个浮点数
        // 使用格式化输出的好处，只需要一个模板字符串，不需要拼接多个变量，而且还有返回值

        System.out.format("Row 1: [%d %f]\n", x, y);
        System.out.printf("Row 1: [%d %f]\n", x, y);
    }
}
