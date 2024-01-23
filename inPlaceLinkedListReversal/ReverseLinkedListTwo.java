package inPlaceLinkedListReversal;

public class ReverseLinkedListTwo {
    public static void main(String[] args) {
        int[] lst = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // H => 3 => 2=> 1

        var obj = new ReverseLinkedListTwo();
        LinkedList<Integer> list = obj.new LinkedList<Integer>();
        list.createLinkedList(lst);

        list.head = reverseBetween(list.head, 3, 8);

        System.out.println("ANSWER = " + list.print());
    }

    public static LinkedListNode reverseBetween(LinkedListNode head, int l, int r) {

        LinkedListNode front = head, back = null, backshadow, temp, frontshadow;
        r -= l;
        while (l-- > 1) {
            back = front;
            front = front.next;

        }
        // System.out.println("FRONT=" + front.data);
        // Start reversal
        backshadow = back;
        frontshadow = front;
        // change front shadow.next = front
        // backshadpw.next = back
        while (r-- >= 0) {
            System.out.println("FRONT=" + front.data);
            temp = front.next;
            front.next = back;
            back = front;
            front = temp;
        }
        if (backshadow != null) {
            backshadow.next = back;
        } else {
            head = back;
        }
        frontshadow.next = front;

        return head;
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