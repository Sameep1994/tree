package BST;

public class FixBSTWithTwoSwaps {
    public static Node prev=null,first=null,second=null;
    public static void main(String[] args) {
        Node root = new Node(18);
        root.left = new Node(60);
        root.left.left = new Node(4);
        root.right = new Node(70);
        root.right.left = new Node(8);
        root.right.right = new Node(80);

        fix(root);
        System.out.println("first "+first.key);
        System.out.println("second "+second.key);
    }

    //two nodes are swapped in BST violating the BST property we need to find them out
    //we will use the property of inorder traversal of BST where all elements are sorted and we will find out two nodes
    //in first we store the previous value in second we store the current value
    public static void fix(Node root){
        if(root==null)
            return;
        fix(root.left);
        if(prev!=null && prev.key>=root.key){
            //stores the first violation
            if(first==null){
                first=prev;
            }
            //stores second violation
            second=root;
        }
        prev=root;
        fix(root.right);
    }
}
