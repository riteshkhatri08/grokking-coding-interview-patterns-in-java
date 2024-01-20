// https://www.educative.io/courses/grokking-coding-interview-patterns-java/palindrome-linked-list
// https://leetcode.com/problems/palindrome-linked-list/description/

package fastAndSlowPointers;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        int list[] = new int[] { 6, 1, 0, 5, 1, 6 };

        var obj = new PalindromeLinkedList();
        var linkedlist = obj.new LinkedList<>();
        linkedlist.createLinkedList(list);

        var result = palindrome(linkedlist.head);
        System.out.println("\nANSWER " + result);
    }

    public static boolean palindrome(LinkedListNode head) {

        if (head.next == null) {
            return true;
        }
        // FIND MIDDLE
        LinkedListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;

        }
        if (fast.next != null) {
            fast = fast.next;
        }
        // Store middle
        LinkedListNode middle = slow;

        // fast is at END
        // slow is at mid
        // Store postion after middle in temp
        LinkedListNode temp = slow.next;
        // middle's next to last node
        slow.next = fast;

        // fast to middle's next before reversal
        fast = temp;
        // slow to null, follwing behind fast
        slow = null;

        // FOUND CENTER reverse list from here fast
        while (fast != null) {
            temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }

        // START COMPARISON
        slow = head;
        fast = middle.next;
        while (fast != null) {
            if (slow.data != fast.data) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    // Template for the linked list
    class LinkedList<T> {
        public LinkedListNode head;

        // constructor will be used to make a LinkedList type object
        public LinkedList() {
            this.head = null;
        }

        // insertNodeAtHead method will insert a LinkedListNode at head
        // of a linked list.
        public void insertNodeAtHead(LinkedListNode node) {
            if (this.head == null) {
                this.head = node;
            } else {
                node.next = this.head;
                this.head = node;
            }
        }

        // createLinkedList method will create the linked list using the
        // given integer array with the help of InsertAthead method.
        public void createLinkedList(int[] lst) {
            for (int i = lst.length - 1; i >= 0; i--) {
                LinkedListNode newNode = new LinkedListNode(lst[i]);
                insertNodeAtHead(newNode);
            }
        }

    }

    class LinkedListNode {
        public int data;
        public LinkedListNode next;

        // Constructor will be used to make a LinkedListNode type object
        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
