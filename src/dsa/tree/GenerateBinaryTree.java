package algo.Tree;

import algo.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateBinaryTree {

    public static void main(String[] args) {
        int[] ints = ArrayUtils.intArray(1,2,3,4);
        System.out.println(generateBinaryTrees(ints,0,ints.length-1));
    }

    public static List<String> generateBinaryTrees(int [] nums, int start, int end) {
        if(start == end) {
            return Arrays.asList(nums[start] + "");
        }
        List<String> out = new ArrayList<>();
        for(int i=start; i <= end; i++) {
            // Picking i as root of tree
            List<String> leftSubtree = Collections.emptyList();
            if (i - 1 >= start) {
                leftSubtree = generateBinaryTrees(nums, start, i - 1);
            }
            List<String> rightSubtree = Collections.emptyList();
            if (i + 1 <= end) {
                rightSubtree = generateBinaryTrees(nums, i + 1, end);
            }

            if (leftSubtree.isEmpty() && rightSubtree.isEmpty()) {
                return Arrays.asList(nums[i] + "");
            } else if (rightSubtree.isEmpty()) {
                for (String left : leftSubtree) {
                    out.add(nums[i] + " " + left);
                }
            } else if (leftSubtree.isEmpty()) {
                for (String right : rightSubtree) {
                    out.add(nums[i] + " " + right);
                }
            } else {
                for (String left : leftSubtree) {
                    for (String right : rightSubtree) {
                        out.add(nums[i] + " " + left + " " + right);
                    }
                }
            }
        }
        return out;
    }

}
