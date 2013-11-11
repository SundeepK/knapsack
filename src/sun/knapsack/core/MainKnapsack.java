package sun.knapsack.core;

import java.util.LinkedList;
import java.util.List;

public class MainKnapsack {

	public static void main(String[] args){
		List<Item> items = new LinkedList<Item>();
		items.add(new Item("Item 1", 5, 3));
		items.add(new Item("Item 2", 3, 2));
		items.add(new Item("Item 3", 4, 1));	
		
		Knapsack knapsack = new Knapsack(items);
		List<Item> optimalItems = knapsack.getOptimalItems(5);
//		for(Item item : optimalItems){
			System.out.println(optimalItems.toString());
//		}
		
	}
	

	
	
}
