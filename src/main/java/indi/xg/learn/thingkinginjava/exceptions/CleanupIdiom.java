package indi.xg.learn.thingkinginjava.exceptions;

/**
 * 构造函数抛出异常的处理方式（创建对象时就抛出异常的情况），finally的使用方式
 */
public class CleanupIdiom {
    public static void main(String[] args) {
        // 第一种情况，构造函数不会抛出异常，创建对象后，一个try..catch..finally就可以了
        NeedsCleanup nc1 = new NeedsCleanup();
        try {
            // ...
        } finally {
            // 对象一定会创建成功，在finally内清理对象
            nc1.dispose();
        }

        // 第二种情况，构造函数不会抛出异常，同时执行多个构造函数
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {
            // ...
        } finally {
            // 将创建的多个对象都放在finally中，一次性清理，他们都不会在创建对象的时候失败，
            // 但是关闭是有顺序的，后创建的对象先关闭
            nc3.dispose();
            nc2.dispose();
        }

        // 第三种情况，构造对象会抛出异常，NeedCleanup2的构造方法中带有throws Exception
        try {
            // 创建失败是不需要关闭的，因为对象创建失败了，那么调用对象的dispose()也会失败。
            // 对于会失败的构造函数，应该用双重try，外层使用try..catch，内层使用try..catch..finally
            // 执行到了内层的try，说明对象创建成功了，在finally中执行关闭操作保证不会失败
            NeedCleanup2 nc4 = new NeedCleanup2();
            try {
                // 如果nc4创建成功，那么执行nc5的创建，如果nc5创建失败，进入catch，并且在finally中
                // 保证nc4始终被清理
                NeedCleanup2 nc5 = new NeedCleanup2();

                // 如果nc5创建成功，进入下一个try，finally保证nc5始终会被清理，
                // nc5.dispose()执行完后，会继续执行外层的finally，也就是nc4.finally，
                // 这也保证了后创建的对象先被清理
                // finally不是return，不表示方法的结束，它只表示当前的try语句结束
                try {
                    // ...
                } finally {
                    nc5.dispose();
                }
            } catch (ConstructionException e) {
                System.out.println(e);  // 捕获nc5构造方法抛出的异常
            } finally {
                nc4.dispose();
            }
        } catch (ConstructionException e) { // 捕获nc4构造方法抛出的异常
            System.out.println(e);
        }
    }
}

class NeedsCleanup {
    // 这是一个静态变量，只有一份，每次创建一个对象，成员变量id初始化时都会使counter加1，
    // 从而每个对象的id都是不一样的
    private static long counter = 1;
    private final long id = counter++;
    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

class ConstructionException extends Exception {}

class NeedCleanup2 extends NeedsCleanup {
    public NeedCleanup2() throws ConstructionException {}
}