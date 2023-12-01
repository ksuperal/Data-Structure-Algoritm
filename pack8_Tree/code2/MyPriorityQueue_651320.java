package pack8_Tree.code2;


public class MyPriorityQueue_651320 {
    MyMinHeap_651320 heap = new MyMinHeap_651320();
    public void enqueue(int d) {
        heap.insert(d);
    }
    public int dequeue() {
        return heap.remove();
    }
    public int front() {
        return heap.peek();
    }
    public boolean isFull() {
        return heap.isFull();
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    public String toString() {
        return heap.toString();
    }
}
