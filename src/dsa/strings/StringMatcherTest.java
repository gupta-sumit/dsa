package algo.strings;

import algo.numbers.Range;

public class StringMatcherTest {

    public static void main(String[] args) {
        StringMatcher matcher = new BoyreMooreStringMatching();
        //Range match = matcher.findFirstMatch("Sumit is going to Google", "Google");
        Range match1 = matcher.findFirstMatch("aaaaaaaaaaaaaaaeaaaaaaaaaaa", "eaaaaaaaaa");
        //System.out.println(match);
        System.out.println(match1);
    }
}
