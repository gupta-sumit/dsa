package dsa.arrays;

public class SearchInSortedRotatedArray {

    public int findElementIndex(int [] nums, int val) {
        // case 1: Rotation point on left
         
        // 12 13 14 1 2 3 4 5 6 7 8 9 10
        // 11 12 13 14 15 16 17 1 2 3
        /*
        
        
        if(val == nums[mid]) {return mid}
        if(val < nums[mid]) {
            if(val >= nums[start] || nums[mid] < nums[start]) {
                // go left
            } else {
                // go right
            }
        } else {
            if(val <= nums[end] || nums[mid] > nums[end]) {
                // go right
            } else {
                // go left
            }
        }

        */
        // case 2: Rotation point in right


        
        // 10 11 12 34 14 3
        // mid = start + (end - start)/2;

        // if(val < nums[mid] && (val >= nums[start] || val < nums[start])) go left

        // if(val < nums[mid]

        if(nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        int index = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(val == nums[mid]) {
                index = mid;
                break;
            } else if(val < nums[mid]) {
                if(val >= nums[start] || nums[mid] < nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(val <= nums[end] || nums[mid] > nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return index;
    }


    

    public static void main(String [] args) {
        SearchInSortedRotatedArray searchInSortedRotatedArray = new SearchInSortedRotatedArray();
        int nums[] = new int[] {1,2,3,4,5,6,7}; 
        System.out.println(searchInSortedRotatedArray.findElementIndex(nums, 5));

        nums = new int[] {10,11,12,14,15,16,17,18,20,1,2,3,4,5,6,7}; 

        System.out.println(searchInSortedRotatedArray.findElementIndex(nums, 14));

        nums = new int[] {10,11,12,14,15,16,17,18,20,1,2,3,4,5,6,7}; 

        System.out.println(searchInSortedRotatedArray.findElementIndex(nums, 7));

        nums = new int[] {10,10,10,14,15,16,17,18,20,1,2,3,4,5,6,7}; 

        System.out.println(searchInSortedRotatedArray.findElementIndex(nums, 10));

        nums = new int[] {3,5,6,3,3,3}; 

        System.out.println(searchInSortedRotatedArray.findElementIndex(nums, 5));

    }

    /*

        3 4 1 1 
    */


}
