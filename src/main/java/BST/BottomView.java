package BST;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node (30);
        root.left.right = new Node(40);
        root.right = new Node(50);

        Bview(root);

    }
    /*Same logic as top view just use the reverse and let the map store the latest value of level order traversal
    **/
    public static void Bview(Node root){
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> tm = new TreeMap<>();
        q.add(new Pair(root,0));
        while (q.isEmpty()==false){
            Pair curr = q.poll();
            if(tm.containsKey(curr.hd)){
                //stores the latest value
                tm.remove(curr.hd);
                tm.put(curr.hd,curr.root.key);
            }else {
//                ArrayList<Integer> al = new ArrayList<>();
//                al.add(curr.root.key);
                tm.put(curr.hd,curr.root.key);
            }
            if(curr.root.left!=null)
                q.add(new Pair(curr.root.left,curr.hd-1));
            if(curr.root.right!=null)
                q.add(new Pair(curr.root.right,curr.hd+1));

        }
        //print values
        for(Map.Entry<Integer, Integer> entry : tm.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
