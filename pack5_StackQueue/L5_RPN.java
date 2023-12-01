package pack5_StackQueue;
import pack5_StackQueue.code.MyStackA_651320;

import java.util.StringTokenizer;

import pack5_StackQueue.code.MyRPN_651320;

class L5_RPN_Main {
    private static void testTokenizer(String toBeRPN) {
        StringTokenizer st = new StringTokenizer(toBeRPN);
        int i = 0;
        String t = "";
        while (st.hasMoreTokens()) {
            t = st.nextToken();
            if (MyRPN_651320.isNumeric(t))
                System.out.println("Token " + i++ + " = " + t);
            else
                System.out.println("Token " + i++ + " = " + t + " is an opearator");
        }
    }
    public static void main(String[] args) { 
        // 3 1 - 4 5 + * -> ans = 18
        //8 5 - 4 2 + 3 / * -> ans = 6
        //2 5 * 4 + 3 2 * 1 + / -> ans = 2
        String postfixString = "8 5 - 4 2 + 3 / *";
        if (args.length > 0)
            postfixString = args[0];
        //testTokenizer(postfixString);
        System.out.println(postfixString);
        System.out.println("Result = " + MyRPN_651320.computeRPN(postfixString));
    }
}