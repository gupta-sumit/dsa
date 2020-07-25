package algo.ds;

import algo.utils.Assert;

public class DequeTest {

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(10);
        deque.addFirst(20);
        deque.addFirst(30);
        deque.print();
        deque.addLast(-5);
        deque.print();

        Assert.equals(deque.removeLast(), -5);
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        deque.addLast(10);
        deque.print();
    }
}
