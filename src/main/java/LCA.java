public class LCA {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println(lca(root,4,5).key);
    }
//revision
//assumption is both are present in the tree
    public static Node lca(Node root,int n1,int n2){
        if(root==null)
            return null;
        //first case if either of node is the root node
        if(root.key==n1 || root.key==n2)
            return root;
        //recursively calling for children
        Node lca1 = lca(root.left,n1,n2);
        Node lca2 = lca(root.right,n1,n2);
//case 2 when one node is in one sub tree and one in another
        if(lca1 !=null && lca2!=null)
            return root;
        //case 3 and 4 if one contains or none contains
        if(lca1!=null)
            return lca1;
        else
            return lca2;
    }
}
