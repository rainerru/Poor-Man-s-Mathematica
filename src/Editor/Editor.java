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
