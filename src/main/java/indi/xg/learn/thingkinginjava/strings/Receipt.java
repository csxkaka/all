package indi.xg.learn.thingkinginjava.strings;

import java.util.Formatter;
import java.util.Locale;

/*
 * Formatter格式化说明符介绍，这里的格式对于String.format()同样适用
 */
public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);

    /**
     * 对于format()方法，第一个参数格式化是有公式可以套用的
     * %[argument_index$][flags][width][.precision]conversion
     * %是每一次格式化的开头，如下所示，
     * argument_index$表示使用参数列表中的第几个参数，
     * 比如方法f.format("", a, b, c); 那么%1$表示格式化的时候使用a这个参数，%3$表示格式化的时候使用c这个参数，
     * 如果不加这个参数，则默认按照方法参数的顺序匹配。
     * flags用来控制输出格式，比如-表示左对齐，不加则默认是右对齐，
     * ,表示金额用,号分隔开，12223332格式化为12,223,332
     * width表示最小最小宽度，
     * .precision，如果是字符串，表示字符串的最大字符数，
     * 如果是浮点数，表示保留的位数，
     * 日期，整数这些就不能使用.precision，使用了直接报错
     * conversion表示转换的类型，比如s表示字符串，f表示浮点数，d表示整数
     * tY表示年份2020，tm表示月份05，td表示日07等
     */
    public void printTitle() {
        // %-15s 表示从左开始最少需要占用15个字符，没有这么多字符用空格补到15个，
        // 如果不止15字符则继续增加，知道格式化完成。
        // %10s 表示从右开始最少占用10个字符
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        // %-15.15s 从左开始，只能是15个字符，多余的字符截掉，不足15个用空格补齐
        f.format("%-15.15s %5d %10.2f\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        // %10.2f 表示右对齐，至少占用10宽度，一个宽度就是一个空格（这里和语言有关），数字保留2未小数，不足的补0
        // 有个重载的方法来使用不同地区的语言，f.format(Locale.CHINESE, "", "");
        f.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);

    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}
