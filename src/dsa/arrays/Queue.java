package algo.array;

public class Queue<T> {

    private final int capacity;
    private int size;
    private Object [] a;
    private int front;
    private int rear;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.a = new Object[capacity];
        front = 0;
        rear = 0;
    }

    public void insert(T item) {
        if(size == a.length) {
            throw new QueueFullException();
        }
        a[rear] = item;
        size++;
        rear = (rear + 1)%capacity;
    }

    public T remove() {
        if(size == 0) {
            throw new QueueEmptyException();
        }
        T item = (T)a[front];
        a[front] = null;
        size--;
        front = (front + 1)%capacity;
        return item;
    }

    public int  getSize() {
        return size;
    }
}
