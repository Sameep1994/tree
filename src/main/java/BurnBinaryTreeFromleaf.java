public class BurnBinaryTreeFromleaf {
    public static int res=0;
    public static void main(String[] args) {

    }
//Needs revision
    public static int burn(Node root,Distance dist,int leaf){
        if(root==null)
            return 0;
        if(root.key==0){
            dist.val=0;
            return 1;
        }
        //all the descendants are marked as -1
        Distance ldist = new Distance(-1);
        Distance rdist = new Distance(-1);
        //returns left and right height and sets the ldist and rdist
        int lh = burn(root,ldist,leaf);
        int rh = burn(root,rdist,leaf);
//returns the ancestors
/*
*           N
*       /      \
*      L
*         \
*           R
* from R to N all the burns we are adding the left side to right
* */
        if(ldist.val==-1){
            dist.val=ldist.val+1;
            res=Math.max(res,dist.val+rh);
        }else if(rdist.val==-1){
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
