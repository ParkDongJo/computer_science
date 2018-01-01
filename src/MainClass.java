import data_algorithm_binary_search.AVLNode;
import data_algorithm_binary_search.AVLTree;

public class MainClass {
    public static void main(String [ ] args) {
        //자료구조 테스트



        AVLTree at = new AVLTree();

        AVLNode t;

        AVLNode position;

        int i;

        int j = 0;

        t = at.makeEmpty(null);

        for(i=0; i<50; i++, j = (j+7)%50)

            t = at.insert(j,t);

        for(i=0; i<50; i++)

            if((position = at.find(i,t)) == null ||	at.retrieve(position) != i)

                System.out.println("Error at "+i);

        System.out.println("Min is "+at.retrieve(at.findMin(t))+	" Max is "+at.retrieve(at.findMax(t)));	at.preOrder(t);

    }
}
