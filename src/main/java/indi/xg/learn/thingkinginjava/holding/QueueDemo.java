package indi.xg.learn.thingkinginjava.holding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 队列
 * @author chenshixue
 * @date 2020/5/5
 */
public class QueueDemo {

    public static void printQ(Queue queue) {
        // peek()方法，返回队列头部节点，但不移除节点，如果队列为空，则返回null
        // element()方法，同样返回队列头，也不移除节点，但如果队列为空，则抛出异常（NoSuchElementException）
        while (queue.peek() != null) {
            // remove()方法，将队列的头部节点删除，并返回，如果队列为空，则抛出异常（NoSuchElementException）
            // poll()方法，同样将队列的头部节点删除，并返回，但如果队列为空，返回null，而不抛出异常
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 队列LinkedList实现了Queue接口，所以可以使用LinkedList来构建一个队列
        // Queue接口窄化了对LinkedList接口的访问权限，将LinkedList转为Queue，有些LinkedList的方法就不能使用了，
        // 这样可以专注于队列的实现
        Queue<Integer> queue = new LinkedList<>();
        Random rand  = new Random(47);
        for (int i = 0; i < 10; i++) {
            // offer()方法，在队列的尾部插入一个元素
            queue.offer(rand.nextInt(i + 10));
        }
        printQ(queue);

        Queue<Character> qc = new LinkedList<>();
        for (char c : "Brontosaurus".toCharArray()) {
            qc.offer(c);
        }
        printQ(qc);
    }
}
