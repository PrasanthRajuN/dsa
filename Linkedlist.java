class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Linkedlist {
    static Node head;

    static void print(String a) {
        System.out.print(a);
    }

    static void println(String a) {
        System.out.println(a);
    }

    static void printlist() {
        Node temp = head;
        while (temp != null) {
            print(temp.data + "->");
            temp = temp.next;
        }
        println("");
    }

    static void add_first(int data) {
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
    }

    static void add_mid(int data) {
        Node newnode = new Node(data), slow = head, fast = head;
        if (slow != null) {
            while (fast != null && fast.next != null && fast.next.next != null) {// fast.next.next != null || because
                                                                                 // slow reaches center but to add
                                                                                 // element at center
                fast = fast.next.next;
            }
            Node temp = slow.next;
            slow.next = newnode;
            newnode.next = temp;
        } else {
            newnode.next = head;
            head = newnode;
        }
    }

    static void add_last(int data) {
        Node temp = head, newnode = new Node(data);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
    }

    static int count() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
        }
        return count;
    }

    static void add_at_pos(int k, int data) {
        Node temp = head;
        Node newnode = new Node(data);
        if (k == 0 || head == null) {
            newnode.next = head;
            head = newnode;
            return;
        }
        while (k != 1 && temp.next != null) {// a!=1 because to add element at exact location-1
            k--;
            temp = temp.next;
        }
        if (k < 0 || k != 1) {
            println("Adding at the given position is not possible");
            return;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }

    static void evenodd() {
        Node evenhead = new Node(-1), oddhead = new Node(-1), even = evenhead, odd = oddhead, temp = head;
        int c = 0;
        while (temp != null) {
            if (c == 0) {
                even.next = temp;
                even = even.next;
                c++;
            } else if (c == 1) {
                odd.next = temp;
                odd = odd.next;
                c--;
            }
            temp = temp.next;
        }
        even.next = oddhead.next;
        head = evenhead.next;
    }

    static void reverse() {
        Node cur = head, prev = null;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        cur = prev;
        head = cur;
    }

    static void loopfinder() {
        Node temp = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                println("Loop Detected");
                return;
            }
        }
        println(slow.data + "");
        println("No Loop Detected");
    }

    static void loopremover() {
        Node temp = head, slow = head, fast = head, prev = fast;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            prev = fast.next;
            fast = fast.next.next;
            if (fast == slow)
                break;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        println(slow.data + "");
        prev.next = null;
    }

    static void palindrom() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null, cur = slow;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        slow = head;
        cur = prev;
        while (cur != null) {
            if (slow.data != cur.data) {
                println("no");
                return;
            }
            slow = slow.next;
            cur = cur.next;
        }
        print("yes");
    }

    public static void main(String[] args) {
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(10);
        palindrom();
    }
}