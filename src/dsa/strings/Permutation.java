package algo.strings;

import java.util.function.Consumer;

public class Permutation {


    public static void main(String[] args) {
        permutation("ABC","",3, System.out::println);
        System.out.println(" ===== ");

        permutationWithRepitition("ABC","",3, System.out::println);
    }


    public static void permutation(String remaining, String sofar, int length, Consumer<String> consumer) {
        if(remaining.isEmpty() || sofar.length() == length) {
            consumer.accept(sofar);
            return;
        }
        for(int i=0; i < remaining.length(); i++) {
            String ns = sofar + remaining.charAt(i);
            String nr = remaining.substring(0,i) + remaining.substring(i+1);
            permutation(nr,ns,length,consumer);
        }
    }

    public static void permutationWithRepitition(String remaining, String sofar, int length, Consumer<String> consumer) {
        if(sofar.length() == length) {
            consumer.accept(sofar);
            return;
        }
        for(int i=0; i < remaining.length(); i++) {
            String ns = sofar + remaining.charAt(i);
            //System.out.println("---> " + ns.length() + " " + remaining);
            if(ns.length() < length) {
                //System.out.println("---> " + ns + " " + remaining);
                permutationWithRepitition(remaining,ns,length,consumer);
            } else {
                String nr = remaining.substring(0,i) + remaining.substring(i+1);
                permutationWithRepitition(nr,ns,length,consumer);
            }
        }
    }

    // aaa

}
