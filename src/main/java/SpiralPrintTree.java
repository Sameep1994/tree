import java.util.Stack;

public class SpiralPrintTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        printSpiral(root);
    }
/*We use 2 stack here level 1 in first stack level 2 in second and we move alternatively
* for odd num level first right child must be pushed and then left in order to get the spiral order*/
    public static void printSpiral(Node root){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (s1.isEmpty()==false || s2.isEmpty()==false){
            while(s1.isEmpty()==false){
                Node curr = s1.pop();
                if(curr.left!=null)
                    s2.push(curr.left);
                if(curr.right!=null)
                    s2.push(curr.right);
                System.out.println(curr.key);
            }
//right child first here Important
            while (s2.isEmpty()==false){
                Node curr = s2.pop();
                if(curr.right!=null)
                    s1.push(curr.right);
                if(curr.left!=null)
                    s1.push(curr.left);
                System.out.println(curr.key);
            }
        }
    }
}
