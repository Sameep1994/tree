package BST;

public class kthSmallest {
    //naive sol do inorder traversal till k
    public static void main(String[] args) {

    }
/*compare k with lcount+1 of current Node
* case 1:if same return Node
* case 2 if gt recurr for left with same k
* case 3 if smaller recurr for right with k as (k-lcount-1)
*
*
* have to update lcount while updates, better approaches for this problem available*/

    public static TreeNode ksmall(TreeNode root, int k){
        if(root.lcount ==k)
            return root;
        else if(root.lcount>k)
            ksmall(root.left,k);
        else
            ksmall(root.right,(k-root.lcount-1));
        return root;
    }
}

class TreeNode{
    int key;
    TreeNode left, right;
    int lcount;

    public TreeNode(int item)
    {
        key = item;
        left = right = null;
    }
}
