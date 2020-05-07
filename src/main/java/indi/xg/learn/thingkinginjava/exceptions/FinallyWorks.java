package indi.xg.learn.thingkinginjava.exceptions;

/**
 * finally用法，
 * finally总是会执行，finally和return都存在时：
 * 1、finally内没有return，但finally之外有return，先将返回值固定起来，但不执行return操作，
 * 再执行finally语句块，当finally语句块执行完后，再执行return操作，返回结果，退出方法
 * 2、finally内和finally外都有返回值时，执行finally内的return操作，退出方法，不执行finally之外的return
 */
public class FinallyWorks {

    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                // 比较完了count才会加1
                if (count++ == 0) {
                    throw new ThreeException();
                }
                System.out.println("No exception");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally clause");
                if (count == 2) {
                    break;
                }
            }
        }
    }
}

class ThreeException extends Exception {}
