package Editor;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ToolBar;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// import javafx.util.Callback;

import Editor.Items.*;

import MathFunction.*;

public class Editor extends Application
{

	Item i1 = new Container<Integer>("res1 (int)", true, new Integer(2) );
	Item i2 = new Container<Double>("res2 (double)", true, new Double(3.5) );
	Item i3 = new Container<Item>("a Container<Item>", true, new Item("haha") );
	Item i4 = new Container<Polynomial>("poly1:  of an Poly with constant 1", true, new Polynomial(new double[]{1,2,3}) );
	//BookList model = new BookList();
	ObservableList<Item> myList = FXCollections.observableArrayList( i1, i2, i3, i4);
	ListView<Item> listView = new ListView<>(myList);

	// for listview see https://docs.oracle.com/javafx/2/ui_controls/list-view.htm
	// particularly the colored thing (search for "chocolate")

	public static void main (String[] args) { launch(args); }

	@Override
	public void start (final Stage stage) throws Exception
	{

		//listView.setCellFactory(new Callback<ListView<Item>, ListCell<Item>>()
		listView.setCellFactory( param -> new MCell() );

		ToolBar toolBar = new SimpleToolBar( myList, listView );
		BorderPane root = new BorderPane();
	
		root.setTop(toolBar);
		root.setCenter(listView);
		Scene scene = new Scene(root, 800, 700);
		stage.setTitle("Poor Man's Mathematica - New Notebook");
		stage.setScene(scene);
		stage.show();

	}

}
