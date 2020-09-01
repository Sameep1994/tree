package BST;

import java.util.*;

public class TopView {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node (30);
        root.left.right = new Node(40);
        root.right = new Node(50);

        Tview(root);
    }

    /*we will use the idea of horizontal distance and vertical traversal by level order traversal, just with a minor change that
    * we wont add the value if it exists*/
    public static void Tview(Node root){
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> tm = new TreeMap<>();
        q.add(new Pair(root,0));
        while (q.isEmpty()==false){
            Pair curr = q.poll();
            if(tm.containsKey(curr.hd)){
//                tm.get(curr.hd).add(curr.root.key);
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

