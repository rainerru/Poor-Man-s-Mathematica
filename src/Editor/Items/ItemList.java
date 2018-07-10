package Editor.Items;

import java.util.LinkedList;

public class ItemList implements Item
{

	private LinkedList<Item> listOfItems;

	public ItemList ( String text )
	{
		super(text);
		this.listOfItems = new LinkedList<Item>();
	}

	public ItemList ( String text, LinkedList<Item> list )
	{
		super(text);
		this.listOfItems = list;
	}

	public void add ( Item newItem ) { this.listOfItems.add(newItem); }

	public void remove ( Item oldItem ) { this.listOfItems.remove(oldItem); }

	/**
	 * Searches for an item with the name specified in the argument by iterating thorugh the
	 * list. If no such item is found, null is returned.
	 *
	 * @param		name	the method will search for an Item with this name
	 * @return				this (or an, if there are several) Item which has this name
	 */
	/*public Item search ( String name )
	{
		if ( this.getName().equals(name) ) return this;

		Iterator<Item> itemIterator = listOfItems.iterator();
		Item currentItem;
		while ( itemIterator.hasNext() ) {

			currentItem = itemIterator.next();
			if ( currentItem.getName().equals(name) ) return currentItem;
			if ( currentItem instanceof ItemList )
			{
 				currentItem = ((ItemList)currentItem).search(name);
				if ( currentItem != null ) return currentItem;
			}

		}
		return null;
	}*/

}
