package dsa.arrays;

import java.util.HashMap;
import java.util.Map;

public class Sum4 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i < A.length; i++) {
            for(int j=0; j < B.length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j],0) + 1);     
            }
        }

        int totalCount = 0;
        for(int i=0; i < C.length; i++) {
            for(int j=0; j < D.length; j++) {
                int s = -(C[i] + D[j]);
                if(map.containsKey(s)) {
                    totalCount = totalCount + map.get(s);
                }     
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        Sum4 sum4 = new Sum4();
        

    }
    
}