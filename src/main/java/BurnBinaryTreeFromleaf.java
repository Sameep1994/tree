
public class BurnBinaryTreeFromleaf {
    public static int res=0;
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.left.left.left=new Node(60);
        root.left.left.left.left=new Node(70);
        Distance dist=new Distance(-1);
        int leaf=50;

       burnTime(root,leaf,dist);

        System.out.println(res);
    }
/*
* Problem: at 0th second the given leaf is burnt at 1st second its adjacent ie children and parent are burnt then at 2nd second their adjacent are burnt and so on
*find time taken
*
* idea: we have to find the farthest node reachable through one of the ancestors
*
*
*
*
* */

//Needs revision
public static int burnTime(Node root, int leaf, Distance dist){
    if(root==null)return 0;
    if(root.key==leaf){dist.val=0;return 1;}
    //init left and right distance as -1
    Distance ldist=new Distance(-1),rdist=new Distance(-1);
    //returns left height and sets ldist
    int lh=burnTime(root.left,leaf,ldist);
    //return right height and sets rdist
    int rh=burnTime(root.right,leaf,rdist);
//calculating the left and right distance
//finds if the node is ancestor and finds the height
    if(ldist.val!=-1){
        dist.val=ldist.val+1;
        res=Math.max(res,dist.val+rh);
    }
    else if(rdist.val!=-1){
        dist.val=rdist.val+1;
        res=Math.max(res,dist.val+lh);
    }
    return Math.max(lh,rh)+1;
}
}
class Distance{
    int val;
    Distance(int d){
        this.val=d;
    }
}
