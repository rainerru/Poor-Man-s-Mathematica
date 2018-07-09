package Editor;

import java.io.FileInputStream;

import java.util.Optional;
import java.lang.IllegalArgumentException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Separator;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Editor extends Application
{

	//BookList model = new BookList();
	ObservableList<String> myList = FXCollections.observableArrayList();
	ListView<String> listView = new ListView<>(myList);

	// for listview see https://docs.oracle.com/javafx/2/ui_controls/list-view.htm
	// particularly the colored thing (search for "chocolate")

	public static void main (String[] args) { launch(args); }

	@Override
	public void start (final Stage stage) throws Exception
	{
		//Exception e = new IllegalArgumentException();
		//this.model.setObserver(this);

		//------------------------------------------------------
		// ----- Add dropdown box ------------------------------
		// -----------------------------------------------------
		MenuItem addSection = new MenuItem("Section");
		MenuItem addText = new MenuItem("Text");
		MenuItem addMath = new MenuItem("Math");

		FileInputStream imageInput = new FileInputStream("./../data/icons/add.png");
		Image image = new Image(imageInput,30.0,30.0,false,true);
		ImageView imageView = new ImageView(image);
		//imageView.setScaleX(0.2);
		//imageView.setScaleY(0.2);

		MenuButton addBox = new MenuButton("Add", imageView, addSection, addText, addMath);

		addSection.setOnAction(new AddHandler());

		//------------------------------------------------------
		// ----- Remove button ---------------------------------
		// -----------------------------------------------------
		
		imageInput = new FileInputStream("./../data/icons/remove.png");
		image = new Image(imageInput,30.0,30.0,false,true);
		imageView = new ImageView(image);
		imageView.setScaleX(0.8);
		imageView.setScaleY(0.8);
		Button cmdRemove = new Button("Remove", imageView);
		//cmdRemove.setOnAction(new RemoveHandler());

		//------------------------------------------------------
		// ----- Edit button -----------------------------------
		// -----------------------------------------------------

		imageInput = new FileInputStream("./../data/icons/edit.png");
		image = new Image(imageInput,30.0,30.0,false,true);
		imageView = new ImageView(image);
		imageView.setScaleX(0.8);
		imageView.setScaleY(0.8);
		Button cmdEdit = new Button("Edit", imageView);
		//cmdGetInfo.setOnAction(new GetInfoHandler());

		//------------------------------------------------------
		// ----- Other buttons ---------------------------------
		// -----------------------------------------------------
		Button cmdSave = new Button("Save");

		Button cmdSaveAs = new Button("SaveAs");

		Button cmdLoad = new Button("Load");

		//------------------------------------------------------
		// ----- Scene building --------------------------------
		// -----------------------------------------------------
		BorderPane root = new BorderPane();
		
		ToolBar toolBar = new ToolBar(addBox, cmdRemove, cmdEdit, new Separator(), cmdSave, cmdSaveAs, cmdLoad);
		root.setTop(toolBar);
		root.setCenter(listView);
		Scene scene = new Scene(root, 800, 700);
		stage.setTitle("Poor Man's Mathematica - New Notebook");
		stage.setScene(scene);
		stage.show();
	}

	//------------------------------------------------------
	// ----- Handler for adding text -----------------------
	// -----------------------------------------------------

	private class AddHandler implements EventHandler<ActionEvent>
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
