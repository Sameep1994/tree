public class SizeOfBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println(size(root));
    }

    public static int size(Node root){
        if(root==null)
            return 0;
        else
            return 1+size(root.left)+size(root.right);
    }
}
