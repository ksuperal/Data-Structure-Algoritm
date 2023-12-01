package pack8_Tree.code2;

public class MyMinHeap_651320 {
    int MAX_SIZE = 100;
    int heap[] = new int[MAX_SIZE];
    int size = 0;

    void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;

    }

    public void insert(int d) {
        int p = size++;
        heap[p] = d;
        int parent = (p - 1) / 2;
        while ((p > 0) && (heap[p] < heap[parent])) {
            swap(p, parent);
            p = parent;
            parent = (p - 1) / 2;
        }
    }

    public int remove() {
        int d = heap[0];
        heap[0] = heap[--size];
        int p = 0;
        while (true) {
            int left = 2 * p + 1;
            if (left >= size)
                break;
            int right = 2 * p + 2;
            if (right == size) {
                if (heap[p] > heap[left])
                    swap(p, left);
                break;
            } else {

                int q = heap[left] < heap[right] ? left : right;
                if (heap[p] > heap[q])
                    swap(p, q);
                else
                    break;
                p = q;
            }
        } // end while
        return d;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        return heap[0];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First->");
        for (int i = 0; i < size; i++) {
            sb.append(heap[i] + " ");
        }
        sb.append("<-Last");
        return sb.toString();
    }
}
