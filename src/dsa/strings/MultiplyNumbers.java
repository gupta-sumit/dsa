package algo.strings;

public class MultiplyNumbers {

    public static void main(String[] args) {
        Solution solution = new MultiplyNumbers.Solution();
        System.out.println(solution.multiply("1234567","111111111"));
    }

    public static class Solution {

        public String multiply(String A, String B) {
            int [] prev = null;
            for(int i=0; i < B.length(); i++) {
                int [] out = multiplyBySingleDigit(A, B.charAt(i), B.length()-(i+1));
                if(null == prev) {
                    prev = out;
                } else {
                    prev = doSum(prev,out);
                }
            }
            StringBuilder builder = new StringBuilder();
            boolean skipZero = true;

            for(int i=0; i < prev.length; i++) {
                if(prev[i] == 0 && skipZero) {
                    continue;
                } else {
                    builder.append(prev[i]);
                    skipZero = false;
                }

            }
            String m = builder.toString();
            return m.isEmpty() ? "0" : m;
        }

        public int [] doSum(int [] a, int [] b) {
            int len = a.length > b.length? a.length + 1 : b.length + 1;
            int [] out = new int[len];
            int i=a.length-1,j=b.length-1;
            int carry = 0;
            int m = out.length - 1;
            while(i >= 0 && j >= 0) {
                int k = a[i] + b[j] + carry;
                out[m--] = k%10;
                carry = k/10;
                i--;
                j--;
            }
            // System.out.println("==== " + Arrays.toString(out));
            if(i >=0 ) {
                while(i>=0) {
                    int k = a[i] + carry;
                    out[m--] = (k%10);
                    carry = k/10;
                    i--;
                }
            }

            //System.out.println("==== 1 " + Arrays.toString(out));
            if(j >= 0) {
                while(j>=0) {
                    int k = b[j] + carry;
                    out[m--] = k%10;
                    carry = k/10;
                    j--;
                }
            }
            if(carry != 0) {
                out[m] = carry;
            }
            //System.out.println(Arrays.toString(out));
            return out;
        }


        public int getDigit(char c) {
            return c - 48;
        }


        public int [] multiplyBySingleDigit(String A, char c, int baseLength) {
            int digit = getDigit(c);
            int len = A.length() + baseLength + 1;
            int [] out = new int[len];
            int k = len - 1;
            while(baseLength > 0) {
                out[k--] = 0;
                baseLength--;
            }
            int carry = 0;
            for(int i=A.length()-1; i >= 0; i--) {
                int v = (getDigit(A.charAt(i))*digit) + carry;
                carry = v/10;
                out[k--] =  v%10;
            }
            if(carry != 0) {
                out[k] = carry;
            }
            //System.out.println(Arrays.toString(out));
            return out;
        }
    }

}
