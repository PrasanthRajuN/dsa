import java.util.*;

public class Stacks {
    static void print(String a) {
        System.out.print(a);
    }

    static void println(String a) {
        System.out.println(a);
    }

    static class stackusingAl {
        ArrayList<String> al = new ArrayList<>();

        public boolean isempty() {
            if (al.size() == 0)
                return true;
            return false;
        }

        public void push(String data) {
            al.add(data);
        }

        public String pop() {
            if (isempty())
                return " ";
            return al.remove(al.size() - 1);
        }

        public String peek() {
            if (isempty())
                return " ";
            return al.get(al.size() - 1);
        }

        public int size() {
            return al.size();
        }
    }

    static int switc(String c) {
        switch (c) {
            case "+":
                ;
            case "-":
                return 1;
            case "*":
                ;
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return 0;
    }

    static String reverse(String s) {
        String a = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                a += "(";
            } else if (s.charAt(i) == '(') {
                a += ")";
            } else
                a += s.charAt(i);
        }
        println(a);
        return a;
    }

    static String infixtopostfix(String s) {

        stackusingAl stack = new stackusingAl();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (Character.isLetterOrDigit(a))
                result += a;
            else if (a == '(')
                stack.push("(");
            else if (a == ')') {
                while (!stack.isempty() && stack.peek() != "(") {
                    result += stack.pop();
                }
                stack.pop();
            } else {
                if (switc(a + "") > switc(stack.peek())) {
                    stack.push(a + "");
                } else {
                    result += stack.pop();
                    stack.push(a + "");
                }
            }
        }

        while (!stack.isempty()) {
            if (stack.peek() != "(")
                result += stack.pop();
        }
        return result;
    }

    static void infixtoprefix(String s) {
        s = reverse(s);
        s = infixtopostfix(s);
        println("infix " + s);
        s = reverse(s);
        print(s);
    }

    static void postfixtoinfix(String s) {
        stackusingAl stack = new stackusingAl();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (Character.isLetterOrDigit(a)) {
                stack.push(a + "");
            } else {
                result = "";
                String temp = "";
                if (!stack.isempty()) {
                    temp += stack.pop();
                    if (!stack.isempty()) {
                        result += stack.pop();
                    }
                    result += a;
                    result += temp;
                }
                stack.push(result);
            }
        }

        print(stack.pop());
    }

    static void postfixtoprefix(String s) {
        String result = "";
        stackusingAl stack = new stackusingAl();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (Character.isLetterOrDigit(a)) {
                stack.push(a + "");
            } else {
                String one = stack.pop(), two = stack.pop();
                stack.push(a + two + one);
            }
        }
        print(stack.pop());
    }

    static void prefixtoinfix(String s) {
        stackusingAl stack = new stackusingAl();
        for (int i = s.length() - 1; i > -1; i--) {
            char a = s.charAt(i);
            if (Character.isLetterOrDigit(a)) {
                stack.push(a + "");
            } else {
                String one = stack.pop(), two = stack.pop();
                stack.push("(" + one + a + two + ")");
            }
        }
        print(stack.pop());
    }

    static void prefixtopostfix(String s) {
        stackusingAl stack = new stackusingAl();
        for (int i = s.length() - 1; i > -1; i--) {
            char a = s.charAt(i);
            if (Character.isLetterOrDigit(a)) {
                stack.push(a + "");
            } else {
                String one = stack.pop(), two = stack.pop();
                stack.push(one + two + a);
            }
        }
        print(stack.pop());
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String S = s.nextLine();
        // postfixtoprefix(S);
        // postfixtoinfix(S);
        prefixtopostfix(S);
    }
}
