package Editor.Items;

public class Container <T> extends Item
{

	public final boolean isEditable;
	private T data;

	public T getData () { return this.data; }

	public void editData ( T data )	{	if ( this.isEditable ) this.data = data; }

	public Container ( String text )
	{
		this.text = text;
		this.isEditable = true;
	}
	
	public Container ( String text, boolean isEditable, T data )
	{
		this.text = text;
		this.isEditable = isEditable;
		this.data = data;
	}

}
