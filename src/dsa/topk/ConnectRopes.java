package dsa.topk;

public class ConnectRopes {

    public static void main(String[] args) {

        int nums[] = new int[] {1,3,5,11};
        System.out.println(getTotalCost(nums));

        nums = new int[] {1, 3, 11, 5, 2};
        System.out.println(getTotalCost(nums));
    }

    private static int getTotalCost(int nums []) {
        if(nums.length == 1) {
            return nums[0];
        }

        if(nums.length == 2) {
            return nums[0] + nums[1];
        }
        MinHeap minHeap = new MinHeap(nums.length);
        for(int i=0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }
        int cost = 0;
        while(!minHeap.isEmpty()) {
            int item1 = minHeap.poll();
            if(!minHeap.isEmpty()) {
                int item2 = minHeap.poll();
                minHeap.add(item1 + item2);
                cost = cost + item1 + item2;
            } else {
                break;
            }
        }
        return cost;

    }
}
