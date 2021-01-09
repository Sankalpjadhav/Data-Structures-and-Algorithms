package com.dsaprograms.linkedlist;
/*
LeetCode: 328. Odd Even Linked List.
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
Example 1:
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Constraints:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
The length of the linked list is between [0, 10^4].
 */
public class OddEvenLinkedlist2 {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static void printElements(Node node){
        while(node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    public static Node getOddEvenIndexesLinkedlist(Node head){
        // Focuses on odd even position(index) not on value.
        Node odd = head;
        Node even = head.next;
        Node evenHandler = even;
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next = evenHandler;
        return head;
    }

    public static void main(String[] args) {
        head = new Node(5);
        Node current = head;
        current.next = new Node(9);
        current = current.next;
        current.next = new Node(12);
        current = current.next;
        current.next = new Node(35);
        current = current.next;
        current.next = new Node(55);
        current = current.next;
        current.next = new Node(60);
        current = current.next;
        current.next = new Node(62);
        current = current.next;
        current.next = new Node(70);
        current = current.next;
        current.next = new Node(72);
        System.out.println("Original linkedlist:");
        printElements(head);
        System.out.println("Even-Odd linkedlist:");
        printElements(getOddEvenIndexesLinkedlist(head));
    }

}
