package com.dsaprograms.linkedlist;

/*
Leetcode : 234. Palindrome Linked List
Given a singly linked list, determine if it is a palindrome.
Example 1:
Input: 1->2
Output: false
Example 2:
Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedlist {
    private static Node head;
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static boolean isPalindrome(Node head){
        // Divide the linkedlist into two halves.
        // Reverse the second half
        // Compare with first half if equal then return true else false
        Node end =null;
        Node current = head;
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            end = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        end.next=null;
        // First half is from head to end. Second half is from slow to fast or till null.
        Node secondHead = reverse(slow);
        while(head!=null && secondHead!=null){
            if(head.data != secondHead.data){
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        return true;

    }

    public static Node reverse(Node node){
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
        head = new Node(5);
        Node current1 = head;
        current1.next = new Node(6);
        current1 = current1.next;
        current1.next = new Node(20);
        current1 = current1.next;
        current1.next = new Node(10);
        current1 = current1.next;
        current1.next = new Node(10);
        current1 = current1.next;
        current1.next = new Node(2);
        current1 = current1.next;
        current1.next = new Node(6);
        current1 = current1.next;
        current1.next = new Node(5);
        boolean result = isPalindrome(head);
        if(result==true) {
            System.out.println("Palindrome");
            return;
        }
        System.out.println("Not a Palindrome");
    }
}
