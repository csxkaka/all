package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 从多层嵌套类访问外层类的成员
 * @author chenshixue
 * @date 2020/5/4
 */
public class MultiNestingAccess {

    public static void main(String[] args) {
        MNA mna = new MNA();

        // 一层一层的创建对象
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}

class MNA {
    private void f() {
        System.out.println("MNA");
    }

    class A {
        private void g() {
            System.out.println("A");
        }

        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}
