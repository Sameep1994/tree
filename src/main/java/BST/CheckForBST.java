package BST;

public class CheckForBST {
    public static int prev=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(20);
        root.right.left = new Node(13);
        root.right.right = new Node(24);

        System.out.println(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println(isBstIn(root));
    }
//important
    /*Recursive sol to check the left and right subtree is false because
    it doesnt check for node at distance more than 1 and gives wrong op
    *
    *
    * pass range for all nodes
    * for root its - to + infinity
    *for left subtree we change the upper bound
    * for right subtree change the lower bound
    * */

    public static boolean isBST(Node root,int min,int max){
        if(root==null)
            return true;
        return (root.key>min &&
                root.key<max &&
                isBST(root.left,min,root.key) &&
                isBST(root.right,root.key,max));

    }

    //inorder traversal can be used and the o/p must be in increasing order
    public static boolean isBstIn(Node root){
        if(root == null)
            return true;
        //call for left
        if(isBstIn(root.left)==false)
            return false;
        //check the BST property
        if(prev>=root.key)
            return false;
        //updating previous
        prev = root.key;
        //calling for right sub tree
        return isBstIn(root.right);
    }
}
