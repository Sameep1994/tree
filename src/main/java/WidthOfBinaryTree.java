import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(width(root));

    }

    public static int width(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int curr_val=0,max_val=0;
        while (q.isEmpty()==false) {
            int count = q.size();
            curr_val = count;
            max_val = Math.max(curr_val, max_val);
            //before this loop starts we know only one level is in it
            //we are traversing that level and printing
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return max_val;
    }
}
