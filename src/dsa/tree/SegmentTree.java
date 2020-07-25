package algo.Tree;

import java.util.Arrays;
import java.util.function.BiFunction;

public class SegmentTree<T> {

    private final SegmentTreeNode<T>[] tree;
    private final BiFunction<T,T,T> mergeFunction;


    private static class SegmentTreeNode<K> {
        K val;
        int start;
        int end;

        public SegmentTreeNode(K val, int start, int end) {
            this.val = val;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "" + val + "(" + start +"," + end + ")";
        }
    }

    public SegmentTree(T[] arr, BiFunction<T,T,T> mergeFunction)  {
        tree = new SegmentTreeNode[4* arr.length];
        this.mergeFunction = mergeFunction;
        buildTree(arr, 0, arr.length - 1, 0);
    }

    private SegmentTreeNode<T> buildTree(T[] arr, int l, int r, int i) {
        if(l == r) {
            return new SegmentTreeNode<T>(arr[l],l,r);
        }
        int mid = l + (r-l)/2;
        tree[2*i+1] = buildTree(arr,l,mid,2*i + 1);
        tree[2*i + 2] = buildTree(arr,mid+1, r, 2*i + 2);
        tree[i] = new SegmentTreeNode(mergeFunction.apply(tree[2*i + 1].val, tree[2*i + 2].val), l, r);
        return tree[i];
    }

    public void update(int index, T val) {
        updateInternal(index,val,0);
    }

    private void updateInternal(int index, T val, int i) {
        if(tree[i].start == index && tree[i].end == index) {
            tree[i].val = val;
            return;
        } else {
            int mid = tree[i].start + (tree[i].end - tree[i].start)/2;
            if(isWithin(tree[i].start, mid, index)) {
                updateInternal(index, val, 2*i + 1);
            } else {
                updateInternal(index, val, 2*i + 2);
            }
            tree[i].val = mergeFunction.apply(tree[2*i + 1].val, tree[2*i + 2].val);
        }
    }

    private boolean isWithin(int start, int end, int index) {
        return index >= start && index <= end;
    }

    public T getValue(int l, int r) {
        return getValueInternal(l,r,0);
    }

    private T getValueInternal(int l, int r,int i) {
        if(tree[i].start == l && tree[i].end == r) {
            return tree[i].val;
        } else {
            int mid = tree[i].start + (tree[i].end - tree[i].start)/2;
            if(isCompleteOverlap(tree[i].start,mid, l,r)) {
                return getValueInternal(l,r, 2*i + 1);
            } else if(isCompleteOverlap(mid + 1, tree[i].end, l, r)){
                return getValueInternal(l,r, 2*i + 2);
            } else {
                return mergeFunction.apply(getValueInternal(l,mid,2*i + 1), getValueInternal(mid+1, r, 2*i+2));
            }
        }
    }

    private boolean isCompleteOverlap(int start, int end, int l, int r) {
        if( l >= start && r <= end) {
            return true;
        }
        return false;
    }


    public void print() {
        System.out.println(Arrays.toString(tree));
    }
}
