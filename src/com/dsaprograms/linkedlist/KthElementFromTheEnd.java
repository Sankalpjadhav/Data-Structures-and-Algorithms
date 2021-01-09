package com.dsaprograms.linkedlist;
import java.util.Scanner;
/*
Enter the value of K: 3
Original linked-list
20 40 60 80
Kth element from the end :40
 */
public class KthElementFromTheEnd {
    static Node head;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Prints the elements
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    static int findKthElement(Node head, int k){
        // Slow and fast pointer.
        Node slow = head;
        Node fast = head;
        for(int i=0;i<k;i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of K: ");
        int k = sc.nextInt();
        KthElementFromTheEnd list = new KthElementFromTheEnd();
        list.head = new Node(20);
        list.head.next = new Node(40);
        list.head.next.next = new Node(60);
        list.head.next.next.next = new Node(80);
        System.out.println("Original linked-list");
        printList(head);
        System.out.println("Kth element from the end :"+findKthElement(head,k));
    }
}
