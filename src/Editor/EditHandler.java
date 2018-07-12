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


			try
			{
				TextInputDialog dialog;
				dialog = new TextInputDialog( toEdit.display() );
				dialog.setTitle("Editing...:");
				dialog.setHeaderText("Old: " + toEdit.display() );
				dialog.setContentText("something: ");




			if ( toEdit instanceof Container )
			{
				Container cont = (Container) toEdit;
				if ( cont.getData() instanceof Integer || cont.getData() instanceof Double )
				{
					//Container<Integer> cont1 = (Container<Integer>) cont;
					this.setText( toEdit.display() + " :int: " + cont.getData() );
					circ.setFill(Color.RED);
				}
				else if ( cont.getData() instanceof Polynomial )
				{
					this.setText( toEdit.display() + " :polynomial: " + cont.getData() );
					circ.setFill(Color.BLUE);
				}
				else
				{
					this.setText( "its a container but whats inside??? :: " + toEdit.display() );
					circ.setFill(Color.GRAY);
				}
				
				//this.setText( item.display() + " :int: " + cont );
			}
			else
			{
				this.setText( toEdit.display() );
				circ.setFill(Color.WHITE);
			}
			/*if ( item instanceof Container<Double> )
			{
				Container<Double> cont = (Container<Double>) item;
				circ.setFill(Color.BLUE);
				this.setText( item.display() + " :double: " + cont );
			}*/

			setGraphic(circ);








				Optional<String> result = dialog.showAndWait();
				if (result.isPresent() && !result.get().equals("") )
				{
					// do something with result == input   with    result.get()
					//Item newItem = new Item( result.get() );
					//this.referencedList.add( newItem );
				} else
				{
					throw new IllegalArgumentException();
				}

			} catch ( IllegalArgumentException e )
			{
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Error");
					alert.setHeaderText("Error while adding a book");
					alert.setContentText("Invalid input for a book or canceled!");

					alert.showAndWait();
			}

		}
		
	}

}
