package indi.xg.learn.thingkinginjava.generics;

/**
 * 使用泛型实现一个堆栈，有push和pop方法
 * @param <T> T可以是任意类型，本例是一个字符串类型
 */
public class LinkedStack<T> {
    /**
     * 每个节点包含一个对象和一个next节点
     * @param <U>
     */
    private static class Node<U> {
        U item;
        Node<U> next;
        // 构造一个空对象
        Node() {
            item = null;
            next = null;
        }
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        boolean end() {
            return item == null && next == null;
        }
    }
    // 外部类可以直接创建其私有的内部类，一开始，堆栈没东西，top为空节点
    private Node<T> top = new Node<T>();

    /**
     * 放入一个对象，放入最顶部
     * @param item
     */
    public void push(T item) {
        // 把要存入的对象格式化（封装）为一个Node节点，这个节点包含这个放入的对象引用和一个next，
        // 这个next其实也是一个Node节点
        top = new Node<>(item, top);
    }

    /**
     * 取出一个对象，从最顶部取
     * @return
     */
    public T pop() {
        T result = top.item;
        // 取出一个后，如果取出的这个不是组后一个，那么将next当作变成下一个顶部节点
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> ls = new LinkedStack<>();
        for (String s : "Phasers on stun".split(" ")) {
            ls.push(s);
        }
        String str;
        while ((str = ls.pop()) != null) {
            System.out.println(str);
        }
    }
}
