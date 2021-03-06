package com.dsaprograms.advanceddp;
import java.util.HashSet;
import java.util.Scanner;
/*
1. You are given n space-separated strings, which represents a dictionary of words.
2. You are given another string that represents a sentence.
3. You have to determine if this sentence can be segmented into a space-separated sequence of one or more dictionary words.
Sample Input
2
pep coding
pepcoding
Number of sentences possible: 1
Sentence can be segmented into a space-separated sequence of one or more dictionary words:true

 */
public class WordBreak {
    public static int wordBreak(String sentence, HashSet<String> dictionary){
        int [] dp = new int[sentence.length()];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                String substring = sentence.substring(j,i+1);
                if(dictionary.contains(substring)){
                    if(j>0){
                        dp[i] += dp[j-1];
                    }
                    else{
                        dp[i] += 1;
                    }
                }
            }
        }
        return dp[sentence.length()-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> dictionary = new HashSet<String>();
        for(int i=0;i<n;i++){
            dictionary.add(sc.next());
        }
        String sentence = sc.next();
        int result = wordBreak(sentence, dictionary);
        System.out.println("Number of sentences possible: "+result);
        System.out.println("Sentence can be segmented into a space-separated sequence of one or more dictionary words:"+(result>0));
    }
}
