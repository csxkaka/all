package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * @author chenshixue
 * @date 2020/5/4
 */
public class Wrapping {

    private int i;
    public Wrapping(int x) {
        i = x;
    }
    public Wrapping(int x, String y) {
        System.out.println("xx");
    }

    public int value() {
        return i;
    }
}
