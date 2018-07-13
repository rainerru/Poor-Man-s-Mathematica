package Editor;

import javafx.collections.ObservableList;

import javafx.scene.control.ListView;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import Editor.Items.*;

class RemoveHandler implements EventHandler<ActionEvent>
{

	ObservableList<Item> referencedList;
	ListView<Item> referencedListView;

	protected RemoveHandler ( ObservableList<Item> list, ListView<Item> listView )
	{
		super();
		this.referencedList = list;
		this.referencedListView = listView;
	}

	@Override
	public void handle(ActionEvent event)
	{
		Item toRemove = referencedListView.getSelectionModel().getSelectedItem();
		referencedList.remove( toRemove );
	}

}
