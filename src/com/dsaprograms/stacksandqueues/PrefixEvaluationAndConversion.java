package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;
/*  Prefix Evaluation And Conversions
1. You are given a prefix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to postfix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
Output Format
value, a number
infix
prefix
Constraints
1. Expression is a valid prefix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.
Sample Input
-+2/*6483
Sample Output
2
((2+((6*4)/8))-3)
264*8/+3-
 */
public class PrefixEvaluationAndConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        Stack<Integer> evaluation = new Stack<>();
        Stack<String> infix = new Stack<>();// Use brackets for indicating precedence.
        Stack<String> postfix = new Stack<>();

        // traverse in reverse direction because for prefix expression we have operators at start.
        for(int i=expr.length()-1;i>=0;i--){
            char ch = expr.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                //Evaluation
                int value1 = evaluation.pop();     // Since  we are traversing from right first pop will be stored in value1
                int value2 = evaluation.pop();
                int value = evaluate(value1,value2,ch);
                evaluation.push(value);

                //Infix
                String infixVa1 = infix.pop();
                String infixVal2 = infix.pop();
                infix.push("("+infixVa1+ch+infixVal2+")");
                //Postfix
                String postfixVa1 = postfix.pop();
                String postfixVal2 = postfix.pop();
                postfix.push(postfixVa1+postfixVal2+ch);
            }
            else{ // Operand
                evaluation.push(ch-'0');// Converted to int
                infix.push(ch+"");
                postfix.push(ch+"");
            }
        }
        System.out.println("Evaluation result: "+evaluation.peek());
        System.out.println("Infix expression: "+infix.peek());
        System.out.println("Postfix expression: "+postfix.peek());
    }

    public static int evaluate(int value1, int value2, char ch){
        if(ch=='+'){
            return value1+value2;
        }else if(ch=='-'){
            return value1-value2;
        }else if(ch=='*'){
            return value1*value2;
        }else{ // ch=='/'
            return value1/value2;
        }
    }
}
