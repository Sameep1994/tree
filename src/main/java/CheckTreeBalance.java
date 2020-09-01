public class CheckTreeBalance {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        System.out.println(isBal(root));
    }
    //a tree is balanced if the left and right sub tree diff is not more than 1
    //we return -1 else we return the height, we use height to calculate if the given tree is balanced
    public static int isBal(Node root){
        if(root == null)
            return 0;
        //checking if left sub tree is balanced
        int lh = isBal(root.left);
        if(lh == -1)
            return -1;
        //checking if right sub tree is balanced
        int rh = isBal(root.right);
        if(rh==-1)
            return -1;
        //checking if the parent node of the sub tree is balanced
        if(Math.abs(lh-rh)>1)
            return -1;
        return Math.max(lh,rh)+1;
    }
}
