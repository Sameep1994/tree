public class LCA {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println(lowestCommonAncestor(root,4,5).key);
    }

/*
here we are trying the find lowest common ancestor and by lowest we mean the one in closest level
*
*
* */


//assumption is both are present in the tree
    public static Node lowestCommonAncestor(Node root,int p,int q){
        //finding left and right, the root at which they split to left and right subtree is lca
        if(root == null || root.key == p || root.key == q)  return root;
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        //split
        if(left != null && right != null)   return root;
        //return the subtree where both resides either left or right
        return left != null ? left : right;
    }
}
