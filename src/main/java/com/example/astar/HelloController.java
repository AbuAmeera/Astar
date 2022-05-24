package com.example.astar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;

public class HelloController {

    @FXML
    private ImageView img;

    @FXML
    private TextField start;

    @FXML
    private TextField dist;

    @FXML
    private Button search;

    @FXML
    private TextArea ans;

    public void initialize() throws FileNotFoundException {
        Calc c = new Calc();
        c.Scan("C:\\Users\\ibrahim\\OneDrive\\Desktop\\ramallah.csv");
       c.Scan1("C:\\Users\\ibrahim\\OneDrive\\Desktop\\edges.csv");
    }

    @FXML
    void search(ActionEvent event) {

        int flag = 0;
        Calc c = new Calc();

        if ( !start.getText().equalsIgnoreCase(dist.getText()) ){

            for (int i=0;i<c.adj.size();i++){
                if ( !start.getText().equalsIgnoreCase(c.adj.get(i).get(0).getCity()) ){
                    flag = 1;
                }
                if ( !dist.getText().equalsIgnoreCase(c.adj.get(i).get(0).getCity()) ){
                    flag = 1;
                }
            }
            if (flag == 1){
                ans.setPromptText(c.getPath(start.getText(),dist.getText()));
            }
            else{
                ans.setPromptText("wrong input");
            }

        }


    }

}
