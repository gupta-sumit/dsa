package dsa.strings;


/**
 * Base case
 *  if pattern is empty and text is also empty, there is a match
 *
 *  if text is empty, we need to check whether pattern could possibly be empty
 *      example : "", "a*b*c*" : In this case, * means 0 or more character. Which means pattern is also empty.
 *      How to check :
 *          We have to check if pattern length >= 2 and pattern second character is *, then remove first two character
 *          from pattern and recursively call same function on remaining pattern.
 *
 *  Now check for first character of both pattern and text
 *      Two case: either it matches or there is a . in the pattern. (. means any single character matched)
 *  If first character matches and  after first character there is * in the pattern,
 *      1.  there could be a chance of same character getting
 *        repeated again. So will remove first character from text and using same pattern we can recurse
 *
 *        Or
 *
 *        There is one possibility that we will fail later stage ex :
 *         text : abcdwordbca pattern: a.*cd.*bca
 *          In this case If we start matching .* with any text character it will match and text will become empty.
 *          But pattern will be remaining. So it will not match. But this is incorrect. If you see carefullly,
 *          text is matching pattern.
 *
 *          So we need to consider pattern after removing .* from pattern and recurse on same string again.
 *
 *  Else
 *
 *      if first character matches but does not have * in next character, we can simple move 1 character in pattern and in text;
 *
 *      else first chracter does not match and pattern has * in next character,
 *          remove first two char (Ex .* or a*) and recurse again on same text.
 *
 *
 *
 *
 */
public class RegularExpressionMatching {


    public boolean isMatch(String text, String pattern) {
        if(pattern.isEmpty()) {
            return text.isEmpty();
        }

        if(text.isEmpty()) {
            if(pattern.length() >= 2 && pattern.charAt(1) == '*') {
                return isMatch(text, pattern.substring(2));
            } else {
                return false;
            }
        }

        boolean firstCharMatch = text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.';

        if(firstCharMatch && pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(text.substring(1),pattern) || isMatch(text, pattern.substring(2));
        } else {
            if(firstCharMatch) {
                return isMatch(text.substring(1),pattern.substring(1));
            } else if(pattern.length() >= 2 && pattern.charAt(1) == '*') {
                return isMatch(text,pattern.substring(2));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch("abcdef","...de*"));
        System.out.println(regularExpressionMatching.isMatch("abcdef","...de."));
        System.out.println(regularExpressionMatching.isMatch("abcdwordbca","a.*cd.*bca"));
        System.out.println(regularExpressionMatching.isMatch("abcdwordbca","a.*cd.*bcy"));

    }

}
