package algo.array;

import java.util.Optional;

public class SearchInSortedMatrix {

    public static void main(String[] args) {
        int[][] m = {
                {15,19,45,85},{20,35,80,95},{30,55,95,105},{40,80,104,120}
        };
        System.out.println(search(m,40));
     }


    public static Optional<Location> search(int [][] nums, int target) {
        int row = nums.length;
        int col = nums[0].length;
        int i=0, j = 0, m = row-1, n = col-1;
        while(true) {
            n = findRow(nums,j,n,target,i);
            if(n < 0) {
                return Optional.empty();
            }
            if(nums[i][n] == target) {
                return Optional.of(new Location(i,n));
            } else {
                i = findColumn(nums,i,m,target,n);
                if(i < 0) {
                    return Optional.empty();
                }
                if(nums[i][n] == target) {
                    return Optional.of(new Location(i,n));
                }
            }
            if( i < 0 || n < 0) {
                return Optional.empty();
            }
        }
    }

    public static int findRow(int [][] nums, int start, int end, int target, int row)  {
        if(start <= end) {
            int mid = start + (end-start)/2;
            if(nums[row][mid] == target) {
                return mid;
            } else {
                int index = -1;
                if(nums[row][mid] > target) {
                    index = findRow(nums,start,mid-1,target,row);

                } else {
                    index = findRow(nums,mid+1,end,target,row);

                }
                if(index == -1) {
                    return nums[row][mid] <= target ? mid : -1;
                } else {
                    return index;
                }
            }
        }
        return -1;
    }

    public static int findColumn(int [][] nums, int start, int end, int target, int col)  {
        if(start <= end) {
            int mid = start + (end-start)/2;
            if(nums[mid][col] == target) {
                return mid;
            } else {
                int index = -1;
                if(nums[mid][col] > target) {
                    index = findColumn(nums,start,mid-1,target,col);

                } else {
                    index = findColumn(nums,mid+1,end,target,col);

                }
                if(index == -1) {
                    return nums[mid][col] >= target ? mid : -1;
                }
                return index;
            }
        }
        return -1;
    }


    static class Location {
        int i;
        int j;

        public Location(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }


}
