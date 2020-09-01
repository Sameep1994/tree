package BST;

import java.util.HashSet;

public class BSTPairSum {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(20);
        root.right.left = new Node(13);
        root.right.right = new Node(24);
        System.out.println(isPair(root,18,hs));

    }

    //do inorder traversal, store values in hashset when the pair is found boolean is returned
    //we use the hashset to compare on the go so that as soon as the pair is found we stop computation
    public static boolean isPair(Node root, int sum, HashSet<Integer> hs){
        if(root == null)
            return false;
        if(isPair(root.left,sum,hs)==true)
            return true;
        if(hs.contains(sum-root.key))
            return true;
        hs.add(root.key);
        return isPair(root.right,sum,hs);
    }
}
