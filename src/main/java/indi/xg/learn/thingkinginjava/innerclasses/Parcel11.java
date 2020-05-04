package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 嵌套类（静态内部类）
 * 静态内部类就好比两个独立的java文件
 * @author chenshixue
 * @date 2020/5/4
 */
public class Parcel11 {

    private static class ParcelContents implements Contents {

        // 嵌套类，普通域和静态域都可以定义，但非静态内部类只能定义普通域
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {
        private String label;

        private ParcelDestination(String whereTo) {
            label = whereTo;
        }
        @Override
        public String readLabel() {
            return label;
        }

        public static void f() {}
        static int x = 10;

        // 嵌套类可以继续嵌套其他的类，且都是独立的，这里的f()，x，虽然都是上一层的，但下一层然可以再定义， 这不会冲突
        static class AnotherLevel {
            static int x = 10;
            public static void f() {};
        }
    }

    public static Destination destination(String s) {
        return new ParcelDestination(s);
    }
    public static Contents contents() {
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("China");
    }
}
