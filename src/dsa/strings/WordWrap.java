package dsa.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordWrap {
    
    public List<String> wrapWords(String words[], int maxWidth) {

        List<String> lines = new ArrayList<>();

        StringBuilder lastLine = new StringBuilder();
        int count = 0;
        int i=0;
        while(i < words.length) {

            if(lastLine.length() == 0) {
                lastLine.append(words[i]);
                count = words[i].length();
                i++;
            } else {
                int len = count + words[i].length() + 1; 
                if(len <= maxWidth) {
                    lastLine.append(" ").append(words[i]);
                    count = len;
                    i++;
                } else {
                    lines.add(lastLine.toString());
                    lastLine = new StringBuilder();
                    count = 0;
                }
            }
        }
        if(lastLine.length() > 0) {
            lines.add(lastLine.toString());   
        }
        return lines;
    }


    public static void main(String[] args) {
        String text = "Hello India!!! How are you. I am going to google. The extra spaces includes spaces put at the end of every line except the last one. ";
        int maxWidth = 50;
        WordWrap wordWrap = new WordWrap();
        List<String> lines = wordWrap.wrapWords(text.split(" "), maxWidth);
        lines.stream().forEach(System.out::println);
    }

}