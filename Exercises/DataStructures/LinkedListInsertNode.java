class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}


public class LinkedListInsertNode {
    
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);
        if(position ==0){
            new_node.next = llist;
            return new_node;
        }

        SinglyLinkedListNode currentNode = llist;

        for(int i =0 ; i< position-1 ; i++){
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }

        new_node.next = currentNode.next;
        currentNode.next = new_node;
        return llist;
    }

    public static void main(String[] args) {
        SinglyLinkedList lis = new SinglyLinkedList();
        lis.insertNode(16);
        lis.insertNode(13);
        lis.insertNode(7);
        insertNodeAtPosition(lis.head, 1, 2);
    }
}
