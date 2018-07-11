package Editor;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import Editor.Items.*;

public class Editor extends Application
{

	Item i1 = new Container<Integer>("description", true, new Integer(2) );
	//BookList model = new BookList();
	ObservableList<Item> myList = FXCollections.observableArrayList( i1 );
	ListView<Item> listView = new ListView<>(myList);

	// for listview see https://docs.oracle.com/javafx/2/ui_controls/list-view.htm
	// particularly the colored thing (search for "chocolate")

	public static void main (String[] args) { launch(args); }

	@Override
	public void start (final Stage stage) throws Exception
	{

		ToolBar toolBar = new SimpleToolBar();

		BorderPane root = new BorderPane();
		
		root.setTop(toolBar);
		root.setCenter(listView);
		Scene scene = new Scene(root, 800, 700);
		stage.setTitle("Poor Man's Mathematica - New Notebook");
		stage.setScene(scene);
		stage.show();
	}

}
