public class SumOfRootToLeaf {
    static int rootToLeaf=0;

    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(0);
        a.right = new Node(1);
        a.left.left = new Node(0);
        a.left.right = new Node(1);
        a.right.left = new Node(0);
        a.right.right = new Node(1);
        System.out.println(sumRootToLeaf(a));
    }
//leetcode 1022, here we are trying to convert root->leaf binary num to decimal in a binary tree and sum it
    /*
    *           1
    *          /  \
    *        0      1
    *    left 10=2 right 11=3
    * */
    public static void preorder(Node r, int currNumber) {
        if (r != null) {
            //this takes care of binary to decimal yusing bit operator
            currNumber = (currNumber << 1) | r.key;
            // if it's a leaf, update root-to-leaf sum
            if (r.left == null && r.right == null) {
                rootToLeaf += currNumber;
            }
            preorder(r.left, currNumber);
            preorder(r.right, currNumber);
        }
    }

    public static int sumRootToLeaf(Node root) {
        preorder(root, 0);
        return rootToLeaf;
    }
}
