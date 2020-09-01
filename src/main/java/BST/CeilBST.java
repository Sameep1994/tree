package BST;

public class CeilBST {
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 7);
        insert(root, 10);
        insert(root, 5);
        insert(root, 3);
        insert(root, 6);
        insert(root, 8);
        insert(root, 12);

        System.out.println(ceil(root,9).key);
    }

    public static Node ceil(Node root,int x){
        Node res = null;
        while (root!=null){
 //if key is found in tree return that
            if(root.key==x) {
                return root;
            }
  //if the value of root is greater store that and move to left of tree to find a val closer
            else if(root.key>x) {
                res = root;
                root = root.left;
            }
   //move to right of the tree
            else {
                root = root.right;
            }
        }
        return res;
    }

    public static Node insert(Node root, int key)
    {
        if (root == null)
            return new Node(key);
        if (key < root.key)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }
}
