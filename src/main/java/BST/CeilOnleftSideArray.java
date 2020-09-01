package BST;

import java.util.TreeSet;

public class CeilOnleftSideArray {
    public static void main(String[] args) {
        int[] a= {2,8,30,15,25,12};
        ceil(a);
    }
//we are using a self balancing bst and its ceil function
    //add all element in tree and find ceil out of existing elements
    public static void ceil(int[] a){
        TreeSet<Integer> ts = new TreeSet<>();
        //for first element its always -1
        //adding first element in tree print -1 and start from second element
        System.out.println(-1);
        ts.add(a[0]);
        for(int i=1;i<a.length;i++){
            Integer c = ts.ceiling(a[i]);
            if(c!=null){
                System.out.println(ts.ceiling(a[i]));
            }else {
                System.out.println(-1);
            }
            //add element at last else it will give self value as ceil
            ts.add(a[i]);
        }
    }
}
