package Editor;

import java.util.Optional;
import java.lang.IllegalArgumentException;

import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ListView;

import Editor.Items.*;
import MathFunction.*;

class EditHandler implements EventHandler<ActionEvent>
{

	ObservableList<Item> referencedList;
	ListView<Item> referencedListView;

	protected EditHandler ( ObservableList<Item> list, ListView<Item> listView )
	{
		super();
		this.referencedList = list;
		this.referencedListView = listView;
	}

	@Override
	public void handle(ActionEvent event)
	{ 

		Item toEdit = referencedListView.getSelectionModel().getSelectedItem();
		if ( !( toEdit == null) )
		{

			TextInputDialog dialog;

			try
			{
				

				if ( toEdit instanceof Container )
				{
					Container cont = (Container) toEdit;
					if ( cont.getData() instanceof Integer || cont.getData() instanceof Double )
					{
						@SuppressWarnings("unchecked")
						Container<Integer> contInt = cont;
						int oldVal = (int) contInt.getData();
						dialog = new TextInputDialog( Integer.toString( oldVal ) );
						dialog.setTitle("Edit value:");
						dialog.setHeaderText("Old value: " + oldVal );
						dialog.setContentText("New value: ");

						Optional<String> result = dialog.showAndWait();
						if (result.isPresent() && !result.get().equals("") )
						{
							Integer newVal = Integer.parseInt( result.get() );
							contInt.setData( newVal );
							// do something with result == input   with    result.get()
							//Item newItem = new Item( result.get() );
							//this.referencedList.add( null );
							referencedListView.refresh();
						} else
						{
							throw new IllegalArgumentException();
						}


					}
					else if ( cont.getData() instanceof Polynomial )
					{
						
					}
					else
					{
						
					}
				
				//this.setText( item.display() + " :int: " + cont );
				}
				else
				{
					
				}
				/*if ( item instanceof Container<Double> )
				{
					Container<Double> cont = (Container<Double>) item;
					circ.setFill(Color.BLUE);
					this.setText( item.display() + " :double: " + cont );
				}*/

			} catch ( IllegalArgumentException e )
			{
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Error");
					alert.setHeaderText("Error while editing");
					alert.setContentText("Invalid input");

					alert.showAndWait();
			}

		}
		
	}

}
