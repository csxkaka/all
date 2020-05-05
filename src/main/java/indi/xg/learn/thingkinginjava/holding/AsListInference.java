package indi.xg.learn.thingkinginjava.holding;

import java.util.Arrays;
import java.util.List;

/**
 * 关于Arrays.asList()
 * @author chenshixue
 * @date 2020/5/4
 */
public class AsListInference {

    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(
                new Crusty(), new Slush(), new Powder());

        List<Snow> snow2 = Arrays.asList(
                new Light(), new Heavy());
        // 运行时会报错，UnsupportedOperationException，
        // 这是因为Arrays.asList()返回的是Arrays工具类中的一个内部类ArrayList，而不是java.util下的ArrayList
//        Collections.addAll(snow1, new Light(), new Heavy());
        System.out.println(snow1);
        System.out.println(snow2);
    }
}
class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}