package pack5_StackQueue.code;

public class MyStackA_651320 {
    int MAX_SIZE=100;
    double stack[] = new double[MAX_SIZE];
    int top = 0;
    
    public void push(double d) {
        stack[top++] = d;
    }
    public double pop() {
        return stack[--top];
    }
    public double top() {
        return stack[top-1];
    }
    public boolean isFull() {
        return top==MAX_SIZE;
    }
    public boolean isEmpty() {
        return top==0;
    }
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("top->");
        for(int i=top-1; i>=0; i--) {
            sb.append("[");
            sb.append(stack[i]);
            sb.append("]->");
        }
        sb.append("bottom");
        return new String(sb);
    }
    public boolean hasMoreTokens(){
        return !isEmpty();
    }
    public double nextToken(){
        return top();
    }
}