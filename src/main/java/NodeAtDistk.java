public class NodeAtDistk {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        printNode(root,2);
    }
//needs revisit
    public static void printNode(Node root,int k){
        if(root == null)
            return;
        if(k==0) {
            System.out.println(root.key + " ");
        }else {
            printNode(root.left, k - 1);
            printNode(root.right, k - 1);
        }
    }
}
