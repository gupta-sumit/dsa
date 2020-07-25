package dsa.dp;

public class LongestIncreasingSubsequence {

    // 3 5 4 2
    public int lisLength(int nums[]) {
        int dp[] = new int[nums.length];
        //int starts[] = new int[nums.length];

        dp[0] = 1;
        //starts[0] = 0;

        int maxLen = 1;
        for(int i=1; i < nums.length; i++) {
            int max = 1;
            for(int j=0; j  < i; j++) {
                if(nums[i] >= nums[j]) {
                    int len = dp[j] + 1;
                    if(len > max) {
                        max = len;
                    }
                }
            }
            dp[i] =  max;
            if(max > maxLen) {
                maxLen = max;
            }
        }
        return maxLen; 
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int [] nums = new int[] {10,3,5,4,5,6,9,1000};

        // 1000 3 5 4
        // 3 5 4 2
        System.out.println(lis.lisLength(nums));
    }
    
}