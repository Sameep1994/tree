public class Diameter {
    public static int res=0;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        dia(root);
        System.out.println(res);
    }

    //diameter is longest path b/w two leaf nodes
    /*we are using height of every node and using it we are finding the diameter*/
    public static int dia(Node root){
        if(root == null)
            return 0;
        int lh = dia(root.left);
        int rh = dia(root.right);
        //1+ lh and rh for any node the max distance of all is diameter
        res = Math.max(res,1+lh+rh);
        return (1+Math.max(lh,rh));
    }
}
