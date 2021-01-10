package com.dsaprograms.linkedlist;
import java.util.Stack;
/*
LeetCode 445. Add Two Numbers II
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoLinkedlist2 {
    private static Node head1;
    private static Node head2;
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    private static void printElements(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    /*
    More efficient:
    Stack<Integer> s1=new Stack<Integer>();
        Stack<Integer> s2=new Stack<Integer>();

        while(l1!=null){
            s1.push(l1.data);
            l1=l1.next;
        }

        while(l2!=null){
            s2.push(l2.data);
            l2=l2.next;
        }

        int carry=0;
        Node head = null;
        while(!s1.isEmpty() || !s2.isEmpty() || carry!=0){
            int sum=carry;
            if(!s1.isEmpty())
            {
                sum+=s1.pop();
            }

            if(!s2.isEmpty())
            {
                sum+=s2.pop();
            }
            Node newNode=new Node(sum%10);
            newNode.next=head;
            head=newNode;
            carry=sum/10;
        }
        return head;
     */

    private static Node addTwoNumbers2(Node head1, Node head2){
        /*
                5262902
                  53708
               ________
                5316610
         */
        // We can do it by reversing and adding those numbers according to AddTwoLinkedlist program.
        // Here I will use 3 stacks
        Stack<Integer> stackHead1 = new Stack<Integer>();
        Stack<Integer> stackHead2 = new Stack<Integer>();
        Node result = new Node(-1);
        Node handler = result;
        while(head1!=null){
            stackHead1.add(head1.data);
            head1 = head1.next;
        }

        while(head2!=null){
            stackHead2.add(head2.data);
            head2 = head2.next;
        }
        Stack<Integer> stackResult = new Stack<Integer>();
        int carry =0;
        while(stackHead1.size()!=0 && stackHead2.size()!=0){
            int x = stackHead1.pop();
            int y = stackHead2.pop();
            int sum = carry+x+y;
            carry = sum / 10;
            stackResult.push(sum % 10);
        }
            while(stackHead1.size()!=0) {
                int val = stackHead1.pop();
                if (carry>0){
                    stackResult.push((carry +val)%10);
                    carry = (carry + val)/10;
                }
                else{
                    stackResult.push(val);
                }
            }

            while(stackHead2.size()!=0) {
                int val = stackHead2.pop();
                if (carry>0){
                    stackResult.push((carry +val)%10);
                    carry = (carry + val)/10;
                }
                else{
                    stackResult.push((carry+val)%10);
                }
            }


        while(stackResult.size()!=0){
            handler.next = new Node(stackResult.pop());
            handler = handler.next;
        }

        return result.next;
    }


    public static void main(String[] args) {
        head1 = new Node(5);
        Node current1 = head1;
        current1.next = new Node(2);
        current1 = current1.next;
        current1.next = new Node(6);
        current1 = current1.next;
        current1.next = new Node(2);
        current1 = current1.next;
        current1.next = new Node(9);
        current1 = current1.next;
        current1.next = new Node(0);
        current1 = current1.next;
        current1.next = new Node(2);

        head2 = new Node(5);
        Node current2 = head2;
        current2.next = new Node(3);
        current2 = current2.next;
        current2.next = new Node(7);
        current2 = current2.next;
        current2.next = new Node(0);
        current2 = current2.next;
        current2.next = new Node(8);

        Node result = addTwoNumbers2(head1,head2);
        System.out.print("Result of two numbers: ");
        printElements(result);
    }

}
