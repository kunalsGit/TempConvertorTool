package com.internshala.myjavafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application
{

	public static void main(String[] args)
	{
		System.out.println("MAIN");
		launch(args);
	}

	@Override
	public void init() throws Exception
	{
		System.out.println("INIT");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{

		System.out.println("START");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	}

	private MenuBar createMenu() {

		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event -> {
			System.out.println("New Menu Item Clicked");

		});

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);


		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	public static void aboutApp() {

		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("        Hi! My name is kunal sardar and this is my first desktop app."+"\n" +
				"I am very much interest in developed desktop/web application." +"\n"+
				"Here is a Temperature Converter Tool I created as a Beginner.");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

		if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn)
		{
			System.out.println("Yes Button Clicked !");
		}
		else
		{
			System.out.println("No Button Clicked !");
		}
	}

	@Override
	public void stop() throws Exception {

		System.out.println("STOP");
		super.stop();
	}
}
