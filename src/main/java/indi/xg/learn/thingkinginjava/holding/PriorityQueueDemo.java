package indi.xg.learn.thingkinginjava.holding;

import java.util.*;

/**
 * 优先级队列PriorityQueue
 * @author chenshixue
 * @date 2020/5/5
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        // 直接通过PriorityQueue来创建优先级队列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            // 通过offer()方法插入元素
            priorityQueue.offer(rand.nextInt(1 + 10));
        }
        // 可以看到，虽然插入值是随机的，但打印出来后却是有序的，这时因为在插入对象时，这个对象会在队列中排序
        QueueDemo.printQ(priorityQueue);

        List<Integer> ints = Arrays.asList(25, 12, 23, 1, 2, 1, 1, 5, 4);
        // 初始化时传入一个无序的数组，打印出来的也是有序的队列，这时因为进行了默认排序
        priorityQueue = new PriorityQueue<>(ints);
        QueueDemo.printQ(priorityQueue);

        // Collection.reverseOrder()反转集合中对象的顺序，可以看到打印出来的与之前的相反
        // 这里第二个参数其实是一个Comparator，我们也可以使用自己定义的Comparator
        priorityQueue = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);


        // 传入一串字符串，可以看到也是有默认排序了的，并且可以发现，空格也会插入到队列中，并且优先级高于字符串
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> stringList = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<>(stringList);
        QueueDemo.printQ(stringPQ);

        // 字符串也是可以反转顺序，改变优先级的，同时也可以自定义Comparator
        stringPQ = new PriorityQueue<>(stringList.size(), Collections.reverseOrder());
        stringPQ.addAll(stringList);
        QueueDemo.printQ(stringPQ);

        // 上面的队列元素都是可以重复的，使用Set先去重后再进入插入队列，实现不重复的队列
        Set<Character> charSet = new HashSet<>();
        for (char c : fact.toCharArray()) {
            charSet.add(c);
        }
        PriorityQueue<Character> characterPQ = new PriorityQueue<>(charSet);
        QueueDemo.printQ(characterPQ);

    }
}
