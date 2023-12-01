package pack5_StackQueue.code;

public class MyQueueL_651320 {
    public Node head, tail;
    private class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }
    public MyQueueL_651320() {
        head = tail = null;
    }
    public void enqueue(String d) {
        Node n = new Node(d);
        if (head == null)
            head = tail = n;
        else {
            tail.next = n;
            tail = tail.next;
        }
    }
    public String dequeue() {
        if (isEmpty()) 
            return "";
        String value = head.value;
        head = head.next;
        return value;
    }
    public boolean isFull() {
        return false;
    }
    public boolean isEmpty() {
        return head==null;
    }
    public String top() {
        return head.value;
    }
    public String getLast() {
        return tail.value;
    }
    public String dumpToString() {
        StringBuffer sb = new StringBuffer();
        Node n = head;
        while (n != null) {
            sb.append(n.value + " ");
            n = n.next;
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First->");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.value).append("->");
        temp = temp.next;
        }
        sb.append("Last");
        return sb.toString();
    }
}