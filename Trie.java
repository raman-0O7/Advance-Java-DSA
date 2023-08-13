//import static jdk.javadoc.internal.doclets.toolkit.util.DocFinder.search;

public class Trie
{
    static class Node {
        Node[] children;
        boolean eow;
        public Node() {
            children = new Node[26];
            eow = false;
        }
    }
    static Node root = new Node();
    public static void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length();i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) curr.children[idx] = new Node();
            if(i == word.length()-1) curr.eow = true;
            curr = curr.children[idx];
        }
    }
    public static boolean search(String word) {
        Node curr = root;
        for(int i=0; i<word.length();i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) return false;
            if(i == word.length()-1 && !curr.eow) return false;
            curr = curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any"};
        for(String word: words) {
            insert(word);
        }

        System.out.println(search("an"));
    }
}
