public class NumOfNodeCompleteBT {
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.right.left=new Node(40);
        root.right.right=new Node(50);

        System.out.println(numOfNode(root));
    }

    //it uses tha advantage of fact that in complete bin tree the all but last node has all nodes
    public static int numOfNode(Node root){
        if(root==null)
            return 0;
        Node curr = root;
        int lh=0,rh=0;
        while (curr!=null){
            lh++;
            curr=curr.left;
        }
        curr=root;
        while (curr!=null){
            rh++;
            curr=curr.right;
        }
        //till we have the left and right height balanced we return the total nodes by formuls 2^n-1
        if(lh==rh)
            return (int) ((Math.pow(2,lh))-1);
        //where its not we count manually the nodes on that sub tree
        return 1+numOfNode(root.left)+numOfNode(root.right);
    }
}
