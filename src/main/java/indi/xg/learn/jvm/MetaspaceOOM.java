package indi.xg.learn.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态生成类，模拟metaspace区域OOM，生成内存快照
 * 给metaspace区域设置10m大小
 * -XX:+UseParNewGC
 * -XX:+UseConcMarkSweepGC
 * -XX:MetaspaceSize=10M
 * -XX:MaxMetaspaceSize=10M
 * -XX:+PrintGCDetails
 * -Xloggc:gc.log
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:HeapDumpPath=./
 */
public class MetaspaceOOM {

    public static void main(String[] args) {
        int count = 0;

        /**
         * 每动态创建一个类后，都会创建对象，run()执行完后，这些代理对象就是垃圾了，
         * 然后新生代满了，触发ygc，但这不会导致OOM，因为ygc可以清除很多垃圾对象，
         * 不管循环多少次，都不会导致堆内存OOM。
         * 由于每创建一个类，就会把这个类加载到metaspace区，所以最终会导致metaspace区域内存满了，
         * 从gc.log看出，在几次ygc后出现了[Full GC (Metadata GC Threshold)]这就是说明是由于metaspace区满了而触发的FGC
         * 再之后会出现了[Full GC (Last ditch collection)]，这表示垃圾回收器将尝试最后一次Full GC,
         * 如果执行Full GC后还是内存不足，则打印日志，触发OOM异常，程序中断。
         *
         * 从gc中看到，新生代，老年代的内存占用很少，而Metaspace却占了很多，也可以说明是metaspace区满了，而不是堆内存
         *
         * 这种情况，一般是将enhancer设为缓存，
         * Enhancer enhancer = null;
         * if(enhancer == null){
         *     // 这里创建类
         * }
         */
        while (true) {
            // 需要添加cglib依赖
            Enhancer enhancer = new Enhancer();
            // 创建的每个类都是不一样的，但都是Car的子类。
            enhancer.setSuperclass(Car.class);
            // 默认是true，设为true那么不会重复创建类，而是从缓存中读取，所以必须设为false才会使metaspace区内存溢出
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    // 拦截run方法，可以用同样的方式拦截其他的方法
                    if (method.getName().equals("run")) {
                        System.out.println("执行父类的run方法之前，先做一些逻辑处理");
                        return proxy.invokeSuper(obj, args);
                    } else {
                        return proxy.invokeSuper(obj, args);    // 其他方法就直接执行父类方法
                    }
                }
            });
            // 创建对象并向上转型，上面的代码是设置类信息，并没有创建类，只有在需要创建对象的时候才会创建类并将类加载到metaspace区。
            Car car = (Car) enhancer.create();
            System.out.println("目前创建了" + ++count + "个Car类的子类");
            // 执行父类的方法
            car.run();
        }
    }

    static class Car {
        public void run() {
            System.out.println("Car子类对象执行了run方法");
        }
    }

}
