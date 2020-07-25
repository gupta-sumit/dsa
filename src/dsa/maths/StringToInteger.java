package algo.numbers;

public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger atoI = new StringToInteger();
        System.out.println(atoI.myAtoi("-4898989"));
    }

    public int myAtoi(String str) {
        char arr[] = str.toCharArray();
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == ' ') {
                i++;
                continue;
            } else {
                break;
            }

        }

        boolean negative = false;

        if (i < arr.length) {
            if (arr[i] == '-') {
                negative = true;
                i++;
            } else if (arr[i] == '+') {
                i++;
            }
        }

        int start = -1;
        int end = -1;

        while (i < arr.length) {
            if (arr[i] >= 48 && arr[i] <= 57) {
                if (start == -1 && end == -1) {
                    start = i;
                    end = i;
                } else {
                    end = i;
                }
                i++;
                continue;
            } else {
                break;
            }

        }
        if (start == -1 || end == -1) {
            return 0;
        }
        return convertToNumber(arr, start, end, negative);

    }

    private int convertToNumber(char[] arr, int start, int end, boolean negative) {
        int i = start;
        int result = 0;
        boolean overflow = false;
        while (i <= end) {
            int digit = toDigit(arr[i]);
            int val = result*10 + digit ;
            if (val <= result) {
                overflow = true;
                break;
            }
            result = val;
            i++;
        }
        if (overflow && negative) return Integer.MIN_VALUE;
        if (overflow && !negative) return Integer.MAX_VALUE;
        if (negative) {
            return Integer.MIN_VALUE - (Integer.MAX_VALUE + result + 1);
        }
        return result;

    }

    private int toDigit(char c) {
        return  c - 48;
    }

}