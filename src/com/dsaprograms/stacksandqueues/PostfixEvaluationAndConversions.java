package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;

/*
1. You are given a postfix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to prefix and print it.
Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
1. Expression is a valid postfix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.
Sample Input
264*8/+3-
Sample Output
2
((2+((6*4)/8))-3)
-+2/*6483
 */
public class PostfixEvaluationAndConversions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        Stack<Integer> evaluation = new Stack<>();
        Stack<String> infix = new Stack<>();// Use brackets for indicating precedence.
        Stack<String> prefix = new Stack<>();

        for(int i=0;i<expr.length();i++){
            char ch = expr.charAt(i);
            if(Character.isDigit(ch)){
                evaluation.push(Integer.parseInt(ch+""));
                infix.push(ch+"");
                prefix.push(ch+"");
            }else if(ch == '+' || ch == '-' || ch=='*' || ch=='/') {
                // for evaluation
                //while (evaluation.size() > 0 && infix.size()>0 && prefix.size()>0) {
                    int value2 = evaluation.pop();
                    int value1 = evaluation.pop();
                    int value = calculateEvaluation(value1, value2, ch);
                    evaluation.push(value);

                    // for infix
                    String infixValue2 = infix.pop();
                    String infixValue1 = infix.pop();
                    infix.push("(" + infixValue1 +ch+ infixValue2 + ")");

                    //for prefix
                    String prefixValue2 = prefix.pop();
                    String prefixValue1 = prefix.pop();
                    prefix.push(ch + prefixValue1 + prefixValue2);
                }
            //}
        }

        System.out.println("Evaluation of postfix expression: "+evaluation.peek());
        System.out.println("Infix conversion: "+infix.peek());
        System.out.println("Prefix conversion: "+prefix.peek());
    }

    public static int calculateEvaluation(int value1, int value2, char ch){
        if(ch=='+'){
            return value1 + value2;
        }else if(ch=='-'){
            return value1 - value2;
        }else if(ch=='*'){
            return value1 * value2;
        }else if(ch=='/'){
            return value1 / value2;
        }
        return 0;
    }
}
