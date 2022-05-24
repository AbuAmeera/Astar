package com.example.astar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Driver extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("prja.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 780);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {

        Calc c = new Calc();
//        c.Scan("C:\\Users\\ibrahim\\OneDrive\\Desktop\\ramallah.csv");
//        c.Scan1("C:\\Users\\ibrahim\\OneDrive\\Desktop\\edges.csv");
          //System.out.println( c.getPath("rammun","beit rima") );
        launch();




    }
}