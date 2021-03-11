package com.dsaprograms.hashmapandheap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/*
Substrings with K distinct characters.
Input:
aabbbcca
1
Output:
13
Substrings with K distinct characters: [a, aa, a, b, bb, bbb, b, bb, b, c, cc, c, a]

Input:
abcabdabbcfa
3
Output:
19
Substrings with K distinct characters: [abc, abca, abcab, bca, bcab, cab, abd, abda, abdab, abdabb, bda, bdab, bdabb, dab, dabb, abbc, bbcf, bcf, cfa]

 */
public class SubstringsWithKDistinctChars {
    public static void removeExtraAddedChar(HashMap<Character,Integer> map, char ch){
        if(map.get(ch)==1){
            map.remove(ch);
        }
        else{
            map.put(ch,map.get(ch)-1);
        }
    }

    public static ArrayList<String> solutionForK1(String str){
        ArrayList<String> result = new ArrayList<>();
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i=-1,j=-1;
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            while(i<str.length()-1){
                flag1 = true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);
                if(map.size() > 1){ // When it becomes k+1
                    removeExtraAddedChar(map,ch);
                    i--;
                    break;
                }
            }

            while(j < i){
                flag2 = true;
                if(map.size()==1){
                    for(int k =j+1;k<=i;k++){
                        String substring = str.substring(j+1,k+1);
                        result.add(substring);
                    }
                    count += i - j;
                }
                j++;
                char ch = str.charAt(j);
                removeExtraAddedChar(map,ch);
                if(map.size()<1){ // 0
                    break;
                }
            }
            if(flag1==false && flag2==false){
                break;
            }
        }
        System.out.println(count);
        return result;
    }

    public static ArrayList<String> solution(String str, int k){
        if(k==1){
            return solutionForK1(str);
        }
        ArrayList<String> result = new ArrayList<>();
        int count = 0;
        HashMap<Character, Integer> big = new HashMap<>();
        HashMap<Character, Integer> small = new HashMap<>();
        int bigI = -1,smallI = -1;
        int j = -1;
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;

            while(bigI < str.length()-1){
                flag1 = true;
                bigI++;
                char ch = str.charAt(bigI);
                big.put(ch, big.getOrDefault(ch, 0)+1);
                if(big.size() > k){ // When it becomes k+1
                    removeExtraAddedChar(big,ch);
                    bigI--;
                    break;
                }
            }

            while(smallI < bigI){
                flag2 = true;
                smallI++;
                char ch = str.charAt(smallI);
                small.put(ch, small.getOrDefault(ch, 0)+1);
                if(small.size() > k-1){ // When it becomes k
                    removeExtraAddedChar(small,ch);
                    smallI--;
                    break;
                }
            }

            while(j < smallI){
                flag3 = true;
                j++;
                char ch = str.charAt(j);
                if(big.size()==k && small.size()==k-1){
                    for(int i = smallI+1;i<=bigI;i++){
                        String substring = str.substring(j,i+1);
                        result.add(substring);
                    }
                    count += bigI - smallI;
                }
                removeExtraAddedChar(big,ch);
                removeExtraAddedChar(small,ch);

                if(big.size()<k || small.size()<k-1){
                    break;
                }
            }

            if(flag1==false && flag2==false && flag3==false){
                break;
            }
        }
        System.out.println(count);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        System.out.println("Substrings with K distinct characters: "+solution(str, k));
    }
}
