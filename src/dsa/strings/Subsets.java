package algo.strings;

import algo.utils.ConsolePrinter;

import java.util.HashSet;
import java.util.Set;

public class Subsets {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        generateSubset("33", "", set);
        ConsolePrinter.out(set.toString());
    }

    private static void generateSubset(String remaining, String sofar, Set<String> set) {
        if(remaining.length() == 0) {
            set.add(sofar);
            return;
        }
        int c = 0;
        while(c < remaining.length() && sofar.length() > 0 && c == sofar.charAt(sofar.length()-1)) {
            c++;
        }
        if(c < remaining.length()) {
            String s = sofar + remaining.charAt(c);
            generateSubset(remaining.substring(c+1), s, set);
            generateSubset(remaining.substring(c+1), sofar, set);
        }
    }

}
