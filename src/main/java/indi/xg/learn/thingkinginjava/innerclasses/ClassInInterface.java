package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 接口内部的类，默认就是嵌套类（静态内部类）
 * @author chenshixue
 * @date 2020/5/4
 */
public interface ClassInInterface {

    void howdy();

    // 放到接口中的类自动就是static的，所以这里的static不写，也是接口的静态内部类（嵌套类）
    // 这相当于两个.java文件，是没有印象的，也不违背接口的定义规则
    static class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
