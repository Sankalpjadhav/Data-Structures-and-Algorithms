package com.dsaprograms.linkedlist;
/*
Elements of the linkedlist:
10 20 30 40 50 60
Middle element of the linkedlist is: 30

Elements of the linkedlist:
10 20 30 40 50
Middle element of the linkedlist is: 30
 */
public class MiddleElemOfLinkedlist {
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

    static int findMiddleElement(Node node){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        head = new Node(10);
        Node current = head;
        current.next = new Node(20);
        current = current.next;
        current.next = new Node(30);
        current = current.next;
        current.next = new Node(40);
        current = current.next;
        current.next = new Node(50);
        current = current.next;
        current.next = new Node(60);
        System.out.println("Elements of the linkedlist:");
        printElements(head);
        System.out.println("Middle element of the linkedlist is: "+findMiddleElement(head));
    }
}
