package algo.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargestConsecutiveIntegerSubArray {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(100,200);
        Set<Integer> set =  new HashSet<>(integers);
        int max = 0;

            int val = 0;
            for(Integer i: integers) {
                boolean remove = set.remove(i);
                if(remove) {
                    int left = findSequence(i-1,-1,set);
                    int right = findSequence(i+1,1,set);
                    val = 1 + left + right;
                    if(val > max) {
                        max = val;
                    }
                }
            }

        System.out.println(max);

    }

    private static int findSequence(int i, int i1, Set<Integer> set) {
        if(set.isEmpty()) {
            return 0;
        }
        if(set.contains(i)) {
            set.remove(i);
            return 1 + findSequence(i + i1,i1,set);
        }
        return 0;
    }


}
