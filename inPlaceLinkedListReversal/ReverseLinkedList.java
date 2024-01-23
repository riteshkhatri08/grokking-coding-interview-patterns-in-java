// https://www.educative.io/courses/grokking-coding-interview-patterns-java/reverse-linked-list

package inPlaceLinkedListReversal;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] lst = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        var obj = new ReverseLinkedList();
        LinkedList<Integer> list = obj.new LinkedList<Integer>();
        list.createLinkedList(lst);

        list.head = reverse(list.head);
        System.out.println("ANSWER = " + list.print());
    }

    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode front = head, back = null, temp;

        while (front != null) {
            temp = front.next;
            front.next = back;
            back = front;
            front = temp;
        }
        if (front == null) {
            head = back;
        }
        return head;
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

        public String print() {
            StringBuilder sb = new StringBuilder("[ ");
            LinkedListNode temp = this.head;
            while (temp != null) {
                sb.append(temp.data).append(", ");
                temp = temp.next;
            }
            sb.append("]");

            return sb.toString();
        }
    }
}
