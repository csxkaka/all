package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * @author chenshixue
 * @date 2020/5/4
 */
public class Parcel10 {

    public Destination destination(final String dest, final float price) {

        // 如果这里是接口，则只有这种方式能创建匿名内部类，不能接收参数
        // 如果这里是普通类，这个类有几种构造器，这里就有几种创建方式。
        Destination d = new Destination() {
            private int cost;
            private String label = dest;

            // 直接使用代码块，在创建这个对象的时候就会初始化这里
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over budget!");
                }
            }
            @Override
            public String readLabel() {
                System.out.println(label);
                return label;
            }
        };
        // 使用匿名内部类的对象调用
        d.readLabel();
        return d;
    };

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("China", 101.1f);
    }
}
