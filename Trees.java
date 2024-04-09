import java.util.*;
import java.util.LinkedList;
public class Trees
{
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    static void printingTree(){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.remove();
            System.out.println(temp.data);
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
    }
    static void levelwisetraversal(){
        Queue<Node> q=new LinkedList();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node temp=q.remove();
            if(temp==null){
                if(q.isEmpty())break;
                else{
                    System.out.println();
                    q.add(null);
                }
            }
            else{
                System.out.print(temp.data);
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
        }
    }
    static void inOrderTraversal(Node root){
        if(root==null)return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }
    static void preordertraversal(Node root) {
        if(root==null)return;
        System.out.println(root.data);
        preordertraversal(root.left);
        preordertraversal(root.right);
    }
    static void postOrderTraversal(Node root){
        if(root==null)return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }
	
    static int No_of_nodes(Node root){
        if(root==null)return 0;
        return No_of_nodes(root.left)+No_of_nodes(root.right)+1;
    }
    static int Sum_of_nodes(Node root){
        if(root==null)return 0;
        return Sum_of_nodes(root.left)+Sum_of_nodes(root.right)+root.data;
    }
	static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        return (search(root.left, key) || search(root.right, key));
    }

    static void main_tree(Node root, Node subroot) {
        if (root == null || subroot == null)
            return;
        if (root.data == subroot.data) {
            print(check(root, subroot) + "");
            return;
        }
        main_tree(root.left, subroot);
        main_tree(root.right, subroot);
    }

    static boolean check(Node root, Node subroot) {
        if (root == null && subroot == null)
            return true;
        if (root == null || subroot == null)
            return true;
        if (root.data != subroot.data)
            return false;
        if (check(root.left, subroot.left))
            return true;
        if (check(root.right, subroot.right))
            return true;
        return true;
    }

    static void levelordertraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp == null) {
                if (q.isEmpty())
                    break;
                System.out.println();
                q.add(null);

            } else {
                print(temp.data + " ");
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
    }

    static Node root;
	public static void main(String[] args) {
        root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right.left=new Node(60);
        root.right.right=new Node(70);
        postOrderTraversal(root);
	}
}
