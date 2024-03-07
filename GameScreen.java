package com.example.agar_io;

import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameScreen extends StackPane {
    private String playerName;
    private Color playerColor;
    private Circle playerCircle;

    // Constructor method for GameScreen
    public GameScreen(String playerName, Color playerColor) {
        this.playerName = playerName;
        this.playerColor = playerColor;

        // Create a rectangle as background with the same color as start screen
        Rectangle background = new Rectangle(1280, 720);
        background.setFill(Color.web("#2c3e50")); // Same color as start screen

        // Create a circle representing the player with the selected color
        playerCircle = new Circle(50, playerColor);

        // Create a text node to display the player's name
        Text playerNameText = new Text(playerName);
        playerNameText.setFont(Font.font("Arial", 16));
        playerNameText.setFill(Color.WHITE);

        // Bind the position of the player's name to the position of the circle
        playerNameText.translateXProperty().bind(playerCircle.centerXProperty().subtract(playerNameText.getBoundsInLocal().getWidth() / 2));
        playerNameText.translateYProperty().bind(playerCircle.centerYProperty().subtract(playerCircle.getRadius() + 10));

        // Add the background, player circle, and player name text to the stack pane
        getChildren().addAll(background, playerCircle, playerNameText);

        // Placeholder message
        Label message = new Label("Game Screen - Placeholder");
        message.setFont(Font.font("Arial", 36));
        message.setTextFill(Color.WHITE);
        setAlignment(Pos.CENTER);
        getChildren().add(message);

    }
}
