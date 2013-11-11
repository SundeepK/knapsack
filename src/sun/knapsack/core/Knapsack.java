package sun.knapsack.core;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Knapsack  {
	
	List<Item> _items;
	List<List<Integer>> _vMatrix;
	List<List<Integer>> _keepMatrix;
 
	public Knapsack(List<Item> items_){
		_items = items_;
		_vMatrix = new LinkedList<List<Integer>>();
		_keepMatrix = new LinkedList<List<Integer>>();
	}
	
	public List<Item> getOptimalItems(int maxCapacity_){
		sortItems(_items);
		
		System.out.println(_items.toString());
		
		_vMatrix.add(getEmptyRow(maxCapacity_));
			
		_keepMatrix.add(getEmptyRow(maxCapacity_));

		populateMatrices(maxCapacity_);
		
		for (List<Integer> row : _keepMatrix) {
				System.out.println(row.toString());
		}
		List<Item> optimalItems = getItems(maxCapacity_);
		
		return optimalItems;
	}
	
	private List<Item> getItems(int maxCapacity_) {
		int maxCap = maxCapacity_;
		List<Item> optimalItems = new LinkedList<Item>();
		for(int itemNum = _items.size(); itemNum > 0; itemNum--){
			List<Integer> keepRow = _keepMatrix.get(itemNum);
				if(keepRow.get(maxCap-1) == 1){
					optimalItems.add(_items.get(itemNum-1));
					maxCap = maxCap - _items.get(itemNum-1).getWeight();
				}		
		}
	
		return optimalItems;
	}

	private void populateMatrices(int maxCapacity_) {
		for (int itemNum = 0; itemNum < _items.size(); itemNum++) {
			int weight = 0;
			List<Integer> vRow = new LinkedList<Integer>();
			List<Integer> keepRow = new LinkedList<Integer>();

			int itemWeight = _items.get(itemNum).getWeight();
			int itemValue = _items.get(itemNum).getValue();

			List<Integer> previousRow = _vMatrix.get(itemNum);

			// System.out.println(previousRow.toString());

			while (weight < maxCapacity_) {
				weight++;

				if (weight >= itemWeight) {
					int previousValue = previousRow.get(weight - 1);
					int index = ((weight - 1) - itemWeight) < 0 ? (itemWeight - (weight - 1)): ((weight - 1) - itemWeight);
					int newValue = itemValue + previousRow.get(index);

					if (newValue > previousValue) {
						vRow.add(newValue);
						keepRow.add(1);
					} else {
						vRow.add(previousValue);
						keepRow.add(0);
					}

				} else {
					keepRow.add(0);
					int y = previousRow.get(weight - 1);
					vRow.add(y);
				}
			}
			_vMatrix.add(vRow);
			_keepMatrix.add(keepRow);
		}

	}
	
	private void sortItems(List<Item> items_){
		Collections.sort(items_, new ItemComparator());			
	}
	
	private List<Integer> getEmptyRow(int maxCap_){
		List<Integer> empty = new LinkedList<Integer>();
		for(int i = 0; i <maxCap_; i++){
			empty.add(0);
		}
		return empty;
	}
	
}
