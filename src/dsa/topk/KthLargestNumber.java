package dsa.topk;

public class KthLargestNumber {

    public static void main(String[] args) {
        int [] nums = new int[] {1,2,15,4,20,6,19,8,9,10};
        int k = 10;
        MinHeap minHeap = new MinHeap(k);
        for(int i=0; i < nums.length; i++) {
            if(minHeap.size() < k) {
                minHeap.add(nums[i]);
            }else {
                if(minHeap.peek() < nums[i]) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }

        System.out.println("Kth largest element = " + minHeap.peek());

    }
}
