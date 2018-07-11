package Editor;

import java.util.Optional;
import java.lang.IllegalArgumentException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

class AddHandler implements EventHandler<ActionEvent>
{

	/*protected AddHandler ( ref ref )
	{
		super();
		this.ref = ref;
	}*/

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
					// do something with result == input
			} else
			{
				throw new IllegalArgumentException();
			}

		// now add to model?

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
