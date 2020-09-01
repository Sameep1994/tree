public class MaxOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println(maximumOftree(root));
    }

    public static int maximumOftree(Node root){
        if(root==null) {
            return Integer.MIN_VALUE;
        }
        else {
            return Math.max(root.key, (Math.max(maximumOftree(root.left), maximumOftree(root.right))));
        }
    }
}
