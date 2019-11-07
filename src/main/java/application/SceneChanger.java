package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.HashMap;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SceneChanger implements Initializable {

	@FXML
	private VBox root;

	@FXML
	private BorderPane root2;

	@FXML
	private BorderPane root3;

	@FXML
	public ProgressBar progressBar1;


	// rock paper scissors lizard spock
	@FXML String playerMove;


	ClientThread client;

	public ProgressBar getProgressBar1() {
		progressBar1.setProgress(1);
		return progressBar1;
	}


	@FXML
	public TextField portSelect;

	@FXML
	public TextField ipSelect;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void grabTextPort(ActionEvent e) throws IOException{
		System.out.print("Port Selected: ");
		System.out.println(portSelect.getText());
	}

	@FXML
	private void grabTextIP(ActionEvent e) throws IOException{

		System.out.print("IP Selected: ");
		System.out.println(ipSelect.getText());
	}


	// ClientGui screen for Port / IP Address
	// Menu2 Opens / Loads Second Menu Which will wait for both players

	// Play button
	public void Menu2(ActionEvent e) throws IOException {

		grabTextIP(e);
		grabTextPort(e);

		Parent root2 = FXMLLoader.load(getClass()
				.getResource("/FXML/Myfxml2.fxml"));
		root2.getStylesheets().add("/styles/style2.css");

		root.getScene().setRoot(root2);



	}

	// b1Methods Calls a reset to main menu.
	public void b1Main(ActionEvent e) throws IOException{

		Parent root = FXMLLoader.load(getClass()
				.getResource("/FXML/MyFXML1.fxml"));

		root2.getScene().setRoot(root);
	}

	// From Menu2, Call Menu3 (Game play screen)
	public void Menu3(ActionEvent e) throws IOException{

		Parent root3 = FXMLLoader.load(getClass()
				.getResource("/FXML/MyFXML3.fxml"));

		root2.getScene().setRoot(root3);
	}

	public void b2Main(ActionEvent e) throws IOException{

		Parent root = FXMLLoader.load(getClass()
				.getResource("/FXML/MyFXML1.fxml"));


		root3.getScene().setRoot(root);
	}

	public void connectToServer(ActionEvent e) throws IOException{

		client = new ClientThread(data -> {
			Platform.runLater(()->{


				Parent root2 = null;
				try {
					root2 = FXMLLoader.load(getClass()
							.getResource("/FXML/MyFXML2.fxml"));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				System.out.println("debug");

				root.getScene().setRoot(root2);
				client.start();
			});
			client.start();
		});

	}

	public void rock(){
		playerMove = "rock";
		System.out.println(playerMove);
	}
	public void paper(ActionEvent e) throws IOException{
		playerMove = "paper";
		System.out.println(playerMove);

	}
	public void scissors(ActionEvent e) throws IOException{
		playerMove = "scissors";
		System.out.println(playerMove);

	}
	public void lizard(ActionEvent e) throws IOException{
		playerMove = "lizard";
		System.out.println(playerMove);

	}

	public void spock(ActionEvent e) throws IOException{
		playerMove = "spock";
		System.out.println(playerMove);

	}

}
