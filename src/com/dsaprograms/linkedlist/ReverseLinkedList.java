package com.dsaprograms.linkedlist;
public class ReverseLinkedList {
    static Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
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

    static Node reverseLinkedList(Node node){
        Node prev_node = null;
        Node current_node = node;
        Node next_node = null;
        while (current_node != null) {
            next_node = current_node.next;
            current_node.next = prev_node;
            prev_node = current_node;
            current_node = next_node;
        }
        node = prev_node;
        return node;
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(20);
        list.head.next = new Node(40);
        list.head.next.next = new Node(60);
        list.head.next.next.next = new Node(80);
        System.out.println("Original linked-list");
        printList(head);
        System.out.println("Reversed linked-list");
        head = reverseLinkedList(head);
        printList(head);
    }
}
