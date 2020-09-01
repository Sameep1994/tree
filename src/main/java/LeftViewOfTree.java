public class LeftViewOfTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        left(root);

    }
//for every node we are recursively calling for left child if left is missing we call right
    public static void left(Node root){
        if(root==null)
            return;
        else {
            System.out.println(root.key);
            if(root.left==null){
                left(root.right);
            }else{
                left(root.left);
            }
        }
    }
}
