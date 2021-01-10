import java.util.ArrayList;
import java.util.PriorityQueue;

public class SerializeAndDeserialize {
    public static int index=0;
    public static int empty = -1;
    public static void main(String[] args) {

        PriorityQueue<Integer>pq= new PriorityQueue<>();
        pq.add(10);
        pq.remove();

    }
    //Revision
//whenever we are getting a null we are inserting -1 in array, it is preorder traversal
    public void Serialize(Node root,ArrayList<Integer> a){
        if(root==null){
            a.add(empty);
            return;
        }
        a.add(root.key);
        Serialize(root.left,a);
        Serialize(root.right,a);
    }

    public static Node Deserialize(ArrayList<Integer> list){
        //when last element of array is encountered
        if(index == list.size())
            return null;
        int val = list.get(index);
        index++;
        //when null is encountered
        if(val == -1)
            return null;
        //node initialized
        Node root = new Node(val);
        root.left = Deserialize(list);
        root.right = Deserialize(list);
        return root;
    }
}
