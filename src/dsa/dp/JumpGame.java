package algo.dp;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

    public static void main(String[] args) {
        JumpGame game = new JumpGame();
        int [] nums = new int[] {50000,4,3,2,1,0,0,0,0,8};
        System.out.println(game.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        return canJump(nums,0,new HashMap<>());
    }


    private boolean canJump(int [] nums, int i, Map<Integer, Boolean> map) {
        if(map.containsKey(i)) {
            return map.get(i);
        }
        if(nums.length == 1 || (nums.length - 1 <= i)) {
            map.put(i,true);
            return true;
        }
        if(nums[i] == 0) {
            map.put(i,false);
            return false;
        }
        boolean canJump = false;
        System.out.println("Checking foor index " + i);
        for(int k = nums[i]; k >= 1; k--) {
            canJump = canJump(nums,i + k, map);
            if(canJump) {
                break;
            }
        }
        map.put(i,canJump);
        return canJump;
    }

}
