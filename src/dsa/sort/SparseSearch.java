package algo.sort;

import java.util.Arrays;
import java.util.List;

public class SparseSearch {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("at", "", "", "", "","ball", "", "","","","","","", "car", "", "", "dad", "", "");
        System.out.println(sparseSearch(strings,0,strings.size()-1,"car"));
    }

    public static int sparseSearch(List<String> words,int start, int end, String target) {
        if(start <= end) {
            int mid = start + (end-start)/2;
            if(words.get(mid).equals(target)) {
                return mid;
            }
            if(words.get(mid).isEmpty()) {
                int leftIndex = sparseSearch(words,start,mid-1,target);
                int rightIndex = sparseSearch(words,mid+1,end,target);
                return leftIndex != -1  ? leftIndex : rightIndex;
            } else {
                if(words.get(mid).compareTo(target) >= 0) {
                    return sparseSearch(words,start,mid-1,target);
                } else {
                    return sparseSearch(words,mid+1,end,target);
                }
            }


        }
        return -1;
    }
}
