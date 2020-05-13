package indi.xg.learn.thingkinginjava.generics;

/**
 * 捕获转换
 */
public class CaptureConversion {
    /**
     *
     * @param holder
     * @param <T>  具体的类型
     */
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    /**
     * 捕获未知的类型，转换为具体的类型
     * @param holder 未知的类型
     */
    static void f2(Holder<?> holder) {
        // 一开始并不知道holder具体的类型，参数类型实在f2()调用的过程中被捕获的
        // 捕获到之后进行类型转换
        f1(holder);
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f1(raw);
        f2(raw);

        Holder rawBasic = new Holder();
        rawBasic.set(new Object());
        f2(rawBasic);
        Holder<?> wildcarded = new Holder<Double>(1.0);
        f2(wildcarded);
    }
}
