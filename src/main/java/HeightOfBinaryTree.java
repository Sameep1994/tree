public class HeightOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);
        System.out.println(sizeOfTree(root));
    }
//traverse till last node
    public static int sizeOfTree(Node root){
        if(root==null)
            return 0;
        else
            return Math.max(sizeOfTree(root.left),sizeOfTree(root.right))+1;
    }
}
