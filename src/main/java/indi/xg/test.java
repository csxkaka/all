package indi.xg;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author chenshixue
 * @date 2020/4/24
 */
public class test {

    public static void main(String[] args) {

        // 四舍六入五成双，BigDecimal.valueOf()接收的是一个double类型，如果传入一个float类型，那么这个可能有问题
        // 就算是下面这种情况，将float类型转为double类型，也是有问题的
        float ss = 4.535f;
        double sss = (double)ss;
        double a = BigDecimal.valueOf(sss)
                .setScale(2, RoundingMode.HALF_EVEN)
                .doubleValue();
        System.out.println(a);
    }
}
