package com.dsaprograms.recursion;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/*
1. You are given a string and a pattern.
2. You've to check if the string is of the same structure as pattern without using any regular
     expressions.
Sample Input
graphtreesgraph
pep
Sample Output
p -> graph
e -> trees
Sample Input
goodbadmangood
abca
Sample Output:
a->good
b->b
c->adman

a->good
b->ba
c->dman

a->good
b->bad
c->man

a->good
b->badm
c->an

a->good
b->badma
c->n

 */
public class WordPatternMatching {
    public static void wordPatternMatching(String str, String pattern, HashMap<Character, String> map, String originalPattern){

        if(pattern.length()==0){
            if(str.length()==0){
                HashSet<Character> set = new HashSet<Character>();
                for(int i=0;i<originalPattern.length();i++){
                    char ch = originalPattern.charAt(i);
                    if(set.contains(ch)==false){
                        System.out.print(ch+"->"+map.get(ch)+" ");
                        set.add(ch);
                    }
                    System.out.println();
                }
            }
            return;
        }

        char ch = pattern.charAt(0);
        String restOfPattern = pattern.substring(1);
        if(map.containsKey(ch)){
            String previousMapping = map.get(ch);
            if(str.length()>=previousMapping.length()){
                String left = str.substring(0,previousMapping.length());
                String right = str.substring(previousMapping.length());
                if(previousMapping.equals(left)){
                    wordPatternMatching(right, restOfPattern, map, originalPattern);
                }
            }
        }
        else{// We need to map each character in pattern to string
            for(int i=0;i<str.length();i++){
                String leftString = str.substring(0,i+1);
                String rightString = str.substring(i+1);
                map.put(ch, leftString);
                wordPatternMatching(rightString, restOfPattern, map, originalPattern);
                map.remove(ch);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        String pattern = sc.nextLine();
        HashMap<Character, String> map = new HashMap<>();
        wordPatternMatching(str, pattern, map, pattern);
    }
}
