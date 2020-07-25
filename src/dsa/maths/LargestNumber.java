package algo.numbers;

import algo.utils.Assert;

import static algo.utils.ConsolePrinter.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {
        //test1();
        test2();
    }

    private static void test2() {
        int nums [] = new int[]{2313,2};
        String s = largestNumber(nums);
        out(s);
        //Assert.compare(largestNumber(nums),"98909827968595339456944893859149094902689398937839883538183810810780707982784676057536747174237321720571007032685668066758674466986636554651163276306626562416221603859725909578457125682552954605422520849804812479847044453428339323905384638363699366436503636357535673516346233993298316330843021297028227452732697246523622362231322812216213206020001921763154815181495141713801147114310901048");
    }

    private static void test1() {
        int nums [] = new int[]{4704,6306,9385,7536,3462,4798,5422,5529,8070,6241,9094,7846,663,6221,216,6758,8353,3650,3836,8183,3516,5909,6744,1548,5712,2281,3664,7100,6698,7321,4980,8937,3163,5784,3298,9890,1090,7605,1380,1147,1495,3699,9448,5208,9456,3846,3567,6856,2000,3575,7205,2697,5972,7471,1763,1143,1417,6038,2313,6554,9026,8107,9827,7982,9685,3905,8939,1048,282,7423,6327,2970,4453,5460,3399,9533,914,3932,192,3084,6806,273,4283,2060,5682,2,2362,4812,7032,810,2465,6511,213,2362,3021,2745,3636,6265,1518,8398};
        String s = largestNumber(nums);
        out(s);
        Assert.compare(largestNumber(nums),"98909827968595339456944893859149094902689398937839883538183810810780707982784676057536747174237321720571007032685668066758674466986636554651163276306626562416221603859725909578457125682552954605422520849804812479847044453428339323905384638363699366436503636357535673516346233993298316330843021297028227452732697246523622362231322812216213206020001921763154815181495141713801147114310901048");
    }

    public static String largestNumber(int[] nums) {
        if(nums.length == 0) {
            return "0";
        }
        List<Integer> numList = new ArrayList<>(nums.length);
        for(int i=0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        Collections.sort(numList, new Comparator<Integer>() {

            public int compare(Integer i1, Integer i2) {
                String i1s = i1.toString();
                String i2s = i2.toString();
                int i=0,j=0;
                int max = 0;
                while(i < i1s.length() || j < i2s.length()) {

                    if(i < i1s.length() && j < i2s.length() && i1s.charAt(i) == i2s.charAt(j)) {

                        max = i1s.charAt(i) > i1s.charAt(max) ? i : max;
                        i++;
                        j++;
                    } else {
                        if(i < i1s.length() && j < i2s.length()){
                            if(i1s.charAt(i) > i2s.charAt(j)) {
                                return 1;
                            } else {
                                return -1;
                            }
                        }



                        if(j < i2s.length() ) {
                            while(j < i2s.length() && i2s.charAt(j) == i2s.charAt(max)) {
                                j++;
                                continue;
                            }
                            if(j == i2s.length()) {
                                return -1;
                            }
                            if(i2s.charAt(j) < i2s.charAt(max)) {
                                return 1;
                            } else {
                                return -1;
                            }
                        }

                        if(i < i1s.length() ) {
                            while(i < i1s.length() && i1s.charAt(i) == i1s.charAt(max)) {
                                i++;
                                continue;
                            }
                            if(i == i1s.length()) {
                                return 1;
                            }
                            if(i1s.charAt(i) < i1s.charAt(max)) {
                                return -1;
                            } else {
                                return 1;
                            }
                        }

                    }

                }
                return 0;
            }

        });
        System.out.println(numList);
        if(numList.get(numList.size()-1) == 0) {
            return "0";
        }
        StringBuilder number = new StringBuilder();

        //numList.forEach(number::append);
        for(int i=numList.size()-1; i >= 0; i--) {
            number.append(numList.get(i));
        }
        return number.toString();
    }


}
