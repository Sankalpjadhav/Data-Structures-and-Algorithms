package com.dsaprograms.recursion;
import java.util.Scanner;

public class LeetCodeVerbalArithmeticPuzzle {

    static boolean canBeSolved = false;

    public static int getNum(String str, int [] map){
        String strResult = "";
        for(int i=0;i<str.length();i++){
            strResult += map[(int)str.charAt(i)];
        }
        return Integer.parseInt(strResult);
    }

    public static boolean solvePuzzle(String[] words, String result, int [] map, String uniqueCharacters, int index, boolean [] uniqueNumbers){

        if(index==uniqueCharacters.length()){
            int addedNumbers=0;
            for(String str:words){
                addedNumbers += getNum(str, map);
            }
            int resultNumber = getNum(result, map);
            if(addedNumbers==resultNumber){
                canBeSolved = true;
                return true;
            }
            return false;
        }

        char ch = uniqueCharacters.charAt(index);
        for(int i=0;i<10;i++){
            if(uniqueNumbers[i]==false){
                map[(int)ch]=i;
                uniqueNumbers[i]=true;
                boolean answer = solvePuzzle(words,  result, map, uniqueCharacters, index+1, uniqueNumbers);
                if(answer==true){
                    break;
                }
                uniqueNumbers[i]=false;
                map[(int)ch]=-1;

            }
        }
        return false;
    }

    public static boolean isSolvable(String[] words, String result) {
        int [] map = new int[91];
        String uniqueCharacters = "";
        for(String str:words){
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                int ascii = (int)ch;
                if(map[ascii]==0){
                    map[ascii]=-1;
                    uniqueCharacters += ch;
                }
            }
        }
        for(int i=0;i<result.length();i++){
            char ch = result.charAt(i);
            if(map[(int)ch]==0){
                map[(int)ch]=-1;
                uniqueCharacters += ch;
            }
        }
        boolean [] uniqueNumbers = new boolean[10];
        boolean ans = solvePuzzle(words, result, map, uniqueCharacters, 0, uniqueNumbers);
        return canBeSolved;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String result = sc.nextLine();
        int n = sc.nextInt();
        String [] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = sc.next();
        }
        System.out.println(isSolvable(words, result));
    }
}
