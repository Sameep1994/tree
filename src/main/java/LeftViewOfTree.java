
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeftViewOfTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        left(root);
        System.out.println("----");
        leftDfs(root);

    }
//for every node we are recursively calling for left child if left is missing we call right
    public static void left(Node root){
        if(root==null)
            return;
        else {
            System.out.println(root.key);
            if(root.left==null){
                left(root.right);
            }else{
                left(root.left);
            }
        }
    }
//DFS solution, robust
    public static List<Integer> leftDfs(Node root){
        List<Integer> ans = new LinkedList<>();
        if(root==null)   return ans;
        Deque<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Node node = q.poll();
                if(i==0){
                    ans.add(node.key);
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null)    q.add(node.right);
            }
        }
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
        return ans;
    }
}
