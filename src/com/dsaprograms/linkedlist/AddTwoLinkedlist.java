package com.dsaprograms.linkedlist;
/*
LeetCode: 2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoLinkedlist {
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

    private static Node addTwoNumbers(Node head1, Node head2){
        Node result = new Node(-1);
        Node p = head1, q = head2, handler = result;
        int carry = 0;
        while(p!=null || q!=null){
            int x = (p!=null)? p.data : 0;
            int y = (q!=null)? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            handler.next = new Node(sum % 10);
            handler = handler.next;
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }
        if(carry>0){
            handler.next = new Node(carry);
        }
        return result.next;
    }

    public static void main(String[] args) {
        head1 = new Node(5);
        Node current1 = head1;
        head2 = new Node(2);
        Node current2 = head2;
        current1.next = new Node(6);
        current1 = current1.next;
        current1.next = new Node(2);
        current1 = current1.next;
        current1.next = new Node(9);
        current1 = current1.next;
        current1.next = new Node(0);
        current1 = current1.next;
        current1.next = new Node(2);

        current2.next = new Node(2);
        current2 = current2.next;
        current2.next = new Node(9);
        current2 = current2.next;
        current2.next = new Node(0);
        current2 = current2.next;
        current2.next = new Node(2);

        Node result = addTwoNumbers(head1,head2);
        System.out.print("Result of two numbers: ");
        printElements(result);
    }
}
