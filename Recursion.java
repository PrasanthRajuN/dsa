public class Recursion {
    static void print(String a) {
        System.out.print(a);
    }

    static void println(String a) {
        System.out.println(a);
    }

    static void print_asc(int n) {
        if (n != 1) {
            print_asc(n - 1);
        }
        print(n + " ");
    }

    static void print_dsc(int n) {
        if (n != 0) {
            print(n + " ");
            print_dsc(n - 1);
        }
    }

    static void sum_recurse(int n, int sum) {
        if (n != 0) {
            sum_recurse(n - 1, sum + n);
        } else {
            println(sum + "");
        }
    }

    static void fib(int n, int a, int b, int fi) {
        if (a == 0) {
            print("0 1 ");
        }
        if (n >= b) {
            fi = a + b;
            print(fi + " ");
            fib(n - 1, b, fi, fi);
        } else {
            print(a + b + " ");
        }
    }

    static int fib_num(int n) {
        if (n <= 1)
            return n;
        return fib_num(n - 1) + fib_num(n - 2);
    }

    static void occurence(String s, char target) {
        int st = -1, ed = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target && st == -1) {
                st = i;
                ed = i;
            }
            if (s.charAt(i) == target && st != -1) {
                ed = i;
            }
        }
        print(st + " " + ed);
    }

    static void occurence_rec(int i, String s, char target, int st, int ed) {
        if (i == s.length() - 1) {
            print(st + " " + ed);
            return;
        }
        if (s.charAt(i) == target && st == -1) {
            st = i;
            ed = i;
        }
        if (s.charAt(i) == target && st != -1) {
            ed = i;
        }
        occurence_rec(i + 1, s, target, st, ed);
    }

    public static void main(String args[]) {
        occurence_rec(0, "shyam sundar", 's', -1, -1);
    }
}
