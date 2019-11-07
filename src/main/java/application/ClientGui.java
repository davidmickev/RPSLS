package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class ClientGui extends Application {


	@Override
	public void start(Stage primaryStage) {
		 try {


		 	//application.SceneChanger.this.portSelect =
			 /*application.SceneChanger controller;
			 controller.portSelect = new TextField("ok");*/

	            // Read file fxml and draw interface.
	            Parent root = FXMLLoader.load(getClass()
	                    .getResource("../FXML/MyFXML1.fxml"));
	 
	            primaryStage.setTitle("RPSLS");
             Scene s1 = new Scene(root, 800,600);

	            primaryStage.setScene(s1);
	            primaryStage.show();
	         
	        } catch(Exception e) {
	            e.printStackTrace();
	            System.exit(1);
	        }


	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
