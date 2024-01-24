package inPlaceLinkedListReversal;

public class ReverseNodesInEvenLengthGroups {
    public static void main(String[] args) {
        int[] lst = new int[] { 11, 12, 13, 14, 15 };

        var obj = new ReverseNodesInEvenLengthGroups();
        LinkedList<Integer> list = obj.new LinkedList<Integer>();
        list.createLinkedList(lst);

        list.head = reverseEvenLengthGroups(list.head);
        System.out.println("ANSWER = " + list.print());
    }

    public static LinkedListNode reverseEvenLengthGroups(LinkedListNode head) {

        if (head.next == null) {
            return head;
        }

        // go to second node
        LinkedListNode groupend, prevgrouptail = null, groupstart, temporary;
        int targetgroupsize = 0, currentgroupsize = 0;
        groupend = head;
        while (groupend != null) {
            targetgroupsize++;
            currentgroupsize = 0;
            groupstart = prevgrouptail;

            // Find first group
            while (groupend != null && currentgroupsize < targetgroupsize) {
                prevgrouptail = groupend;
                groupend = groupend.next;
                currentgroupsize++;
            }

            if (currentgroupsize % 2 == 0) {
                temporary = groupstart.next;
                groupstart.next = reverse(temporary, groupend);
                temporary.next = groupend;
                prevgrouptail = temporary;
            }
        }
        return head;
    }

    private static LinkedListNode reverse(LinkedListNode start, LinkedListNode end) {
        LinkedListNode follower = null, temp = null;
        while (start != end) {
            temp = start.next;
            start.next = follower;
            follower = start;
            start = temp;
        }
        return follower;
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
