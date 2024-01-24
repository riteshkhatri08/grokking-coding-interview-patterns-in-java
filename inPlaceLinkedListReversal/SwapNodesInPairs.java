package inPlaceLinkedListReversal;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        int[] lst = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // H => 3 => 2=> 1

        var obj = new SwapNodesInPairs();
        LinkedList<Integer> list = obj.new LinkedList<Integer>();
        list.createLinkedList(lst);

        list.head = swapPairs(list.head);

        System.out.println("ANSWER = " + list.print());
    }

    public static LinkedListNode swapPairs(LinkedListNode head) {
        if (head.next == null) {
            return head;
        }
        // Replace this placeholder return statement with your code
        LinkedListNode first = null, second = head, third = head.next, temp = null;
        head = head.next;
        // F S T TM
        // null , 1 => 2 => 3 => 4 => 5 => null
        // null , 2 => 1 => 3 => 4 => 5 => null

        while (third != null) {
            temp = third.next;
            third.next = second;
            second.next = temp;
            if (first != null) {
                first.next = third;
            }

            first = second;
            second = temp;
            third = (temp != null) ? temp.next : null;

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
                // System.out.println("CUR NODE = " + temp.data);
                sb.append(temp.data).append(", ");
                // Thread.sleep(100);
                temp = temp.next;
            }
            sb.append("]");

            return sb.toString();
        }
    }
}
