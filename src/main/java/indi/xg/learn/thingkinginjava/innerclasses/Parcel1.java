package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 非静态内部类
 * @author chenshixue
 * @date 2020/5/2
 */
public class Parcel1 {

    class Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() {
            return label;
        }
    }

    public void ship(String dest) {
        // 可以在外部类的普通方法创建内部类的对象（非静态内部类和静态内部类都可以）
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        // 不能通过在外部类的静态方法内部直接创建非静态内部类，下面两种都是不行的
//        Contents contents = new Contents();
//        Parcel1.Contents contents = new Contents();
        p.ship("China");
    }

}
