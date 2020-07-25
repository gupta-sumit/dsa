package algo.array;

import algo.utils.ArrayUtils;

public class MinimumDifferenceElement {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.intArray(4, 9, 15,20, 25);
        System.out.println(minimumDifferenceElement(nums,27));
    }

    public static int minimumDifferenceElement(int nums[] , int key) {
        int start = 0;
        int end = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        int index = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(key == nums[mid]) {
                return nums[mid];
            } else {
                int v = Math.abs(key - nums[mid]);
                if(diff > v) {
                    index = mid;
                    diff = v;
                } else {
                    break;
                }
                if(key < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        if(index != -1) {
            return nums[index];
        }
        return -1;
    }
}
