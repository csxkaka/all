package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 静态方法中创建非静态内部类的对象
 * @author chenshixue
 * @date 2020/5/2
 */
public class Parcel2 {

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

    public Destination to(String s) {
        return new Destination(s);
    }
    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        // 这个c和d引用变量，指向的是Contents对象和Destination对象
        // 但其实各自还有一个隐藏的引用，指向了外部类Parcel2的对象
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.label);
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("China");
        Parcel2 q = new Parcel2();

        // 通过外部对象的方法调用，在静态方法中获取内部类的对象
        Contents c = q.contents();
        // 而更应该用这这种形式
//        Parcel2.Contents c = q.contents();
        Destination d = q.to("USA");
    }
}
