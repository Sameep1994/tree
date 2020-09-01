package BST;

public class FloorBST {
    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 7);
        insert(root, 10);
        insert(root, 5);
        insert(root, 3);
        insert(root, 6);
        insert(root, 8);
        insert(root, 12);

        System.out.println(floor(root,9).key);
    }
//floor is the value less than the key and closest to the key
    public static Node floor(Node root, int x){
        Node res = null;
        while (root!=null){
//if the key in found in tree return that
            if(root.key==x) {
                return root;
            }
//if node is greater than the key means the valus lesser to it will be found on left
            else if(root.key>x) {
                root = root.left;
            }
 //if the value is less it can be the answer store that and to find a value lesser move to the left
            else {
                res = root;
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
