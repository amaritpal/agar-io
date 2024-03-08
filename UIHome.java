package com.example._groupb_oop_agario;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UIHome extends Application {

    private String playerName = "Player"; // Default player name
    private Color selectedColor = Color.RED; // Default selected color

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #2c3e50;"); // Dark blueish background color

        // Create a title
        Text title = new Text("AGAR.IO");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 60)); // Set font size directly
        title.setY(200);
        title.setX(500);
        title.setFill(Color.WHITE);
        root.getChildren().add(title);

        // Create a subtitle
        Text subtitle = new Text("Welcome to Agar.io");
        subtitle.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
        subtitle.setFill(Color.WHITE);

        // Create a text field for entering player name
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Your Name");
        nameField.setMaxWidth(300); // Set a larger width for the text field

        // Create a color picker for selecting the skin color
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(selectedColor); // Set default color
        colorPicker.setMaxWidth(300);

        // Create a button to confirm the name
        Button confirmButton = new Button("Confirm");
        confirmButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");
        confirmButton.setOnAction(e -> {
            String newName = nameField.getText();
            if (!newName.isEmpty()) {
                playerName = newName;
            }
        });

        // Create a custom start button
        StackPane customButton = createCustomButton("Start Game", 200, 80);

        // Layout
        VBox vbox = new VBox(10); // Vertical spacing of 10
        vbox.setAlignment(Pos.CENTER);

        StackPane titlePane = new StackPane(subtitle);
        StackPane.setMargin(title, new Insets(50, 0, 0, 0));

        StackPane namePane = new StackPane(nameField);
        StackPane.setMargin(nameField, new Insets(0, 0, 10, 0)); // Add margin below the name field

        StackPane colorPickerPane = new StackPane(colorPicker);
        StackPane.setMargin(colorPicker, new Insets(10, 0, 0, 0)); // Add margin above color picker

        StackPane confirmButtonPane = new StackPane(confirmButton);
        StackPane.setMargin(confirmButton, new Insets(10, 0, 0, 0)); // Add margin above confirm button

        vbox.getChildren().addAll(titlePane, namePane, colorPickerPane, confirmButtonPane, customButton);

        root.setCenter(vbox); // Set VBox to the center of the border pane

        // Handler for color selection
        colorPicker.setOnAction(event -> {
            selectedColor = colorPicker.getValue();
        });

        // Create the scene and set it on the stage
        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setTitle("Agar.io Game UI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private StackPane createCustomButton(String text, double width, double height) {
        // Create a rectangle for button background
        Rectangle background = new Rectangle(width, height);
        background.setFill(Color.rgb(52, 152, 219)); // Set button color
        background.setArcWidth(20);
        background.setArcHeight(20);

        // Create text for button label
        Text label = new Text(text);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        label.setFill(Color.WHITE);

        // Create button container
        StackPane buttonPane = new StackPane(background, label);

        // Add event handler for mouse click
        buttonPane.setOnMouseClicked(e -> startGame((Stage) buttonPane.getScene().getWindow()));

        return buttonPane;
    }

    private void startGame(Stage primaryStage) {
        // Create the game screen with player name and color
        GameScreen gameScreen = new GameScreen(playerName, selectedColor);

        // Set the game screen as the scene
        Scene gameScene = new Scene(gameScreen, 1280, 720);
        primaryStage.setScene(gameScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}