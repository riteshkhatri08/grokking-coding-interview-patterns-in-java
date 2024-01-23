package inPlaceLinkedListReversal;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        int[] lst = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // H => 3 => 2=> 1

        int k = 3;
        var obj = new ReverseNodesInKGroup();
        LinkedList<Integer> list = obj.new LinkedList<Integer>();
        list.createLinkedList(lst);

        list.head = reverseKGroups(list.head, k);

        System.out.println("ANSWER = " + list.print());
    }

    public static LinkedListNode reverseKGroups(LinkedListNode head, int k) {

        LinkedListNode ender = head, front = head, back = null, temp, frontshadow = front, frontshadowtemp;
        int count = 0;
        boolean first = true;
        while (ender != null) {
            count = 0;

            // Finder
            while (ender != null && count < k) {
                ender = ender.next;
                count++;
            }
            // reverse the group
            if (count == k) {
                frontshadowtemp = front;
                back = ender;
                while (count > 0) {
                    temp = front.next;
                    front.next = back;
                    back = front;
                    front = temp;
                    count--;
                }
                if (first) {
                    head = back;
                    first = false;
                } else {
                    frontshadow.next = back;
                    frontshadow = frontshadowtemp;
                }
            }
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
