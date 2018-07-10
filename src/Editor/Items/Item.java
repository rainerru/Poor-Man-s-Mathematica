package Editor.Items;

public class Item
{

	private String text;

	public String display () { return this.text; }

	public void edit ( String newText ) { this.text = newText; }

	public Item ( String text ) { this.text = text; }

}
