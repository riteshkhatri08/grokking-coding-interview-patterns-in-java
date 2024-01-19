package fastAndSlowPointers;

public class CycleDetection {
    /****************** DRIVER CODE ******************/
    public static void main(String[] args) {

        int list[] = new int[] { 0, 2, 3, 5, 6 };
        int loopedNodeIndex = 1;

        var obj = new CycleDetection();
        var linkedlist = obj.new LinkedList<>();
        linkedlist.createLinkedList(list);
        LinkedListNode loopedNode = LinkedList.getNode(linkedlist.head, loopedNodeIndex);
        LinkedListNode lastNode = LinkedList.getNode(linkedlist.head, list.length - 1);
        // create cycle
        lastNode.next = loopedNode;

        var result = obj.detectCycle(linkedlist.head);
        System.out.println("ANSWER " + result);

    }

    /****************** DRIVER CODE ENDS ******************/

    public boolean detectCycle(LinkedListNode head) {

        LinkedListNode fast = head;
        LinkedListNode slow = head;

        while (fast != null) {
            fast = fast.next != null ? fast.next.next : fast.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    /*
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */
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

        // returns the node at the specified position(index) of the linked list
        public static LinkedListNode getNode(LinkedListNode head, int pos) {
            LinkedListNode ptr = head;
            if (pos != -1) {
                int p = 0;

                while (p < pos) {
                    ptr = ptr.next;
                    p += 1;
                }

                return ptr;
            }
            return ptr;
        }

        // returns the number of nodes in the linked list
        public static int getLength(LinkedListNode head) {
            LinkedListNode temp = head;
            int count = 0;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }

    }
    // Template for linked list node class

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