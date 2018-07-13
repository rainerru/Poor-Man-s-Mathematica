package Editor.Items;

public class Container <T> extends Item
{

	public final boolean isEditable;
	private T data;

	public T getData () { return this.data; }

	public void setData ( T data )	{	if ( this.isEditable ) this.data = data; }

	public Container ( String text )
	{
		super( text );
		this.isEditable = true;
	}
	
	public Container ( String text, boolean isEditable, T data )
	{
		super( text );
		this.isEditable = isEditable;
		this.data = data;
	}

}
