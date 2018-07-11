package Editor;

import javafx.scene.control.ListCell;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;

import Editor.Items.*;

import MathFunction.*;

class MCell extends ListCell<Item>
{

	@Override
	protected void updateItem ( Item item, boolean empty )
	{

		super.updateItem(item, empty);

		// use stringbuilder???

		Circle circ = new Circle(5);

		if ( empty || item == null )
		{
			this.setGraphic(null);
			this.setText(null);
		}

		if ( item != null && item.display() != null )
		{
			if ( item instanceof Container )
			{
				Container cont = (Container) item;
				if ( cont.getData() instanceof Integer || cont.getData() instanceof Double )
				{
					//Container<Integer> cont1 = (Container<Integer>) cont;
					this.setText( item.display() + " :int: " + cont.getData() );
					circ.setFill(Color.RED);
				}
				else if ( cont.getData() instanceof Polynomial )
				{
					this.setText( item.display() + " :polynomial: " + cont.getData() );
					circ.setFill(Color.BLUE);
				}
				else
				{
					this.setText( "its a container but whats inside??? :: " + item.display() );
					circ.setFill(Color.GRAY);
				}
				
				//this.setText( item.display() + " :int: " + cont );
			}
			else
			{
				this.setText( item.display() );
				circ.setFill(Color.WHITE);
			}
			/*if ( item instanceof Container<Double> )
			{
				Container<Double> cont = (Container<Double>) item;
				circ.setFill(Color.BLUE);
				this.setText( item.display() + " :double: " + cont );
			}*/

			setGraphic(circ);
		}

	}

}
