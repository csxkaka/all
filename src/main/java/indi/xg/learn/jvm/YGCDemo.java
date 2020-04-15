package indi.xg.learn.jvm;

/*
 * @Author chenshixue
 * @Date 2020/4/1
 */
public class YGCDemo {

    /*
     * -XX:InitialHeapSize=10485760             初始堆大小：10M
     * -XX:MaxHeapSize=10485760                 最大堆大小：10M
     * -XX:NewSize=5242880                      新生代大小：5M
     * -XX:MaxNewSize=5242880                   最大新生代大小：5M      可知老年代为5M
     * -XX:SurvivorRatio=8                      eden和s区比例：8:1:1  即 eden：4M，s1：0.5，s2：0.5M
     * -XX:PretenureSizeThreshold=10485760      大对象设定大小：10M
     * -XX:+UseParNewGC                         年轻代：ParNew GC
     * -XX:+UseConcMarkSweepGC                  老年代：CMS(并发标记清理)
     * -XX:+PrintGCDetails                      打印gc详细日志
     * -XX:+PrintGCTimeStamps                   打印每次gc发生的时间
     * -Xloggc:gc.log                           将gc日志写入磁盘文件，gc.log
     *
     * @param [args]
     * @return void
     * @author chenshixue
     * @date 2020/4/1 16:33
     **/

    public static void main(String[] args) {
        // 1、启动main线程，执行main方法，创建一个main方法的栈帧，压入main线程对应的虚拟机栈中（每个线程都有一个自己的虚拟机栈和程序计数器），

        // 2、在新生代的eden区创建一个1M的对象，main方法栈帧中的局部变量表，维护一局部变量array1，指向新创建的这个对象，此时eden区为1M
        byte[] array1 = new byte[1024 * 1024];

        // 3、在eden区中再创建一个1M对象，将array1指向这个新的对象，之前的那个对象就没有引用指向了，此时eden区为2M
        array1 = new byte[1024 * 1024];

        // 4、在eden区中再创建一个1M对象，将array1指向这个新的对象，之前的那个对象就没有引用指向了，此时eden区为3M
        array1 = new byte[1024 * 1024];

        // 5、将array1指向null，即这个变量不指向任何对象，此时eden中的3个对象都是垃圾对象了
        array1 = null;

        // 6、在eden区中再创建一个2M对象
        /*
         * 分析：eden区总共4M，s1、s2为0.5M，老年代5M，在创建这个对象之前，会先检查这个对象的大小，发现这个对象为2M，加上这2M，eden就放不下了，
         * 则Allocation Failure(对象分配失败)，所以会先触发ygc，触发ygc之前会，由于老年代的空间担保机制（JDK1.6之后默认开启），
         * gc会先判断历次ygc回收的垃圾平均大小，是否大于老年代可用的连续内存大小，如果大于，就触发full gc，否则执行ygc。
         * 很显然，一开始还没有过ygc，所以历次ygc处理的垃圾对象大小的均值为0，所以执行ygc。
         * ygc执行完后，之前eden区的3M垃圾全部被回收，此时，eden区没有没有存活对象，大小为4M
         * 然后创建这个2M的对象，局部变量array2指向这个新创建的对象
         */
        byte[] array2 = new byte[2 * 1024 * 1024];
    }
}
