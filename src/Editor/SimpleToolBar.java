package Editor;

import java.io.FileInputStream;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Separator;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

class SimpleToolBar extends ToolBar
{

	protected SimpleToolBar () throws Exception
	{
		super();

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

		this.getItems().addAll(addBox, cmdRemove, cmdEdit, new Separator(), cmdSave, cmdSaveAs, cmdLoad);
		// uper(addBox, cmdRemove, cmdEdit, new Separator(), cmdSave, cmdSaveAs, cmdLoad);
	}

}
