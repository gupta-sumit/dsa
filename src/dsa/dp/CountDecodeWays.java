package algo.dp;

import java.util.HashMap;
import java.util.Map;

public class CountDecodeWays {

    public static void main(String[] args) {
        CountDecodeWays ways = new CountDecodeWays();
        System.out.println(ways.numDecodings("12"));
    }

    public int numDecodings(String s) {

        // 1234
        // 123
        return countWays(s, new HashMap<>());
    }

    private int countWays(String remaining, Map<String,Integer> map) {
        if(map.containsKey(remaining)) {
            return map.get(remaining);
        }
        if(remaining.length() == 1) {
            if(remaining.charAt(0) == '0') {
                return 0;
            } else {
                return Integer.parseInt(remaining);
            }
        }
        int totalWays = 0;
        for(int i =0; i < remaining.length(); i++) {
            int number = Integer.parseInt(remaining.substring(0,i+1));
            if(number <= 26 && number > 0) {
                totalWays = totalWays + 1;
            }
            if(i + 1 < remaining.length()) {
                totalWays = totalWays + countWays(remaining.substring(i+1),map);
            }

        }
        map.put(remaining,totalWays);
        return totalWays;
    }
}
