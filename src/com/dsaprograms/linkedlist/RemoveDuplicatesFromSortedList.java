package com.dsaprograms.linkedlist;
/*

 */
public class RemoveDuplicatesFromSortedList {
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

    public static Node removeDuplicates(Node head){
            Node newNode = new Node(-1);
            Node handler = newNode;
            if(head!=null){ // Add first element to the newNode.
                handler.next = head;
                handler = handler.next;
                head = head.next;
            }
            while(head!=null){
                if(handler.data!= head.data){
                    handler.next = head;
                    handler = handler.next;
                }
                head = head.next;
            }
            handler.next=null; // Make the handler point to null otherwise last element is repeated.
            return newNode.next;
    }

    public static void main(String[] args) {
        head = new Node(5);
        Node current1 = head;
        current1.next = new Node(5);
        current1 = current1.next;
        current1.next = new Node(7);
        current1 = current1.next;
        current1.next = new Node(10);
        current1 = current1.next;
        current1.next = new Node(10);
        current1 = current1.next;
        current1.next = new Node(10);
        current1 = current1.next;
        current1.next = new Node(12);
        current1 = current1.next;
        current1.next = new Node(12);
        System.out.println("Linkedlist:");
        printElements(head);
        System.out.println("Linkedlist after removing duplicates:");
        Node result = removeDuplicates(head);
        printElements(result);
    }
}
