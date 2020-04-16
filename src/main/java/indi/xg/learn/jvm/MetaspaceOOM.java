package indi.xg.learn.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态生成类，模拟metaspace区域OOM，
 * 给metaspace区域设置10m大小
 * -XX:MetaspaceSize=10
 * -XX:MaxMetaspaceSize=10m
 * -Xloggc:gc.log
 */
public class MetaspaceOOM {

    public static void main(String[] args) {
        int count = 0;

        while (true) {
            // 需要添加cglib依赖
            Enhancer enhancer = new Enhancer();
            // 创建的每个类都是不一样的，但都是Car的子类。
            enhancer.setSuperclass(Car.class);
            // 默认是true，设为true那么不会重复创建对象，而是从缓存中读取，所以必须设为false才会使metaspace区内存溢出
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
            System.out.println("目前创建了" + ++count + "个对象");
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
