package indi.xg;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author chenshixue
 * @date 2020/4/24
 */
public class test {

    public static void main(String[] args) {

        /*
         * 四舍六入五成双
         * 传入的参数必须是double类型，而且不能是float自动转成的double，
         * 因为自动转换是经过了计算的，而double和float的计算都是可能导致精度丢失的。
         *
         * 如果要计算，最精确的做法是先计算，多保留几位小时，将值转成String类型，再通过Double.valueOf(str)，保留2位小时
         */
        String ss = "4.535";
        double a = BigDecimal.valueOf(Double.valueOf(ss)*1.0f)
                .setScale(2, RoundingMode.HALF_EVEN)
                .doubleValue();
        System.out.println(a);
    }
}
