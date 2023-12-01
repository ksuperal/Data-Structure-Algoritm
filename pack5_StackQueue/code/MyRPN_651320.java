package pack5_StackQueue.code;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN_651320 {
    private static Pattern pattern =
                    Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }
    public static boolean isOperator(String symbol) {
        String operators = "+-*/";

        return operators.contains(symbol);
    }
    public static double computeRPN(String rpn) {
        MyStackA_651320 stack = new MyStackA_651320();
        StringTokenizer st = new StringTokenizer(rpn);
        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (isNumeric(t))
                stack.push(Double.parseDouble(t));
            else {
                if (t.equals("-")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a - b);
                }
                if (t.equals("+")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a + b);
                }
                if (t.equals("/")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a / b);
                }
                if (t.equals("*")) {
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a * b);
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String rpn = in.nextLine();
        computeRPN(rpn);
        in.close();
    }
}
