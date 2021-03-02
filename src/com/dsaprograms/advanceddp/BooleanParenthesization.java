package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Boolean Parenthesization
1. You are given a boolean expression with symbols T,F, and operators &,|,^ , where
   T represents True
   F represents False
   & represents boolean AND
   | represents boolean OR
   ^ represents boolean XOR.
2. You have to find the number of ways in which the expression can be parenthesized so that the value of expression evaluates to true.
Sample Input
TFT
^&
Sample Output
Number of ways in which the expression can be parenthesized so that the value of expression evaluates to true: 2

Sample Input
TFTF
&|^
Sample Output
Number of ways in which the expression can be parenthesized so that the value of expression evaluates to true: 5
 */
public class BooleanParenthesization {
    public static void expressionParenthesization(String str1, String str2){
        int n = str1.length();
        int [][] dpTrue = new int[n][n];
        int [][] dpFalse = new int[n][n];

        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap==0){
                    if(str1.charAt(i)=='T')// Since i and j are same at 0th diagonal or gap we can even write str1.charAt(j)
                    {
                        dpTrue[i][j] = 1;
                        dpFalse[i][j] = 0;
                    }
                    else{
                        dpTrue[i][j] = 0;
                        dpFalse[i][j] = 1;
                    }
                }
                else{
                    for(int k=i;k<j;k++){
                        char operator = str2.charAt(k);

                        int leftTrueCount = dpTrue[i][k];
                        int rightTrueCount = dpTrue[k+1][j];

                        int leftFalseCount = dpFalse[i][k];
                        int rightFalseCount = dpFalse[k+1][j];

                        if(operator=='&'){
                            // When operator is '&' then we get true only when we have true on both left and right side.
                            dpTrue[i][j] += leftTrueCount * rightTrueCount;
                            // When operator is '&' then we get false when we have T & F, F & T, F & F
                            dpFalse[i][j] += leftTrueCount * rightFalseCount + leftFalseCount * rightFalseCount + leftFalseCount * rightTrueCount;
                        }
                        else if(operator=='|'){
                            // When operator is '|' then we get false only when we have false on both side otherwise true;
                            dpTrue[i][j] +=  leftTrueCount * rightFalseCount + leftTrueCount * rightTrueCount + leftFalseCount * rightTrueCount;
                            dpFalse[i][j] += leftFalseCount * rightFalseCount;
                        }
                        else{ // operator=='^'
                            // When operator is '^' then we get false  when we have same boolean value on both side otherwise we get true;
                            dpTrue[i][j] +=  leftTrueCount * rightFalseCount + leftFalseCount * rightTrueCount;
                            dpFalse[i][j] += leftFalseCount * rightFalseCount + leftTrueCount * rightTrueCount;
                        }
                    }
                }
            }
        }

        System.out.println("Number of ways in which the expression can be parenthesized so that the value of expression evaluates to true: "+dpTrue[0][n-1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        expressionParenthesization(str1, str2);
    }
}
