package algo.ds;

public class Deque<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    static class Node<T> {
        T val;
        Node next;
        Node prev;

        public Node(T val) {
            this.val = val;
        }


        @Override
        public String toString() {
            if(next == null) {
                return val + " -> NULL";
            }
            return val + " -> ";
        }
    }

    public void addFirst(T val) {
        Node<T> node = new Node<>(val);
        if(isEmpty()) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void addLast(T val) {
        Node<T> node = new Node<>(val);
        if(isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T removeFirst() {
        if(isEmpty()) {
            throw new EmptyException();
        } else {
            // Only single node
            Node removedNode = head;
            if(head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
            return (T)removedNode.val;
        }
    }

    public T removeLast() {
        if(isEmpty()) {
            throw new EmptyException();
        } else {
            Node removedNode = null;
            if(head.next == null) {
                removedNode = head;
                head = null;
                tail = null;
            } else {
                removedNode = tail;
                tail = removedNode.prev;
                tail.next = null;
            }
            size--;
            return (T)removedNode.val;

        }
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<T> curr = head;
        while(curr != null) {
            System.out.print(curr);
            curr = curr.next;
        }

        System.out.println();
    }


}
