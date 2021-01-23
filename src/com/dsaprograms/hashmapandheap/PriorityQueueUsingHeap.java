package com.dsaprograms.hashmapandheap;
import java.util.Scanner;
import java.util.ArrayList;
/*
1. You are required to complete the code of our Priority Queue class using the heap data structure. Please watch the question video carefully.
The theoretical details of required functionality is explained in detail there. Implement the functions.
2. Here is the list of functions that you are supposed to complete:
    2.1. add -> Should accept new data.
    2.2. remove -> Should remove and return smallest value, if available or print
     "Underflow" otherwise and return -1.
     2.3. peek -> Should return smallest value, if available or print "Underflow"
     otherwise and return -1.
     2.4. size -> Should return the number of elements available.

Sample Input:
add 10
add 20
add 30
add 40
peek
add 50
peek
remove
peek
remove
peek
remove
peek
remove
peek
quit
Sample Output:
10
10
10
20
20
30
30
40
40
50
Formula to find :
 leftChild(i) = 2*parent(i) + 1;
 rightChild(i) = 2*parent(i) + 2;
 parent(i) = (anyChild(i) - 1)/2; anyChild(i) can be leftChild(i) or rightChild(i)

 Rules to be followed:
 Higher order property: Parent should have higher property than child.
 Complete binary tree: (level - 1) should be filled and to enter the value, it should be done from left side.
 */

public class PriorityQueueUsingHeap {
    public static class PriorityQueue {
        ArrayList< Integer > data;

        public PriorityQueue() {
            data = new ArrayList < > ();
        }

        public void add(int val) {
            // write your code here
            data.add(val);
            upHeapify(data.size()-1);
        }

        public void upHeapify(int childIndex){
            if(childIndex==0){
                return;
            }
            int parentIndex = (childIndex - 1)/2;
            if(data.get(childIndex)<data.get(parentIndex)){
                swap(childIndex,parentIndex);
                upHeapify(parentIndex);
            }
        }

        public void swap(int i, int j){
            int value1 =  data.get(i);
            int value2 =  data.get(j);
            data.set(i,value2);
            data.set(j,value1);
        }

        public int remove() {
            // write your code here
            if(this.size()==0){
                System.out.println("Underflow.");
                return -1;
            }
            swap(0,data.size()-1);
            int value = data.remove(data.size()-1);
            downHeapify(0);
            return value;
        }

        public void downHeapify(int parentIndex){
            int minimum = parentIndex;
            int leftChildIndex = 2 * parentIndex + 1;
            if(leftChildIndex<data.size() && data.get(leftChildIndex)<data.get(minimum)){
                minimum = leftChildIndex;
            }

            int rightChildIndex = 2 * parentIndex + 2;
            if(rightChildIndex<data.size() && data.get(rightChildIndex)<data.get(minimum)){
                minimum = rightChildIndex;
            }

            if(minimum != parentIndex){
                swap(minimum,parentIndex);
                downHeapify(minimum);
            }
        }

        public int peek() {
            // write your code here
            return data.get(0);
        }

        public int size() {
            // write your code here
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PriorityQueue qu = new PriorityQueue();
        String str = sc.nextLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str =sc.nextLine();
        }
    }
}
