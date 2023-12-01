package Lab3and4.code;

public class MyLinkedList_651320 {
    public class Node {
        int data;
        Node next;
        public Node(int d) {
          data = d;
        }
    }
    Node head = null;

    public void add(int d) {
        Node p = new Node(d);
        p.next = head;
        head = p;
    }    
    public void insert(int d) {
        Node newNode = new Node(d);

        if (head == null || d < head.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < d) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    public Node find(int d) {
        Node p = head;
        int found;
        while(p!=null) {
            if(p.data==d)
                
               return p;
            
            p = p.next;
        }
        return null;
    }
    public void delete(Node p) {
        p.next = p.next.next;
    }
    public int size(){
        Node temp = this.head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
    }
    public void add(int[]d){
        for (int i = d.length - 1; i >= 0; i--) {
            Node newNode = new Node(d[i]);
            newNode.next = head;
            head = newNode;
        }
    }
    public void insert(int[]d){
        for (int i = 0; i < d.length; i++) {
            insert(d[i]);
        }  
    }
    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while(p!=null) {
         sb.append("--> [");
         sb.append(p.data);
         sb.append("] ");
         p = p.next;
        }
        sb.append("-> null");
        return new String(sb);
    }
    public void q1_rotate_clockwise(int k){
        {
            if (k == 0)
                return;
            Node current = head;
            int count = 1;
            while (count < k && current != null)
            {
                current = current.next;
                count++;
            }
            if (current == null)
                return;
            Node kth = current;
            while (current.next != null)
                current = current.next;
            current.next = head;
            head = kth.next;
            kth.next = null;
        }
                
    }
    public void q2_reverse(){
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        head = prev;
    }
    public void q3_remove_dup(){
        Node current = head;
        Node index = null;
        Node temp = null;
        if (head == null){
            return;  
        }  
        else {  
            while(current != null){
                temp = current;
                index = current.next;
                while(index != null) {  
                    if(current.data == index.data) {  
                        temp.next = index.next;  
                    }  
                    else {  
                        temp = index;  
                    }  
                    index = index.next;  
                }  
                current = current.next;  
            }  
        }
    }

    public void q4_increment_digits(){
        Node current = head;

        while (current != null) {
            current.data += 1;
                if(current.data > 9)
                    current.data = 0;
            current = current.next;
        }
    }
    public boolean q5_isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            Node temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null && prev != null) {
            if (slow.data != prev.data) {
                return false; 
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true; 
    }

    }
 
    


