package indi.xg.learn.thingkinginjava.generics;

import indi.xg.learn.thingkinginjava.generics.util.New;

import java.util.List;
import java.util.Map;

/**
 * 泛型的返回类型及显示类型说明
 */
public class LimitsOfInference {

    static void fit(Map<String, String> params) {
        System.out.println("aa");
    }

    public static void main(String[] args) {
        // 正常情况下我们希望看到的是这样的，但其实这里的String类型是我们手动强转的
        List<String> list = New.list();
        Map<String, String> map = New.map();

        // 如果用IDEA快捷键自动补全变量，Ctrl+Alt+V，会发现是下面这样的，
        // 调用泛型方法后，返回值被赋给了一个Object类型的变量
        List<Object> list1 = New.list();
        Map<Object, Object> map1 = New.map();

        // 显示的声明泛型的返回类型，如果是在一个普通方法内，New换成this
        fit(New.<String, String>map());

    }
}
