package data_algorithm_binary_search;

public class AVLTest {
    public static void main(String[] args) {

        AVLTree at = new AVLTree();
        AVLNode t;
        AVLNode position;
        int i;
        int j = 0;
        t = at.makeEmpty(null);

        for(i=0; i<50; i++, j = (j+7)%50) {
            t = at.insert(j,t);
        }

        for(i=0; i<50; i++) {
            if ((position = at.find(i, t)) == null || at.retrieve(position) != i)
                System.out.println("Error at " + i);
        }
        System.out.println("Min is "+at.retrieve(at.findMin(t))+"Max is "+at.retrieve(at.findMax(t)));	at.preOrder(t);

    }


}
