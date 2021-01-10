public class NodeAtDistk {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);
        printNode(root,2);
    }
//prints all the nodes at distance k from it, so we pass the node and k as an argument and at each traversal we decrease k
//when k becomes 0 that means we are at the desired node and print it
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
