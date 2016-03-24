package com.hackerrank;

/**
 * Created by samujjal on 9/10/15.
 */
class Node {
    int data;
    Node next;
}
public class LinkedList {

    static void printlist(Node head){
        if(head != null){
            System.out.print(head.data + ", ");
            printlist(head.next);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        head = InsertNth(head, 3, 0);
        head = InsertNth(head, 5, 1);
        head = InsertNth(head, 4, 2);
        head = InsertNth(head, 2, 4);
        head = InsertNth(head, 10, 1);
        printlist(head);
        head = Reverse(head);
//        head = Delete(head, 3);
        printlist(head);
    }

    public static Node Reverse(Node head) {
        if(head == null){
            return null;
        }
        Node R = null;
        Node P = head;
        Node Q = head.next;

        while (P != null){
            P.next = R;
            R = P;
            P = Q;
            if(Q != null)
                Q = Q.next;
        }

        return R;


    }

    public static Node RemoveDuplicates(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if(head == null){
            return null;
        }
        Node headNext = head.next;
        while(head != null && headNext != null && head.data == headNext.data){
            head.next = headNext.next;
            headNext = head.next;
        }
        head.next = RemoveDuplicates(head.next);
        return  head;

    }

    public int HasCycle(Node head) {

        int isCircle = 0;
        Node fast = head;
        Node slow = head;
        while (fast != null && slow != null){

            if(fast == slow){
                isCircle = 1;
                break;
            }
            fast = fast.next;
            if (slow.next != null){
                slow = slow.next.next;
            }else {

                break;
            }
        }
        return isCircle;
    }


    public static Node MergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method

        if(headA == null){
            return headB;
        }
        if(headB == null){
            return headA;
        }
        Node listA = headA;
        Node listB = headB;
        Node listANext = headA.next;
        Node listBNext = headB.next;
        Node head = null;
        if (listA.data ==  listB.data){
            listA.next = listB;
            head = listA;
            head.next.next = MergeLists(listANext, listBNext);
        }
        else if(listA.data > listB.data){
            head = listB;
            head.next = MergeLists(listA, listBNext);
        }
        else{
            head = listA;
            head.next = MergeLists(listANext,listB);
        }
        return head;

    }

    public static int GetNode(Node head,int n) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        Node first = head;
        Node second = head;
        while(n > 0){
            second = second.next;
            n--;
        }
        while (second.next != null){
            second = second.next;
            first = first.next;
        }
        return first.data;

    }
    public static int CompareLists(Node headA, Node headB) {
        if(headA == null && headB == null){
            return 1;
        }
        while (headA != null && headB != null){
            if(headA.data == headB.data){
                headA = headA.next;
                headB = headB.next;
            }
            else {
                return 0;
            }
        }

        if(headA == null && headB == null){
            return  1;
        }

        return 0;
    }

    private static void ReversePrint(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if(head == null)
            return;
        ReversePrint(head.next);
        System.out.println(head.data);

    }

    private static Node InsertNth(Node head, int data, int position) {
        Node node = head;
        int counter = 0;

        while(node != null && counter < position-1){
            if(node.next == null){
                break;
            }
            node = node.next;
            counter++;
        }
        Node insertNode = new Node();
        insertNode.data = data;
        if(node != null){
            if(position == 0){
                insertNode.next = head;
                return insertNode;
            }
            insertNode.next = node.next;
            node.next = insertNode;
        }
        else{
            insertNode.next = null;
            head = insertNode;
        }
        return head;


    }

    private static Node Delete(Node head, int position) {
        // Complete this method
        if(head == null){
            return null;
        }
        if(position == 0){
            return head.next;
        }
        int counter = 0;
        Node node = head;
        while(node.next != null && counter < position-1){
            node = node.next;
            counter++;
        }

        if(node.next != null)
            node.next = node.next.next;
        return head;

    }
}
