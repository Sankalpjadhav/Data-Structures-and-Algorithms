package com.dsaprograms.linkedlist;
/*
Original Linkedlist:
5 6 2 10 12 11 19 15
Folded Linkedlist:
5 15 6 19 2 11 10 12
 */
public class FoldALinkelist {
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

    private static Node foldLinkedlist(Node node){
        Node slow = node, fast = node;
        Node end = null;
        while(fast!=null && fast.next!=null){
            end = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        end.next = null;
        Node newHead = reverse(slow);
        Node result = new Node(-1);
        Node handler = result;
        while(node!=null && newHead!=null){
            handler.next = node;
            handler = handler.next;
            node = node.next;
            handler.next = newHead;
            handler = handler.next;
            newHead = newHead.next;
        }
        //handler.next =null; Important when to add or not.
        return result.next;

    }

    private static Node reverse(Node head){
        Node current = head;
        Node prev =null, next =null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
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
        current1.next = new Node(11);
        current1 = current1.next;
        current1.next = new Node(19);
        current1 = current1.next;
        current1.next = new Node(15);
        System.out.println("Original Linkedlist:");
        printElements(head);
        System.out.println("Folded Linkedlist:");
        printElements(foldLinkedlist(head));
    }
}
