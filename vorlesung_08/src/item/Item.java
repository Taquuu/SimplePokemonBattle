package item;

public class Item {

	public String _name;
	public enum Types {CONSUMABLE, POKEBALL};
	public Types _type;
	private float price;
	
	
	public Item(String name, Types type, float price)
	{
		setName(name);
		setType(type);
		this.price = price;
	}
	
	void setName(String name)
	{
		_name = name;
	}
	
	void setType(Types type)
	{
		_type = type;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public Types getType()
	{
		return _type;
	}
	
	public float getPrice()
	{
		return price;
	}
	
	public String toString()
	{
		String iteminfo = new String();
		return iteminfo;
	}
	
	/*void use()
	{
		if (this.)
	}*/
	
	
	
}
