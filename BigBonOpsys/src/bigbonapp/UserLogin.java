package bigbonapp;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class UserLogin extends Application {

	private Text actionStatus;
	private static final String titleText = "BigBoon";
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
			primaryStage.setTitle(titleText);	
			
			//	Create the Window Label
			Label label = new Label("BigBoon");
			label.setTextFill(Color.RED);
			label.setFont(Font.font("Calibri", FontWeight.BOLD, 36));
			//	Create horizontal box label
			HBox labelHb = new HBox();
			labelHb.setAlignment(Pos.CENTER);
			labelHb.getChildren().add(label);
			
			//	Login Button
			Button btnLogin = new Button("Login");
			btnLogin.setOnAction(e ->displayDialog());
			
			//	Create HBox for buttons
			HBox buttonHb = new HBox(10);
			buttonHb.setAlignment(Pos.CENTER);
			buttonHb.getChildren().addAll(btnLogin);
			
			//	Status message text
			actionStatus = new Text();
			actionStatus.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
			actionStatus.setFill(Color.FIREBRICK);
			
			//	VBox
			VBox vbox = new VBox(30);
			vbox.setPadding(new Insets(25, 25, 25, 25));
			vbox.getChildren().addAll(labelHb, buttonHb, actionStatus);
			
			
			//	Create Scene and add vbox to scene and set dimensions
			Scene scene = new Scene(vbox, 500, 250); // w x h
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	private void displayDialog() {
		
		actionStatus.setText("");
		
		//	Custom dialog
		Dialog<Person> dialog = new Dialog<>();
		dialog.setTitle(titleText);
		dialog.setHeaderText("Dialog Header");
		dialog.setResizable(true);
		
		//	Widgets
		Label label1 = new Label("Pin: ");
		
		TextField textField1 = new TextField();
		
		//	Create layout and add widgets to dialog
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 35, 20, 35));
		grid.add(label1, 1, 1);	//	column = 1, row = 1
		grid.add(textField1, 2, 1);
		dialog.getDialogPane().setContent(grid);
		
		//	Add button to dialog
		ButtonType buttonTypeOk = new ButtonType("Ok", ButtonData.OK_DONE);
		
		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
		
		//	Result converter for dialog
		dialog.setResultConverter(new Callback<ButtonType, Person>() {

			@Override
			public Person call(ButtonType b) {
				if (b == buttonTypeOk) {
					return new Person(textField1.getText());
				}
				return null;
			}
		});
		
		//	Show Dialog
		Optional<Person> result = dialog.showAndWait();
			if(result.isPresent()) {
				actionStatus.setText("Result: " + result.get());
			}
	}

	private class Person {
		private String userPin;
		
		Person(String userPin) {
			this.userPin = userPin;
		}
		
		@Override
		public String toString() {
			return String.format("%s", userPin);
		}
	}
	
}


 
