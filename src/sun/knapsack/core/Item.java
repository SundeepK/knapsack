package sun.knapsack.core;

import java.util.Comparator;

public class Item  {

	private String _name;
	private int _weight;
	private int _value;
	
	public Item(String name_, int value_, int weight_){
		_name= name_;
		_weight = weight_;
		_value = value_;
	}

	public String getName() {
		return _name;
	}

	public int getWeight() {
		return _weight;
	}

	public int getValue() {
		return _value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Name: " );
		builder.append(_name);
		builder.append(" weight :");
		builder.append(_weight);
		builder.append(" value :");
		builder.append(_value);
	 return	builder.toString();
	}

		
	
}
