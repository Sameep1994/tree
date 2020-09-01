package BST;

import java.util.*;

public class VerticalTreaversalBT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node (30);
        root.left.right = new Node(40);
        root.right = new Node(50);

        vTrav(root);
    }

    /*
    * here we will use level order traversal since we want to print the nodes in order left to right
    *
    * we will use the sam econcept of horizontal distance and store it in a map to print*/
    public static void vTrav(Node root){
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> tm = new TreeMap<>();
        q.add(new Pair(root,0));
        while (q.isEmpty()==false){
            Pair curr = q.poll();
            if(tm.containsKey(curr.hd)){
                tm.get(curr.hd).add(curr.root.key);
            }else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(curr.root.key);
                tm.put(curr.hd,al);
            }
            if(curr.root.left!=null)
                q.add(new Pair(curr.root.left,curr.hd-1));
            if(curr.root.right!=null)
                q.add(new Pair(curr.root.right,curr.hd+1));

        }
        //print values
        for(Map.Entry<Integer,ArrayList<Integer>> entry : tm.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
//since we have to manipulate the hd for child nodes while adding in queue
class Pair{
    Node root;
    int hd;

    public Pair(Node root, int hd) {
        this.root = root;
        this.hd = hd;
    }
}