// https://www.educative.io/courses/grokking-coding-interview-patterns-java/reorder-list

package inPlaceLinkedListReversal;

public class ReorderList {

    public static void main(String[] args) {
        int[] lst = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // H => 3 => 2=> 1

        var obj = new ReorderList();
        LinkedList<Integer> list = obj.new LinkedList<Integer>();
        list.createLinkedList(lst);

        list.head = reorderList(list.head);

        System.out.println("ANSWER = " + list.print());
    }

    public static LinkedListNode reorderList(LinkedListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode pointertwo = head, pointerone = head, temp = null;

        // FIND MIDDLE
        while (pointertwo != null && pointertwo.next != null) {
            pointertwo = pointertwo.next.next;
            temp = pointerone;
            pointerone = pointerone.next;
        }
        // Break it in the middle with middle as head for list two
        temp.next = null;

        // NOW Reverse list two
        pointertwo = null;
        while (pointerone != null) {
            temp = pointerone.next;
            pointerone.next = pointertwo;
            pointertwo = pointerone;
            pointerone = temp;
        }

        // Merge both lists
        pointerone = head;

        while (pointerone.next != null) {
            temp = pointerone.next;
            pointerone.next = pointertwo;
            pointerone = temp;
            temp = pointertwo.next;
            pointertwo.next = pointerone;
            pointertwo = temp;

        }
        pointerone.next = pointertwo;

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
                try {
                    System.out.println("CUR NODE = " + temp.data);
                    sb.append(temp.data).append(", ");
                    Thread.sleep(100);
                    temp = temp.next;
                } catch (Exception e) {

                }
            }
            sb.append("]");

            return sb.toString();
        }
    }
}