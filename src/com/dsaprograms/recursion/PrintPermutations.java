package com.dsaprograms.recursion;
import java.util.Scanner;
/*
1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.
Items are numbered from 1 to ritems.
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain empty.
Sample input:
4
2
Sample output:
1200
1020
1002
2100
0120
0102
2010
0210
0012
2001
0201
0021
 */
public class PrintPermutations {
    public static void printPermutations(int [] boxes, int currentItem, int items){
        if(currentItem>items){
            for(int i=0;i<boxes.length;i++){
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }

        for(int i=0;i<boxes.length;i++){
            if(boxes[i]==0){
                boxes[i]=currentItem;
                printPermutations(boxes, currentItem+1, items);
                boxes[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nBoxes = sc.nextInt();
        int rItems = sc.nextInt();
        printPermutations(new int[nBoxes], 1, rItems);
    }
}
