package Editor;

import java.util.Optional;
import java.lang.IllegalArgumentException;

import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

import Editor.Items.*;

class AddHandler implements EventHandler<ActionEvent>
{

	ObservableList<Item> referencedList;

	protected AddHandler ( ObservableList<Item> list )
	{
		super();
		this.referencedList = list;
	}

	@Override
	public void handle(ActionEvent event)
	{ 
		String input;
		TextInputDialog dialog;

		try
		{
			dialog = new TextInputDialog();

			dialog.setTitle("New input:");
			dialog.setHeaderText("Enter something:");
			dialog.setContentText("something: ");

			Optional<String> result = dialog.showAndWait();
			if (result.isPresent() && !result.get().equals("") )
			{
				// do something with result == input   with    result.get()
				Item newItem = new Item( result.get() );
				this.referencedList.add( newItem );
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
