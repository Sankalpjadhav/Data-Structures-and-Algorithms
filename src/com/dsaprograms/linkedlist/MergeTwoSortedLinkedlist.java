package com.dsaprograms.linkedlist;
/*
Linkedlist 1:
10 20 30 40 50 60
Linkedlist 2:
7 9 12 35 55 60 62 70 72
Resultant Linkedlist:
7 9 10 12 20 30 35 40 50 55 60 60 62 70 72
 */
public class MergeTwoSortedLinkedlist {
    static Node head1;
    static Node head2;
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

    static Node mergeTwoLinkedList(Node l1, Node l2){
        Node head=new Node(0);
        Node handler=head;
        while(l1!=null && l2!=null){
            if(l1.data<=l2.data){
                handler.next=l1;
                l1=l1.next;
            }
            else{
                handler.next=l2;
                l2=l2.next;
            }
            handler=handler.next;
        }
        if(l1==null){
            handler.next=l2;
        }
        else{
            handler.next=l1;
        }
        return head.next;
    }

    public static void main(String[] args) {
        head1 = new Node(10);
        Node current1 = head1;
        current1.next = new Node(20);
        current1 = current1.next;
        current1.next = new Node(30);
        current1 = current1.next;
        current1.next = new Node(40);
        current1 = current1.next;
        current1.next = new Node(50);
        current1 = current1.next;
        current1.next = new Node(60);
        System.out.println("Linkedlist 1:");
        printElements(head1);
        head2 = new Node(7);
        Node current2 = head2;
        current2.next = new Node(9);
        current2 = current2.next;
        current2.next = new Node(12);
        current2 = current2.next;
        current2.next = new Node(35);
        current2 = current2.next;
        current2.next = new Node(55);
        current2 = current2.next;
        current2.next = new Node(60);
        current2 = current2.next;
        current2.next = new Node(62);
        current2 = current2.next;
        current2.next = new Node(70);
        current2 = current2.next;
        current2.next = new Node(72);
        System.out.println("Linkedlist 2:");
        printElements(head2);

        Node result = mergeTwoLinkedList(head1,head2);
        System.out.println("Resultant Linkedlist:");
        printElements(result);
    }
}
