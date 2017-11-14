package data_algorithm_theory;

import java.util.Comparator;

/**
 * Created by parkdongjo on 2017. 10. 5..
 */
public class MaxComparator implements Comparator<Integer>
{
    public int compare( Integer x, Integer y )
    {
        return y - x;
    }
}
