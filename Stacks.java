import java.util.*;

public class Stacks {
    static void print(String a) {
        System.out.print(a);
    }

    static void println(String a) {
        System.out.println(a);
    }

    static class stackusingAl {
        ArrayList<Integer> al = new ArrayList<>();

        public boolean isempty() {
            if (al.size() == 0)
                return true;
            return false;
        }

        public void push(int data) {
            al.add(data);
        }

        public int pop() {
            if (isempty())
                return -1;
            return al.remove(al.size() - 1);
        }

        public int peek() {
            if (isempty())
                return -1;
            return al.get(al.size() - 1);
        }

        public int size() {
            return al.size();
        }
    }

    public static void main(String args[]) {
        stackusingAl st = new stackusingAl();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        println(" Peek : " + st.peek() + "");
        println(" Popped" + st.pop() + "");
        while (st.isempty() == false) {
            println(st.pop() + "");
        }
        println(" Peek : " + st.peek() + "");
    }
}
