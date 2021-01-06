package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;
/*
1. You are given an infix expression.
2. You are required to convert it to postfix and print it.
3. You are required to convert it to prefix and print it.
Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.
Sample Input
a*(b-c+d)/e
Sample Output
abc-d+*e/
/*a+-bcde
 */
public class InfixConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  expr = sc.nextLine();
        Stack<String> prefix = new Stack<>();
        Stack<Character> operators = new Stack<>();
        Stack<String> postfix = new Stack<>();
        for(int i=0;i<expr.length();i++){
            char ch = expr.charAt(i);
            if(ch == '('){
                operators.push(ch);
            }
            else if(ch == ')'){
                while(operators.size()>0 && operators.peek()!='('){
                    performOperaton(operators,prefix,postfix);
                }
                operators.pop(); // Pop opening bracket too.
            }
            else if(Character.isLetter(ch)){
                prefix.push(ch+"");
                postfix.push(ch+"");
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                while(operators.size()>0 && operators.peek()!='(' && precedence(ch)<=precedence(operators.peek())){
                    performOperaton(operators,prefix,postfix);
                }
                operators.push(ch);
            }
        }
        while(operators.size()>0){
            performOperaton(operators,prefix,postfix);
        }
        System.out.println("Prefix expression: "+prefix.peek());
        System.out.println("Postfix expression: "+postfix.peek());
    }
    //Common code
    public static void performOperaton(Stack<Character> operators,Stack<String> prefix,Stack<String> postfix){
        char operator = operators.pop();
        // for prefix calculation
        String prefixValue2 = prefix.pop();
        String prefixValue1 = prefix.pop();
        prefix.push(operator+prefixValue1+prefixValue2);
        // for postfix calculation
        String postfixValue2 = postfix.pop();
        String postfixValue1 = postfix.pop();
        postfix.push(postfixValue1+postfixValue2+operator);
    }
    // Precedence calculation
    public static int precedence(char operator){
        if(operator == '+'){
            return 1;
        }
        else if(operator == '-'){
            return 1;
        }
        else if(operator == '*'){
            return 2;
        }
        else if(operator == '/'){
            return 2;
        }
        return 0;
    }

}
