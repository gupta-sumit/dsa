package algo.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class PriorityQueue<K extends PriorityQueue.PriorityQueueNode<T>,T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Map<PriorityQueueNode, Integer> indexMap;
    private PriorityQueueNode [] tree;
    private int capacity = DEFAULT_CAPACITY;
    private int size = 0;
    private int insertIndex = 0;

    public PriorityQueue() {
        tree = new PriorityQueueNode[DEFAULT_CAPACITY];
        indexMap = new HashMap<>();
    }

    private int parent(int i) {
        return (i-1)/2;
    }

    private int left(int i) {
        return 2*i + 1;
    }

    private int right(int i) {
        return 2*i + 2;
    }

    public void add(K val) {
        if(isResizeNeeded()) {
            grow();
        }
        tree[insertIndex] = val;
        indexMap.put(val,insertIndex);
        decreaseKey(insertIndex);
        insertIndex++;
        size++;
    }

    private void grow() {
        capacity = capacity*2;
        PriorityQueueNode[] priorityQueueNodes = new PriorityQueueNode[capacity];
        for(int i=0; i < size; i++) {
            priorityQueueNodes[i] = tree[i];
        }
        tree = priorityQueueNodes;
    }

    private boolean isResizeNeeded() {
        return capacity == insertIndex;
    }

    public void decreaseKey(PriorityQueueNode node, T cost) {
        System.out.println(node + " updated cost " + cost);
        node.update(cost);
        Integer index = indexMap.get(node);
        decreaseKey(index);
    }

    private void decreaseKey(int index) {
        if(index == 0) {
            return;
        }
        int parent = parent(index);
        if(tree[parent].compareTo(tree[index]) > 0) {
            swap(index,parent);
            decreaseKey(parent);
        }
    }

    public K poll() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        insertIndex = insertIndex - 1;
        swap(0,insertIndex);
        K val = (K) tree[insertIndex];
        tree[insertIndex] = null;
        indexMap.remove(val);
        size--;
        heapify(0);
        return val;
    }

    private void heapify(int index) {
        int minIndex = index;
        int left = left(index);
        if(left < size && tree[index].compareTo(tree[left]) > 0 ) {
            minIndex = left;
        }
        int right = right(index);
        if(right < size && tree[minIndex].compareTo(tree[right]) > 0 ) {
            minIndex = right;
        }

        if(minIndex != index) {
            swap(minIndex,index);
            heapify(minIndex);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void swap(int index, int parent) {
        PriorityQueueNode temp = tree[index];
        tree[index] = tree[parent];
        tree[parent] = temp;
        indexMap.put(tree[parent], parent);
        indexMap.put(tree[index], index);
    }


    public interface PriorityQueueNode<T> extends Comparable<PriorityQueueNode<T>> {

        public T getCost();

        void update(T cost);
    }

}

