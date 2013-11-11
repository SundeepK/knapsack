package sun.knapsack.core;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {

	      int result = compare(o1.getValue(),(o2.getValue()));
	        if (result != 0)
	        {
	            return result;
	        }
		       result = compare(o1.getWeight(),(o2.getWeight()));

		return 0;
	}
	

	public  int compare(int x, int y) {
	    return x < y ? -1
	         : x > y ? 1
	         : 0;
	}

}
