package dsa.topk;

public class MinHeap {

    private int size = 0;
    private int [] tree;
    private int insertIndex = 0;

    public MinHeap(int totalElements) {
        tree = new int[totalElements];
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


    public void add(int item) {
        if(size == tree.length) {
            throw new HeapFullException();
        }
        tree[insertIndex] = item;
        size++;
        decreaseKey(insertIndex);
        insertIndex++;
    }

    private void decreaseKey(int index) {
        if(index == 0) {
            return;
        }
        int parent = parent(index);
        if(tree[index] < tree[parent]) {
            swap(index,parent);
            decreaseKey(parent);
        }
    }

    private void swap(int i, int j) {
        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }

    public int poll() {
        if(size == 0) {
            throw new NoElementException();
        }
        insertIndex = insertIndex - 1;
        swap(0,insertIndex);
        int item = tree[insertIndex];
        size--;
        heapify(0);
        return item;
    }

    public int peek() {
        if(size == 0) {
            throw new NoElementException();
        }
        return tree[0];
    }


    private void heapify(int index) {
        int minIndex = index;
        int left = left(index);
        if(left < size && tree[left] < tree[minIndex]) {
            minIndex = left;
        }
        int right = right(index);
        if(right < size && tree[right] < tree[minIndex]) {
            minIndex = right;
        }
        if(minIndex != index) {
            swap(index,minIndex);
            heapify(minIndex);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
