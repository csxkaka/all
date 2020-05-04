package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 局部内部类，在方法内
 * @author chenshixue
 * @date 2020/5/2
 */
public class Parcel5 {
    public Destination destination(String s) {
        // 创建的PDestination对象只能在destination()方法作用域内使用
        // 但是不表示destination()方法执行完后PDestination这个类就不可用了，这个类已经被加载到元数据区了
        class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }
            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("CHINA");
    }
}
