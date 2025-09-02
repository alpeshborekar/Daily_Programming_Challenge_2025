import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        System.out.println(evalPostfix(exp));
    }

    public static int evalPostfix(String exp) {
        Stack<Integer> st = new Stack<>();
        String[] tokens = exp.split(" ");
        for (String t : tokens) {
            if (isOperator(t)) {
                int b = st.pop();
                int a = st.pop();
                st.push(applyOp(a, b, t));
            } else {
                st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }

    public static boolean isOperator(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/") || t.equals("^");
    }

    public static int applyOp(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            case "^": return (int)Math.pow(a, b);
        }
        return 0;
    }
}
