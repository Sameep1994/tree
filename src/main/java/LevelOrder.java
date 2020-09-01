import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        //printLevelOrder(root);
        //printLevelOrderLineByLine(root);
        printLevelOrderLineByLine2(root);
    }

//we are using queue here and printing each node and if its child is not null adding that to the queue
    public static void printLevelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.isEmpty()==false){
            Node curr = q.peek();
            q.remove();
            System.out.println(curr.key);
            //this enqueues the next level
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
    }

    public static void printLevelOrderLineByLine(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (q.isEmpty()==false){
            Node curr = q.poll();
            // condition to check the
            // occurence of next level
            if(curr==null){
                if (!q.isEmpty()) {
                    q.add(null);
                    System.out.println();
                }
            }else {
                System.out.print(curr.key + " ");
                //this enqueues the next level

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }

    public static void printLevelOrderLineByLine2(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.isEmpty()==false){
            int count = q.size();
            //before this loop starts we know only one level is in it
            //we are traversing that level and printing
            for(int i=0;i<count;i++){
                Node curr = q.poll();
                System.out.print(curr.key+" ");
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            System.out.println();
        }
    }
}
