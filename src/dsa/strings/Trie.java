package algo.strings;

import algo.utils.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private Node root = null;

    public Trie() {
        root  = new Node();
    }

    public void insertWord(String w) {
        w = w.toLowerCase() + "$";
        int i=0;
        Node curr = root;
        while(i < w.length()) {
            if(w.charAt(i) == '$') {
                curr.end = true;
            } else {
                curr = curr.insertChar(w.charAt(i));
            }
            i++;
        }
    }

    public List<String> suggest(String prefix1) {
        String prefix = prefix1.toLowerCase() + "$";
        int i = 0;
        Node curr = root;
        List<String> suggests = new ArrayList<>();
        Node prev = null;
        String prevstr = "";
        while(i < prefix.length() && curr != null) {
            if(prefix.charAt(i) == '$') {
                //suggests.add(prefix.substring(0,prefix.length()-1));
                break;
            } else {
                prevstr = prevstr + prefix.charAt(i);
                prev = curr;
                curr = curr.getChild(prefix.charAt(i));
            }
            i++;
        }
        if(curr != null) {
            findAllPathstoLeave(curr,"", prefix1,suggests);
        } else if(prev != null) {
            findAllPathstoLeave(prev,"", prevstr,suggests);
        }
        return suggests;
    }

    private void findAllPathstoLeave(Node node, String sofar, String prefix1, List<String> suggests) {
        if(node != null) {
            if(node.end) {
                suggests.add(prefix1 + sofar);
            }
            for(int i=0 ; i < node.childs.length; i++) {
                if(node.childs[i] != null) {
                    findAllPathstoLeave(node.childs[i], sofar + getChar(i), prefix1, suggests);
                }
            }
        }
    }

    private char getChar(int i) {
        return (char)(97 + i);
    }

    public boolean isSubstring(String w) {
        w = w.toLowerCase() + "$";
        int i=0;
        Node curr = root;
        while(i < w.length()) {
            if(w.charAt(i) == '$' && curr.end) {
                return true;
            }
            if(curr == null) {
                break;
            }
            curr = curr.getChild(w.charAt(i));
            i++;
        }

        return false;
    }

    public static class Node {
        Node [] childs;
        boolean end;

        public Node() {
            childs = new Node[26];
        }

        public Node insertChar(char c) {
            int index = getIndex(c);
            if(childs[index] != null) {
                return childs[index];
            }
            childs[index] = new Node();
            return childs[index];
        }

        public Node getChild(char c) {
            int index = getIndex(c);
            return childs[index];
        }


        private int getIndex(char c) {
            return c - 97;
        }

        public Node [] getChilds() {
            return childs;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("Hello");
        trie.insertWord("HelloWorld");
        trie.insertWord("NewDelhi");
        trie.insertWord("NewYork");
        trie.insertWord("bangalore");
        ConsolePrinter.out(trie.suggest("neww"));
    }
}
