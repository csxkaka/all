package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 内部类建立之后就和外部类建立了联系，他可以访问外部类的成员
 * @author chenshixue
 * @date 2020/5/2
 */
public class Sequence {

    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }


    /**
     * 内部类可以直接访问或修改外部类的成员，尽管外部类属性是private，也可以访问
     * 如果这里是静态的内部类，则items是static修饰的才可以访问
     * 静态内部类里可以访问外部类的静态方法和静态成员
     **/
    private class SequenceSelector implements Selector {
        private int i = 0;

        // items是外部类的成员
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        // 迭代器设计模式，通过迭代获取对象
        for (int i = 0; i < 10; i++) {
            // i就是一个Object对象
            sequence.add(Integer.toString(i));
        }

        // 自动向上转型了，这里创建的只是一个空对象
        // 当外部类对象构建了一个内部类的对象时，这个内部类对象会秘密的捕获一个指向这个外部类对象的引用，
        // 之后，如果内部类对象访问外部类对象的成员时，其实是用它捕获的这个引用来操作的。
        // 一个对象是可以有多个引用同时指向的。
        Selector selector = sequence.selector();

        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            // SequenceSelector对象的++操作
            selector.next();
        }
    }
}
