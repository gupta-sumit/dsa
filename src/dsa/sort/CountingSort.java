package algo.sort;

import algo.utils.ArrayUtils;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] ints = ArrayUtils.intArray(6, 3, 4, 5, 5, 0, 6, 9, 10, 7);
        System.out.println(Arrays.toString(sort(ints)));
    }

    public static int [] sort(int [] nums) {

        // 6 3 4 5 5 0 6 9 10 7
        // 0 3 4 5 5 6 6 7 9 10
        // 0 1 2 3 4 5 6 7 8 9 10
        // 1      1 1 2 2 1    1 1

        // 1 1 1 2 3 5 7 7 8 8 9
        //
        int k = findMaxValue(nums);
        int [] count = new int[k+1];
        for(int i=0; i < nums.length; i++) {
            count[nums[i]] = count[nums[i]] + 1;
        }
        for(int i=1; i <= k; i++) {
            count[i] = count[i] + count[i-1];
        }
        int [] out = new int[nums.length];
        for(int i=nums.length-1; i>= 0; i--) {
            out[count[nums[i]]-1] = nums[i];
            count[nums[i]] = count[nums[i]] - 1;
        }
        return out;
    }

    private static int findMaxValue(int[] nums) {
        int max = nums[0];
        for(int i=1; i < nums.length; i++) {
            if(max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }

}
