package com.dsaprograms.linkedlist;
import java.util.Scanner;
/*
LeetCode: 25. Reverse Nodes in k-Group
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

Follow up:

Could you solve the problem in O(1) extra memory space?
You may not alter the values in the list's nodes, only nodes itself may be changed.
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
Example 3:

Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
Example 4:

Input: head = [1], k = 1
Output: [1]
 */
public class KReverseLinkedlist {
    private static Node head;
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

    private static Node kReverseLinkedlist(Node head, int k){
        Node dummy = new Node(-1);
        dummy.next = head;
        Node begin = dummy;
        int i=0;
        while(head!=null){
            i++;
            if(i%k==0){
                begin  = reverse(begin, head.next);
                head = begin.next;
            }
            else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    private static Node reverse(Node begin, Node end){
        Node current = begin.next;
        Node first = current;
        Node prev =begin;
        Node next = null;
        while(current!=end){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        begin.next = prev;
        first.next = current;
        return first;
    }

    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int k = sc.nextInt();
        head = new Node(5);
        Node current1 = head;
        current1.next = new Node(6);
        current1 = current1.next;
        current1.next = new Node(2);
        current1 = current1.next;
        current1.next = new Node(10);
        current1 = current1.next;
        current1.next = new Node(12);
        current1 = current1.next;
        current1.next = new Node(4);
        current1 = current1.next;
        current1.next = new Node(11);
        current1 = current1.next;
        current1.next = new Node(15);
        System.out.println("Original Linkedlist:");
        printElements(head);
        System.out.println("Linkedlist after reversing with groups of K: ");
        printElements(kReverseLinkedlist(head, k));

    }
}
