package indi.xg.learn.thingkinginjava.innerclasses;

/**
 * 局部内部类，在方法的语句块内
 * @author chenshixue
 * @date 2020/5/4
 */
public class Parcel6 {

    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;
                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip() {
                    return id;
                }

            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        // 超出范围，只能在if()语句内创建该对象，虽然是用条件语句包裹了这个局部内部类，但在编译期任然会加载这个类到元数据区
//        TrackingSlip ts = new TrackingSlip("SS");
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
