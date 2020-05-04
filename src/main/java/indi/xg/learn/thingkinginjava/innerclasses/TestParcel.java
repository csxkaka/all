package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 私有内部类
 * @author chenshixue
 * @date 2020/5/2
 */
class Parcel4 {
    private class PContents implements Contents {
        private int i = 11;

        public PContents() {

        }

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        public PDestination(String whereTo) {
            this.label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }

}

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();

        // 这里是可以的，因为p.contents()方法是Parcel4类中的，Parcel4里可以创建其私有子类的对象
        Contents c = p.contents();

        Destination d = p.destination("China");
        // 直接编译报错，因为PContents这个类是私有的，只有在他的外部类（Parcel4）里，或它本身类中，才可以创建这个对象。
//        Parcel4.PContents pContents = p.new PContents();

        // 因为PDestination这个类是protected的，所以可以访问创建对象
        // protected表示同一个包，或者子类可以访问
        Parcel4.PDestination pDestination = p.new PDestination("China");
    }
}

