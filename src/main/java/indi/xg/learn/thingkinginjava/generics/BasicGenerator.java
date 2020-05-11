package indi.xg.learn.thingkinginjava.generics;

/**
 * 一个通用的Generator
 * @param <T>
 */
public class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;

    // 传入一个Class
    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成一个指定的对象生成器，然后用调用next()方法，生成对象
     * @param type
     * @param <T>   MyType.class
     * @return
     */
    public static <T> Generator<T> create(Class<T> type) {
        // 需要一个构造器，传入一个类对象
        return new BasicGenerator<>(type);
    }

}

