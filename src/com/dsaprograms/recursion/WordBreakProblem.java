package com.dsaprograms.recursion;
import java.util.HashSet;
import java.util.Scanner;
/*
1. You are given n space separated strings, which represents a dictionary of words.
2. You are given another string which represents a sentence.
3. You have to print all possible sentences from the string, such that words of the sentence are
     present in dictionary.
Constraints
1 <= number of words <= 10
1 <= length of each word <= 15
1 <= length of sentence <= 1000
Sample Input
11
i like pep coding pepper eating mango man go in pepcoding
ilikepeppereatingmangoinpepcoding
Sample Output
i like pepper eating man go in pep coding
i like pepper eating man go in pepcoding
i like pepper eating mango in pep coding
i like pepper eating mango in pepcoding
 */
public class WordBreakProblem {

    public static void wordBreak(String sentence, String answerSoFar, HashSet<String> dictionary){
        if(sentence.length() == 0){
            System.out.println(answerSoFar);
            return;
        }
        for(int i=0;i<sentence.length();i++){
            String leftString = sentence.substring(0,i+1);
            String remainingString = sentence.substring(i+1);
            if(dictionary.contains(leftString)){
                wordBreak(remainingString, answerSoFar+leftString+" ", dictionary);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> dictionary = new HashSet<>();
        for(int i=0;i<n;i++){
            dictionary.add(sc.next());
        }
        sc.nextLine();
        String sentence = sc.nextLine();
        wordBreak(sentence, "", dictionary);
    }
}
