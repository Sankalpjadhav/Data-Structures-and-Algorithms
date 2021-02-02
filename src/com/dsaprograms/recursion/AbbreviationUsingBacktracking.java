package com.dsaprograms.recursion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
1. You are given a word.
2. You have to generate all abbreviations of that word.
Using recursion
Constraints
1 <= length of string <= 32
Sample Input
pep
Sample Output
pep
pe1
p1p
p2
1ep
1e1
2p
3
*/
public class AbbreviationUsingBacktracking {

    static void printAbbreviation(String str, String answerSoFar, int count, int position){
        if(position==str.length()){
            if(count == 0){
                System.out.println(answerSoFar);
            }
            else{
                System.out.println(answerSoFar+count);
            }
            return;
        }
        if(count>0){
            printAbbreviation(str, answerSoFar+count+str.charAt(position), 0, position+1);// include character.
        }
        else{
            printAbbreviation(str, answerSoFar+str.charAt(position), 0, position+1);// include character.
        }
        printAbbreviation(str, answerSoFar, count+1, position+1);// exclude character.

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        printAbbreviation(str, "", 0, 0);
    }
}
