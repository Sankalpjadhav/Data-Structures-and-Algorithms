package com.dsaprograms.stacksandqueues;
import java.util.Scanner;
import java.util.Stack;
/*
1. You are given an infix expression.
2. You are required to evaluate and print it's value.
Input Format
Input is managed for you
Output Format
Value of infix expression
Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.
Sample Input
2 + 6 * 4 / 8 - 3
Sample Output
2
 */
public class InfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  expr = sc.nextLine();
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i=0;i<expr.length();i++){
            char ch = expr.charAt(i);
            if(ch=='('){
                operators.push(ch);
            }
            else if(Character.isDigit(ch)){
                int value = ch -'0';
                operands.push(value);
            }
            else if(ch==')'){ // Pop all the operators and calculate their new operands till '(' is encountered. Lastly pop the opening bracket.
                while(operators.size()>0 && operators.peek()!='('){
                    performOperation(operands, operators);
                }
                if (operators.size() > 0) {// lastly pop opening bracket too.
                    operators.pop();
                }
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                // Pop until the stack is empty,
                // pop all the operators which are greater precedence than the current character precedence,
                // pop until we have '(' at the top of the stack.
                while(operators.size()>0 && operators.peek()!='(' && precedence(ch) <= precedence(operators.peek())){
                    performOperation(operands, operators);
                }
                operators.push(ch);
            }
        }
        // 2+3*6 in this situation the operators stack is not empty
        while(operators.size()>0){
            performOperation(operands, operators);
        }

        System.out.println("Infix evaluation result: "+operands.peek());
    }

    //Common code
    public static void performOperation(Stack<Integer> operands, Stack<Character> operators){
        char operator = operators.pop();
        // The value which is popped first is stored in value2 and second in value1 because we need to maintain the order ... value1 + value2
        int value2 = operands.pop();
        int value1 = operands.pop();
        int newValue = evaluation(value1,value2, operator);
        operands.push(newValue);
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

    // Evaluation
    public static int evaluation(int value1, int value2 ,char operator){
        if(operator == '+'){
            return value1 + value2;
        }
        else if(operator == '-'){
            return value1 - value2;
        }
        else if(operator == '*'){
            return value1 * value2;
        }
        else if(operator == '/'){
            return value1 / value2;
        }
        return 0;
    }
}
