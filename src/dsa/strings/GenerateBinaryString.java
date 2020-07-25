package algo.strings;

public class GenerateBinaryString {

    public static void main(String[] args) {
        generate("",10);
    }

    public static void generate(String sofar, int n) {
        if(n == 0) {
            System.out.println(sofar);
            return;
        }
        String sofar1 = sofar + "0";
        generate(sofar1,n-1);
        String sofar2 = sofar + "1";
        generate(sofar2,n-1);
    }
}
