package indi.xg.learn.thingkinginjava.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 反射
 */
public class ShowMethods {

    private static String usage = "usage:\n" +
            "ShowMethods qualified.class.name\n" +
            "To show all methods in class or:\n" +
            "ShowMethods qualified.class.name word\n" +
            "To search for methods involving 'word'";

    // w. 匹配一个字母、下划线或数字，等价于[A-Za-z0-9_]后面加一个.号
    private static Pattern p = Pattern.compile("\\w+\\.");

    /**
     * 在命令行使用java ShowMethods a b c这样的，那么args就有值了，
     * 这个args就是命令行执行时，传入的参数.
     * 因为这里直接在IDEA里配置了启动携带的参数，所以这里的args的length不为0
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
//            Class<?> c = ShowMethods.class;
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    // 将java.lang.这种的包名去掉
                    System.out.println(p.matcher(method.toString()).replaceAll(""));
                }

                for (Constructor ctor : ctors) {
                    System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                }
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor ctor : ctors) {
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        System.out.println(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("No Such class:" + e);
        }
    }
}
