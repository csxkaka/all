package indi.xg.learn.thingkinginjava.strings;

/**
 * 循环中使用字符串拼接选的底层实现
 */
public class WhitherStringBuilder {

    /**
     * 根据反编译的结果发现，在循环中使用字符串拼接，那么每次循环，编译器都会生成一个StringBuilder对象，
     * 将当前循环的字符串拼接完后，下次循环又创建一个StringBuilder对象，
     * 因此虽然编译器在拼接字符串的时候，虽然自动创建了StringBuilder对象，在循环中效率也会有所下降，
     * 特别是循环次数大的时候
     * @param fields
     * @return
     */
    public String implicit(String[] fields) {
        String result = "";
        for (int i = 0; i < fields.length ; i++) {
            result += fields[i];
        }
        return result;
    }

    /**
     * 使用StringBuilder循环拼接字符串，StringBuilder是Java SE5引入的
     * 循环的过程中都是用的我们创建的这个对象，而不会创建新的对象
     * 因此循环拼接字符串还是要用StringBuilder
     * @param fields
     * @return
     */
    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            result.append(fields[i]);
        }
        return result.toString();
    }
    /**
     * StringBuilder也存在一定的问题，比如使用append(a + :" + b)这种格式的
     * 其中a，b是两个变量，此时编译器会陷入陷阱，因为括号内是一组字符串拼接，那么
     * 编译器会另外创建一个StringBuilder对象将括号内的先拼接起来，在和外面的对象进行拼接
     * 如果拿不准该用哪种方式，就可以用javap -c 来分析程序，只创建一次StringBuilder对象的当然是最好的
     */
}
