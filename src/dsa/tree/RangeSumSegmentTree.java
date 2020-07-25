package algo.Tree;

import algo.utils.ConsolePrinter;

import java.util.function.BiFunction;

public class RangeSumSegmentTree {

    private int size;
    private SegmentTree<Integer> segmentTree;
    private BiFunction<Integer,Integer,Integer> mergeFunction = (t1,t2) -> {
        if(t1 == null) {
            return t2;
        } else if(t2 == null) {
            return t1;
        }
        return t1 + t2;
    };

    public RangeSumSegmentTree(Integer [] nums) {
        size = nums.length;
        segmentTree = new SegmentTree<>(nums,mergeFunction);
        segmentTree.print();
    }


    public static void main(String[] args) {
        Integer [] arr = new Integer[] {1,2,3,4,5};
        RangeSumSegmentTree rangeSumSegmentTree = new RangeSumSegmentTree(arr);
        ConsolePrinter.out(rangeSumSegmentTree.getSum(1,4));
        rangeSumSegmentTree.segmentTree.update(4,10);
        rangeSumSegmentTree.segmentTree.print();
        ConsolePrinter.out(rangeSumSegmentTree.getSum(3,4));
    }


    public int getSum(int start, int end) {
        if(start >= 0 && end < size && end >= start) {
            return segmentTree.getValue(start, end);
        }
        throw new IllegalArgumentException("Invalid Range");
    }
}
