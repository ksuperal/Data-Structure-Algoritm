package pack5_StackQueue.code;

import java.util.StringTokenizer;

public class MyShuntingYard_651320 {
    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }
    public static String infixToPostfix(String infixString) {
        MyQueueL_651320 queue = new MyQueueL_651320();
        MyStackL stack = new MyStackL();
        String resultPostfixString = "";
        StringTokenizer st = new StringTokenizer(infixString);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (MyRPN_651320.isNumeric(t))
                queue.enqueue(t);
            else if (MyRPN_651320.isOperator(t)){
                while (!stack.isEmpty() && order(stack.top()) >= order(t)) {
                    queue.enqueue(stack.pop());
                }
                stack.push(t);    
            }
            else if (t.equals("(")) {
                stack.push(t);
            } 
            else if (t.equals(")")) {
                while (!stack.top().equals("(")){
                    queue.enqueue(stack.pop());
                }
                stack.pop(); 
            } else {
            while(!stack.isEmpty()) {
                queue.enqueue(stack.pop());
            }
        }
            System.out.println("current q = " + queue.dumpToString());
        }
            resultPostfixString = queue.dumpToString();
            return resultPostfixString; 
        }
    }
