package dsa.arrays;

public class MaxSum {

    public int maxSubArraySum(int nums[]) {
        int k=1;
        int minIndex = 0;
        while(k < nums.length && nums[k] < 0) {
            if(nums[k] > nums[minIndex]) {
                minIndex = k;
            }
            k++;
        }
        if(k == nums.length) {
            return nums[minIndex];
        }
        int max = 0;
        int sum = 0;
        for(int i=0; i < nums.length; i++) {
            sum = sum + nums[i];
            if(sum > max) {
                max = sum;
            } else if(sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }


    public int getMaxSubArraySumCircular(int nums[]) {
        int maxSumRegular =  maxSubArraySum(nums);
        if(maxSumRegular < 0) {
            return maxSumRegular;
        }
        int totalSum = 0;
        for(int i=0; i < nums.length; i++) {
            totalSum = totalSum + nums[i];
            nums[i] = -nums[i];
        }
        
        int maxNegativeSum = maxSubArraySum(nums);
        for(int i=0; i < nums.length; i++) {
            nums[i] = -nums[i];
        }
        int circularSum = totalSum + maxNegativeSum;
        return maxSumRegular > circularSum ? maxSumRegular : circularSum;
    }

    public int getMaxSubArraySumInRepeatedArray(int nums[], int k) {
        if(k == 0) {
            return 0;
        } 
        if(k == 1) {
            return maxSubArraySum(nums);
        }
        int totalSum = 0;
        for(int i=0; i < nums.length; i++) {
            totalSum = totalSum + nums[i];
        }
        int s = getMaxSubArraySumCircular(nums);
        if(totalSum <= 0) {
            return s;
        }   
        int max = 0;
        int sum = 0;
        int subArrayStartIndex = -1;
        int subArrayEndIndex = -1;
        int totalSumTillMax = 0;
        int ts = 0;
        for(int i=0; i < nums.length; i++) {
            sum = sum + nums[i];
            ts = ts + nums[i];
            if(sum > max) {
                if(subArrayStartIndex == -1) {
                    subArrayStartIndex = i;
                    subArrayEndIndex = i;
                } else {
                    subArrayEndIndex = i;
                }
                max = sum;
                totalSumTillMax = ts;
            } else if(sum <= 0) {
                sum = 0;
                subArrayStartIndex = -1;
                subArrayEndIndex = -1;
            }
        }
        // 4 -5 4 4 -5 4\
        System.out.println(max);
        int s1 = ts*(k-1) + (totalSumTillMax > 0 ? totalSumTillMax : 0);
        return s1 > s ? s1 : s;
    }

    public static void main(String[] args) {
        MaxSum maxSum = new MaxSum();
        int [] nums = new int[] {6,-5,1};
        System.out.println(maxSum.getMaxSubArraySumInRepeatedArray(nums,5));
    }
    
}