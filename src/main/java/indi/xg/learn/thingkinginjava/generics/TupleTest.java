package indi.xg.learn.thingkinginjava.generics;

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<>("hi", 47);
    }
    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<>(new Amphibian(), "hi", 47);
    }
    static FourTuple<Amphibian, Vehicle, String, Integer> h() {
        return new FourTuple<>(new Amphibian(), new Vehicle(), "hi", 47);
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> t = f();
        System.out.println(t);
        System.out.println(g());

        // 以FourTuple为例，执行过程其实是创建一个FourTuple对象前，
        // 会先执行其父类的构造函数super(A, B, C)，发现他也有父类，于是也先执行它父类的构造函数super(A, B)
        // 执行完super(A, B)后，执行this.third = c;
        // 在执行super(A, B, C)，再执行this.fourth = d，于是完整的FourTuple对象就构造出来了
        System.out.println(h());
    }
}

class Amphibian {}
class Vehicle {}
