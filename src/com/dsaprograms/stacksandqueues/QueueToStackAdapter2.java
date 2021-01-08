package com.dsaprograms.stacksandqueues;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.*;
/* Queue to Stack Adapter - Push Efficient
1. You are required to complete the code of our QueueToStackAdapter class.
2. As data members you've two queues available - mainQ and helperQ. mainQ is to contain data and helperQ is to assist in operations. (This is cryptic - take hint from video)
3. Here is the list of functions that you are supposed to complete
     3.1. push -> Should accept new data in LIFO manner.
     3.2. pop -> Should remove and return data in LIFO manner. If not available, print
      Stack underflow" and return -1.
     3.3. top -> Should return data in LIFO manner. If not available, print "Stack
     underflow" and return -1.
     3.4. size -> Should return the number of elements available in the stack.
4. Input and Output is managed for you.

Note -> push and size should work in constant time. pop and top should work in linear time.
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
Note -> push and size should work in constant time. pop and top should work in linear time.
Sample Input
push 10
push 20
push 5
push 8
push 2
push 4
push 11
top
size
pop
top
size
pop
top
size
pop
top
size
pop
top
size
pop
top
size
pop
top
size
pop
quit
Sample Output
11
7
11
4
6
4
2
5
2
8
4
8
5
3
5
20
2
20
10
1
10
 */
public class QueueToStackAdapter2 {
    Queue < Integer > mainQ;
    Queue < Integer > helperQ;

    public QueueToStackAdapter2() {
        mainQ = new ArrayDeque< >();
        helperQ = new ArrayDeque < > ();
    }

    int size() {
        return mainQ.size();
    }

    void push(int val) {
        mainQ.add(val);
    }

    int pop() {
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }

            int val = mainQ.remove();

            while (helperQ.size() > 0) {
                mainQ.add(helperQ.remove());
            }

            return val;
        }
    }

    int top() {
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }

            int val = mainQ.remove();
            helperQ.add(val);

            while (helperQ.size() > 0) {
                mainQ.add(helperQ.remove());
            }

            return val;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        QueueToStackAdapter2 st = new QueueToStackAdapter2();

        String str = sc.nextLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            }
            str = sc.nextLine();
        }
    }
}
