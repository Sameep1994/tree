package BST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test {
    public static HashMap<Integer,Integer> hDist = new HashMap<>();
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left=new Node(5);
        root.right= new Node(1);
        root.left.left=new Node(6);
        root.left.right=new Node(2);
        root.left.right.left=new Node(7);
        root.left.right.right=new Node(4);
        root.right.left= new Node(0);
        root.right.right= new Node(8);

        Node target = new Node(5);
        int K = 2;

        distanceK(root,target,K);

    }


    public static List<Integer> distanceK(Node root, Node target, int K) {
        List<Integer> res = new ArrayList<>();
        findDistance(root,0);
        int aux=hDist.get(target.key);
        for(Integer t: hDist.keySet()){
            if(t==target.key){
                continue;
            }
            int temp = hDist.get(t);
            if(Math.abs(temp)==Math.abs(aux-K)||Math.abs(temp)==Math.abs(aux+K)){
                res.add(t);
            }
        }
        return res;
    }

    public static void findDistance(Node root,int dist){
        if(root==null){
            return;
        }
        hDist.put(root.key,dist);
        findDistance(root.left,dist-1);
        findDistance(root.right,dist+1);
    }
}
