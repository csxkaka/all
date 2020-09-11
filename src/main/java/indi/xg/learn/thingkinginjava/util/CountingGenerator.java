package indi.xg.learn.thingkinginjava.util;

/**
 * 一个基本类型数字生成器
 */
public class CountingGenerator {
    /**
     * 因为自己定义的类名就是Boolean，所以后面的泛型需要写全名，下面方法的返回值也要写全名
     */
    public static class Boolean implements Generator<java.lang.Boolean> {
        private boolean value = false;
        @Override
        public java.lang.Boolean next() {
            value = !value;
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        private byte value = 0;
        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }

    static char[] chars = ("abcdefghijklmnopqrstuvwsyt" + "ABCDEFGHIJKLMNOPQRSTUVWSYZ").toCharArray();
    public static class Character implements Generator<java.lang.Character> {
        private int index = -1;
        @Override
        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }

    public static class String implements Generator<java.lang.String> {
        private int length = 7;
        Generator<java.lang.Character> cg = new Character();
        public String() {}
        public String(int length) {
            this.length = length;
        }
        @Override
        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++) {
                buf[i] = cg.next();
            }
            return new java.lang.String(buf);
        }
    }

    public static class Short implements Generator<java.lang.Short> {
        private short value = 0;
        @Override
        public java.lang.Short next() {
            return value++;
        }
    }

    public static class Long implements Generator<java.lang.Long> {
        private long value = 0;
        @Override
        public java.lang.Long next() {
            return value++;
        }
    }

    public static class Float implements Generator<java.lang.Float> {
        private float value = 0;
        @Override
        public java.lang.Float next() {
            float result = value;
            value += 1.0;
            return result;
        }
    }

    public static class Double implements Generator<java.lang.Double> {
        private double value = 0.0;
        @Override
        public java.lang.Double next() {
            double result = value;
            value += 1.0;
            return result;
        }
    }

}
