package dsa.arrays;

public class MedianOfTwoSortedArrays {

    public Double findMedian(int [] nums1, int [] nums2) {
        int [] a = nums1.length < nums2.length ? nums1 : nums2;
        int [] b = a == nums1 ? nums2 : nums1;


        boolean even = (a.length + b.length)%2 == 0;

        int leftPartLen = (a.length + b.length + 1)/2;

        int aMin = 0;
        int aMax = a.length - 1;

        while(aMin <= aMax) {
            int aIndex = aMin + (aMax - aMin)/2;
            int bIndex = leftPartLen - (aIndex + 2);

            Integer x = aIndex >= 0 ? a[aIndex] : null;
            Integer y = bIndex >= 0 ? b[bIndex] : null;

            Integer xP = aIndex + 1 < a.length ? a[aIndex + 1] : null;
            Integer yP = bIndex + 1 < b.length ? b[bIndex + 1] : null;

            if(x != null && yP != null && x > yP) {
                aMax = aIndex - 1;
            } else if(y != null && xP != null && y > xP) {
                aMin = aIndex + 1;
            } else {
                if(!even) {
                    return (double)max(x,y);
                } else {
                    return (max(x,y) + min(xP,yP))/(double)2;
                }
            }
        }
        if(a.length != 0) {
            if(aMax < 0) {
                int leftMedian = b[leftPartLen-1];
                if(even) {
                    return leftPartLen < b.length ? (a[0] < b[leftPartLen] ? (leftMedian + a[0])/(double)2: (leftMedian
                            + b[leftPartLen])/(double)2):   (leftMedian + a[0])/(double)2;
                } else {
                    return (double)leftMedian;
                }
            } else {
                if(even) {
                    return (b[leftPartLen - a.length - 1] + b[leftPartLen - a.length])/(double)2;
                } else {
                    return (double)b[leftPartLen - a.length - 1];
                }
            }
        } else {
            if(even) {
                return (b[b.length/2-1] + b[b.length/2])/(double)2;
            } else {
                return (double)b[b.length/2];
            }
        }
    }

    private int max(Integer x, Integer y) {
        if(x != null && y != null) {
            return x > y ? x : y;
        } else if(x != null) {
            return x;
        } else {
            return y;
        }
    }

    private int min(Integer x, Integer y) {
        if(x != null && y != null) {
            return x < y ? x : y;
        } else if(x != null) {
            return x;
        } else {
            return y;
        }
    }

    public static void main(String[] args) {
        int [] nums1= new int[] {6};
        int [] nums2= new int[] {3,4,5};

        // 1 3 4 5 6 6 7 7 9 10
        // 1 3 4 5 6  11 12 15 20
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedian(nums1,nums2));
    }
}
