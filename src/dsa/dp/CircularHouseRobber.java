package algo.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CircularHouseRobber {

    public static void main(String[] args) {
        CircularHouseRobber robber = new CircularHouseRobber();
        int [] nums = new int[]{2,1,1,2};
        System.out.println(robber.rob(nums));
    }

    public int rob(int[] nums) {
        Map<Integer,ValueHolder> map = new HashMap<>();
        int v = maxMoney(nums,0,map);
        int i=0;
        while(i < nums.length) {
            ValueHolder valueHolder = map.get(i);
            if (valueHolder.currentIndex != -1) {
                System.out.print(valueHolder.currentIndex + " ");
            }
            i = valueHolder.index;
        }
        return map.get(0).sum;
    }

    private int maxMoney(int nums [], int i, Map<Integer, ValueHolder> memo) {

        if(memo.containsKey(i)) {
            return memo.get(i).sum;
        }
        if(i >= nums.length) {
            return 0;
        }
        if(i == nums.length-1) {
            memo.put(i, new ValueHolder(nums[i], i+1,i));
            return nums[i];
        }
        int a = nums[i] + maxMoney(nums, i+2,memo);
        int b = maxMoney(nums, i+1,memo);
        if(a > b) {
            memo.put(i, new ValueHolder(a,i+2,i));
            if(i == 0) {
                int k=0;
                while(k < nums.length) {
                    ValueHolder valueHolder = memo.get(k);
                    if (valueHolder.currentIndex != -1) {
                        if(k == nums.length -1 && valueHolder.currentIndex == k) {
                            if(valueHolder.sum >= nums[0]) {
                                memo.get(0).currentIndex = -1;
                                memo.get(0).sum = memo.get(0).sum - nums[0];
                            }
                        }
                        //System.out.print(valueHolder.currentIndex + " ");
                    }
                    k = valueHolder.index;
                }
            }
            return a;
        } else {
            memo.put(i, new ValueHolder(b,i+1,-1));
            return b;
        }
    }

    private static class ValueHolder {

        private int sum;
        private int index;
        private int currentIndex;

        public ValueHolder(int sum, int index, int currentIndex) {
            this.sum = sum;
            this.index = index;
            this.currentIndex = currentIndex;
        }
    }
}
