package Editor;

import java.util.Optional;
import java.lang.IllegalArgumentException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

class Handlers
{

	// add reference variable

	protected Handlers () // add reference variable
	{
		int i = 2+3; // do something else
	}

	//------------------------------------------------------
	// ----- Handler for adding text -----------------------
	// -----------------------------------------------------

	class AddHandler implements EventHandler<ActionEvent>
	{

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

/*

	private class RemoveHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			if ( !(listView.getSelectionModel().getSelectedItem() == null) )
			{
				int selectedBook = Integer.parseInt( listView.getSelectionModel().getSelectedItem() );
				model.remove(selectedBook);
			}
		}
	}

	private class GetInfoHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			if ( !(listView.getSelectionModel().getSelectedItem() == null) )
			{
				int selectedTitle = Integer.parseInt( listView.getSelectionModel().getSelectedItem() );
				Book selectedBook = model.search(selectedTitle);

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Book details");
				alert.setHeaderText("Title: " + selectedBook.getTitle());
				alert.setContentText("Author: " + selectedBook.getAuthor()
					+ "\nYear: " + selectedBook.getYear()
					+	"\nISBN: " + selectedBook.getISBN());

				alert.showAndWait();
			}
		}
	}

	// Handlers for events:

	public void update ( CustomAddEvent<Book> event )
	{
		if ( this.model == event.getSource() )
			myList.add( Integer.toString( event.getTarget().getISBN() ) );
	}
	
	public void update ( CustomRemoveEvent<Book> event )
	{
		if ( this.model == event.getSource() )
			myList.remove( Integer.toString( event.getTarget().getISBN() ) );
	}
*/

}
