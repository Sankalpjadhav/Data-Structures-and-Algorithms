package com.dsaprograms.linkedlist;
/*
Linkedlist to be sorted:
5 30 23 6 9 10
Sorted linkedlist:
5 6 9 10 23 30
 */
public class MergesortLinkedlist {
    static  Node head;
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

    static Node mergerSort(Node node){
        if(node==null || node.next==null){
            return node;
        }
        Node middle = findMiddleElement(node);
        Node nextHead = middle.next;
        middle.next = null;

        Node list1 = mergerSort(node);

        Node list2 = mergerSort(nextHead);

        Node result = merge(list1, list2);
        return result;
    }

    static Node findMiddleElement(Node node){
        if(node==null || node.next==null){
            return node;
        }
        Node slow = node;
        Node fast = node;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node merge(Node l1, Node l2){
        Node resultHead = new Node(-1);
        Node handler = resultHead;
        while(l1!=null && l2!=null){
            if(l1.data < l2.data){
                handler.next = l1;
                l1 = l1.next;
            }
            else{
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }

        if(l1==null){
            handler.next = l2;
        }
        else{
            handler.next = l1;
        }

        return resultHead.next;
    }

    public static void main(String[] args) {
        head = new Node(5);
        Node current1 = head;
        current1.next = new Node(30);
        current1 = current1.next;
        current1.next = new Node(23);
        current1 = current1.next;
        current1.next = new Node(6);
        current1 = current1.next;
        current1.next = new Node(9);
        current1 = current1.next;
        current1.next = new Node(10);
        System.out.println("Linkedlist to be sorted:");
        printElements(head);

        Node result = mergerSort(head);
        System.out.println("Sorted linkedlist:");
        printElements(result);
    }
}
