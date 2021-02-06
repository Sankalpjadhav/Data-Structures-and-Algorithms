package com.dsaprograms.recursion;
import java.util.Scanner;
/*
1. You are given an integer n, which represents n friends numbered from 1 to n.
2. Each one can remain single or can pair up with some other friend.
3. You have to print all the configurations in which friends can remain single or can be paired up.
Sample Input
3
Sample Output
(1) (2) (3)
(1) (2,3)
(1,2) (3)
(1,3) (2)
 */
public class FriendsPairing {
    public static void pairing(int person, int numberOfFriends, boolean [] used, String pathSoFar){
        if(person>numberOfFriends){
            System.out.println(pathSoFar);
            return;
        }
        if(used[person]==true){
            pairing(person+1, numberOfFriends, used, pathSoFar);
        }
        else{
            used[person]=true;
            pairing(person+1, numberOfFriends, used, pathSoFar+"("+person+")");
            for(int others=person+1;others<=numberOfFriends;others++){
                if(used[others]==false){
                    used[others]=true;
                    pairing(person+1, numberOfFriends, used, pathSoFar+"("+person+others+")");
                    used[others]=false;
                }
            }
            used[person]=false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean [] used = new boolean[n+1];
        pairing(1, n, used, "");
    }
}
