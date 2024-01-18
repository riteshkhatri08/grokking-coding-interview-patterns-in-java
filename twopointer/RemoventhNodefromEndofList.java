package twopointer;

public class RemoventhNodefromEndofList {
    public static void main(String[] args) {

        int[] lst = new int[] { 69, 8, 49, 106, 116, 112 };
        int n = 6;
        var obj = new RemoventhNodefromEndofList();
        LinkedList<Integer> list = obj.new LinkedList<Integer>();
        list.createLinkedList(lst);
        System.out.println("INPUT  = " + list.print() + " n = " + n);
        var head = obj.new ReverseLinkedList().removeNthLastNode(list.head, n);
        list.head = head;
        System.out.println("ANSWER = " + list.print());

    }

    class ReverseLinkedList {
        public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
            LinkedListNode left = head;
            LinkedListNode right = head;

            while (n-- > 0) {
                right = right.next;
            }
            if (right != null)
                while (right.next != null) {
                    right = right.next;
                    left = left.next;
                }
            if (left == head) {
                head = head.next;
            } else {
                left.next = left.next.next;
            }
            return head;
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
