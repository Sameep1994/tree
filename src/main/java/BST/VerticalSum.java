package BST;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node (30);
        root.left.right = new Node(40);
        root.right = new Node(50);
        Vsum(root);
    }
    //here we need to find sum of vertical values
    /*
    *           1
    *       /       \
    *     2         3
    *       \4
    * since 1 and 3 are alinged res will be 2 5 3
    * we use a value called horizontal distance for root it will be 0 for left child dec by 1 and right child inc by 1
    * store corrspoinding hd and sum in a treemap traverse the tree map and print it
    * */

    public static void Vsum(Node root){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        VsumR(root,map,0);
        for(Map.Entry sum:map.entrySet()){
            System.out.println(sum.getValue());
        }
    }

    public static void VsumR(Node root,TreeMap<Integer,Integer> map, int hd){
        if(root==null) {
            return;
        }
        VsumR(root.left,map,hd-1);
        int prevSum = (map.get(hd)==null) ? 0 :  map.get(hd);
        map.put(hd,root.key+prevSum);
        VsumR(root.right,map,hd+1);
    }
}
