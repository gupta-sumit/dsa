package algo.strings;

public class OneEditAway {

    public static void main(String[] args) {
        System.out.println(checkIfOneEditAway("apple", "aple"));
    }

    public static boolean checkIfOneEditAway(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }
        if(Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        int i = 0, j = 0;

        int k = 1;

        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if(k == 0) {
                    return false;
                }
                if(s1.charAt(i+1) == s2.charAt(j)){
                    // deleting this ccharacter
                    i++;
                    k--;
                } else if(s1.charAt(i) == s2.charAt(j+1)) {
                    // insert
                    j++;
                    k--;
                } else if(s1.charAt(i+1) == s2.charAt(j+1)) {
                    // replacing the character in front
                    i++;
                    j++;
                    k--;
                }  else {
                    return false;
                }
            }
        }
        return true;
    }
}
