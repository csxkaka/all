package indi.xg.learn.thingkinginjava.typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * 在面向对象编程的时候，应该尽可能的只操纵基类的引用，而不是具体的子类
 * 操纵基类引用时，会自动识别具体的对象是基类的哪个子类对象，做出正确的行为，
 * 这就是多态
 */
public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(
                new Circle(), new Square(), new Triangle()
        );

        // 从输出结果可知，虽然使用的是基类Shape的引用，但打印出来的是子类对象的toString()方法，
        // 因为虽然是基类引用，但实际干活的是引用指向的具体对象，这个具体对象是可以确定具体类型的。
        for (Shape shape : shapeList) {
            shape. draw();
        }
    }
}

abstract class Shape {
    void draw() {
        // this表示调用这个draw()方法的对象引用，
        // 当想让对象已字符串形式表示时，会自动调用对象的toString()，
        // 所以这里的this就是调用了各自的toString()方法返回的字符串，Circle,Square,Triangle
        System.out.println(this + ".draw()");
    }
    abstract public String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}
class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}
class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}
