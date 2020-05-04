package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 匿名内部类方法参数使用final
 * @author chenshixue
 * @date 2020/5/4
 */
public class Parcel9 {

    // 这里的final可以不写，但编译器默认其就是final的
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;
            // 不可以改变dest，编译报错
//            dest = "Wuhan";
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("China");
    }
}
