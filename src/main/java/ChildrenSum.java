public class ChildrenSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        System.out.println(isChildSum(root));
    }
//here we are adding the value of left and right checking if its equal to parent and recursively calling the func for its left and right child
    public static boolean isChildSum(Node root){
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        int sum=0;
        if(root.left!=null)
            sum+=root.left.key;
        if(root.right!=null)
            sum+=root.right.key;
        return (sum==root.key &&
                isChildSum(root.left) &&
                isChildSum(root.right));
    }
}
