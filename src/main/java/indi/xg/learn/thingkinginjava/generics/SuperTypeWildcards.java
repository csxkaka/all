package indi.xg.learn.thingkinginjava.generics;

import java.util.List;

/**
 * 超类型通配符
 */
public class SuperTypeWildcards {
    /**
     * 这里Apple是下界，它一定是Apple或者Apple的某种基类，编译器是可以知道这一点的
     * 所以向其中添加Apple或Apple的子类都是没有问题的
     * @param apples
     */
    static void writeTo(List<? super Apple> apples) {
        // apples.add()方法接收的参数随泛型参数的变化而变化
        // 这里就成了add(? super Apple)，接收的一定是Apple的某种基类，这是下届
        apples.add(new Apple());
        apples.add(new Jonathan());

        // 但是确不能这样，因为这回让list敞开口子，添加非Apple类，这是不被允许的
//        apples.add(new Fruit());
    }
}
