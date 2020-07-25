package algo.strings;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BalancedParanthesis {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        generateParenthesis("",set,4,0);
        System.out.println(set);
    }

    public static  void generateParenthesis(String sofar, Set<String> out, int open, int close) {
        if(open == 0 && close == 0) {
            out.add(sofar);
            return;
        }
        if(open > 0) {
            generateParenthesis(sofar + "(", out, open-1, close+1);
        }
        if(close > 0) {
            generateParenthesis(sofar + ")", out, open, close-1);
        }
    }
}
