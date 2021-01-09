package com.dsaprograms.linkedlist;
/* Focuses on values not on position.
Original linkedlist:
5 9 12 35 55 60 62 70 72
Odd-Even linkedlist:
12 60 62 70 72 5 9 35 55
 */
public class OddEvenLinkedlist {
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

    static Node getOddEvenLinkedlist(Node node){
        Node even = new Node(-1);
        Node handler1 = even;
        Node odd = new Node(-1);
        Node handler2 = odd;
        while(node!=null){
            if(node.data % 2==0){
                handler1.next = node;
                handler1 = handler1.next;
            }
            else{
                handler2.next = node;
                handler2 = handler2.next;
            }
            node = node.next;
        }
        handler1.next = odd.next;
        handler2.next = null;
        return even.next;
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
        printElements(getOddEvenLinkedlist(head));
    }
}
