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
    static void leveloftree(){
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
