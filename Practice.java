import java.util.Arrays;
import java.util.*;

public class Practice {
    static void print(String a) {
        System.out.print(a);
    }

    static void println(String a) {
        System.out.println(a);
    }

    static void kadeans() {
        int a[] = { 4, 5, 3, -1, 3, 5 };
        int sum = 0, max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0)
                sum = 0;
            sum += a[i];
            max = Math.max(sum, max);
        }
        println(max + "");
    }

    static void voting() {
        int a[] = { 7, 1, 2, 7, 7, 7, 4, 7, 7, 6, 3 };
        int vot = 0, maj = -1;
        for (int i = 0; i < a.length; i++) {
            if (vot == 0) {
                maj = a[i];
                vot++;
            } else if (maj == a[i])
                vot++;
            else
                vot--;
        }
        println(maj + "");
        Arrays.sort(a);
        println("Verfication : " + a[(a.length - 1) / 2]);
    }

    static void dutch() {
        int a[] = { 2, 0, 1, 0, 0, 1, 2, 2, 1, 0 };
        int left = 0, mid = 0, right = a.length - 1;
        while (mid < right) {
            if (a[mid] == 0) {
                int temp = a[mid];
                a[mid] = a[left];
                a[left] = temp;
                mid++;
                left++;
            }
            if (a[mid] == 1)
                mid++;
            if (a[mid] == 2) {
                int temp = a[mid];
                a[mid] = a[right];
                a[right] = temp;
                right--;
            }
        }
        for (int i = 0; i < a.length; i++) {
            println(a[i] + "");
        }
    }

    static void bubble_sort() {
        int a[] = { 1, 10, 5, 4, 5, 2, 7, 1, 8, 4 };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            print(a[i] + " ");
        }
    }

    static void selection_sort() {
        int a[] = { 3, 4, 2, 6, 1, 7, 8, 6, 10 };
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            print(a[i] + " ");
        }
    }

    static void missing() {
        int a[] = { 1, 2, 3, 4, 6 };
        int n = ((a.length + 1) * (a.length + 2)) / 2;
        for (int i = 0; i < a.length; i++) {
            n -= a[i];
        }
        println(n + "");
    }

    static void missing_xor() {
        int a[] = { 1, 3, 4, 5, 6 };
        int a1 = 0, a2 = 0;
        for (int i = 0; i < a.length; i++) {
            a1 ^= a[i];
        }
        for (int i = 1; i <= a.length + 1; i++) {
            a2 ^= i;
        }
        println((+a1 ^ a2) + "");
    }

    static void right_rotate(int k) {
        int a[] = { 1, 2, 3, 4, 5 };
        k %= a.length;
        int l = 0, r = k - 1;
        while (l <= r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            r--;
            l++;
        }
        r = a.length - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            r--;
            l++;
        }
        l = 0;
        r = a.length - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            r--;
            l++;
        }
        for (int i = 0; i < a.length; i++) {
            print(a[i] + " ");
        }
    }

    static void left_rotate(int k) {
        int a[] = { 1, 2, 3, 4, 5 };
        k %= a.length;
        int l = 0, r = a.length - 1 - k;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            r--;
            l++;
        }
        l = a.length - k;
        r = a.length - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            r--;
            l++;
        }
        l = 0;
        r = a.length - 1;

        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            r--;
            l++;
        }
        for (int i = 0; i < a.length; i++) {
            print(a[i] + " ");
        }
    }

    static void hashmap_intro() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 10);
        map.put(2, 20);
        for (int i : map.keySet()) {
            println(map.get(i) + "");
        }
        println("" + map.getOrDefault(3, 30));
    }

    public static void main(String args[]) {
        hashmap();
    }
}
