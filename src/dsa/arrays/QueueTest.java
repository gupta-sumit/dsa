package algo.array;

import algo.utils.Assert;

import java.util.stream.IntStream;

public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(10);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        System.out.println(Assert.equals(10,queue.remove()));
        System.out.println(Assert.equals(20,queue.remove()));
        System.out.println(Assert.equals(30,queue.remove()));
        System.out.println(Assert.equals(40,queue.remove()));
        System.out.println(Assert.equals(50,queue.remove()));
        Assert.expect(() -> queue.remove(),QueueEmptyException.class);
        IntStream.range(0,10).forEach(queue::insert);
        Assert.expect(() -> queue.insert(10),QueueFullException.class);


    }
}
