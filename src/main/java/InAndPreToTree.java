public class InAndPreToTree {
    public static int preIndex=0;
    public static void main(String[] args) {
        int[] in ={20,10,40,30,50};
        int[] pre ={10,20,30,40,50};

        printInorder(buildTree(in,pre,0,4));
    }
    /*we are given with pre and inorder traversal we need to construct the tree
    * to construct a tree we need inorder traversal along with another traversal
    * the pre traversal gives the root node ie the node occuring first in in order is root
    * in  inorder the nodes to its left and right are its respective subtree
    */

    /*we start with 0th node of pre order traversal and recursively call the function for its left and right part in in order array*/

    public static Node buildTree(int[] in,int[] pre,int is,int ie){
        if(is>ie)
            return null;
        Node root = new Node(pre[preIndex++]);
        int inIndex=0;
        for(int i=is;i<=ie;i++){
            if(in[i]==root.key){
                inIndex=i;
                break;
            }
        }
        root.left=buildTree(in,pre,is,inIndex-1);
        root.right=buildTree(in,pre,inIndex+1,ie);
        return root;
    }

    public static void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

}
