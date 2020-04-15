package indi.xg.collect.utils.formula;

/**
 * 风速风向 和 UV分量 互转
 * U 水平风速，V 垂直风速，向量和为实际风速和风向。
 * @Author chenshixue
 * @Date 2020/3/13
 */
public class WindUV {

    /**
     *  UV分量转风向
     *  风速的范围是0~360度，正北为0，顺时针
     * @param u U分量
     * @param v V分量
     * @Return  double
     * @Author  chenshixue
     * @Date    2020/3/13 15:17
     */
    public static double uvToWd(double u, double v) {
        double wd;
        if (u > 0 && v > 0) {
            wd = 270 - Math.atan(v / u) * 180 / Math.PI;    // Math.atan(x) 计算x的反正切值
        } else if (u < 0 && v > 0) {
            wd = 90 - Math.atan(v / u) * 180 / Math.PI;
        } else if (u < 0 && v < 0) {
            wd = 90 - Math.atan(v / u) * 180 / Math.PI;
        } else if (u > 0 && v < 0) {
            wd = 270 - Math.atan(v / u) * 180 / Math.PI;
        } else if (u ==0 && v > 0) {
            wd = 180;
        } else if (u ==0 && v < 0) {
            wd = 0;
        } else if (u > 0 && v== 0) {
            wd = 270;
        } else if (v < 0 && v == 0) {
            wd = 90;
        } else {
            wd = 999.9;
        }
        return wd;
    }

    /**
     *  UV分量转风速
     *  风速 = UV分量平方和的平方根
     * @param u
     * @param v
     * @Return  double
     * @Author  chenshixue
     * @Date    2020/3/13 15:34
     */
    public static double uvToWs(double u, double v) {
        double ws = Math.sqrt(Math.pow(u, 2) + Math.pow(v, 2)); // Math.pow(u, )  计算u的n次方
        return ws;
    }

    /**
     *  根据风速和风向，计算U
     * @param
     * @Return  double
     * @Author  chenshixue
     * @Date    2020/3/13 15:38
     */
    public static double countU(double ws, double wd) {
        if (ws < 0) return 0;
        double u = ws * Math.cos((270 - wd) * Math.PI / 180);
        return u;
    }

    /**
     *  根据风速和风向，计算V
     * @param ws
     * @param wd
     * @Return  double
     * @Author  chenshixue
     * @Date    2020/3/13 15:42
     */
    public static double countV(double ws, double wd) {
        if (ws < 0) return 0;
        double v = ws * Math.sin((270 - wd) * Math.PI / 180);
        return v;
    }
}
