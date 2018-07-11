package Editor;

import javafx.scene.control.ListCell;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import Editor.Items.*;

class MCell extends ListCell<Item>
{

	@Override
			protected void updateItem ( Item item, boolean empty )
			{
				super.updateItem(item, empty);

				Rectangle rect = new Rectangle(20, 20);
				if (item != null)
				{
					rect.setFill(Color.RED);
					setGraphic(rect);
				}

				if ( empty || item == null || item.display() == null ) { setText(null); }
				else { setText( item.display() ); }

			}

}
