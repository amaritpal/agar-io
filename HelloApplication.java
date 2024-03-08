package com.example._groupb_oop_agario;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();

        Scene scene = new Scene(root, 1280, 720);
        stage.setTitle("Agar.io");
        stage.setScene(scene);
        stage.show();

    //NPC TRIAL
        Circle NPC = new Circle(50,Paint.valueOf("#ff0000"));
        root.getChildren().add(NPC);
    //SPAWN
        NPC.setCenterX(Math.random()*1280);
        NPC.setCenterY(Math.random()*720);
    //MOVEMENT
        

    }


    public static void main(String[] args) {
        launch();
    }
}