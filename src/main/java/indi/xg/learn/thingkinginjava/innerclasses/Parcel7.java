package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 匿名内部类，基类为接口
 * @author chenshixue
 * @date 2020/5/4
 */
public class Parcel7 {

    public Contents contents() {

        // Contents是一个接口，是不能使用new来创建对象的
        // 这里的意思是：我想创建一个实现了Contents接口的对象，那么首先必须有个Contents的子类来实现这个接口，才能创建实例对象
        // 这个创建出来的对象自动向上转型为对Contents的引用。

        // 如果Contents是一个普通的类，而不是接口，匿名内部类仍然是它的子类，而不是其本身

        // 括号里可以传入参数，使用不同的构造方法创建对象
        return new Contents(){
            private int i = 11;
            @Override
            public int value() {
                return 0;
            }
        };
    }
}
