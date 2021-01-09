package com.dsaprograms.linkedlist;
/*
LeetCode : 82. Remove Duplicates from Sorted List II
Linkedlist:
5 5 7 10 10 10 11 12
After removing all duplicate nodes:
7 11 12
 */
public class RemoveDuplicatesFromSortedList2 {
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

    public static Node removeDuplicates2(Node node){
        Node current=head;
        if(head==null || head.next==null){
            return head;
        }
        Node dummy=new Node(0);
        Node prev=dummy;
        while(current!=null){
            if(current.next!=null && current.data==current.next.data){
                while(current.next!=null && current.data==current.next.data){
                    current=current.next;
                }
            }
            else{
                prev.next=current;
                prev=prev.next;
            }
            current=current.next;
        }
        prev.next=null;
        return dummy.next;
    }

    public static void main(String[] args){
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
        current1.next = new Node(11);
        current1 = current1.next;
        current1.next = new Node(12);
        System.out.println("Linkedlist:");
        printElements(head);
        System.out.println("After removing all duplicate nodes: ");
        printElements(removeDuplicates2(head));

    }
}
