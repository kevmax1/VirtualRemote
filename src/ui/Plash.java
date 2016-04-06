/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Util.client.UpdateCapture;
import Util.commont.PlashThread;
import com.jfoenix.controls.JFXSpinner;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author HP
 */
public class Plash {
    public Stage stage;
    public Plash(Stage stage){
        this.stage =stage;
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 300);
        String style = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().addAll(style);
        root.setStyle("-fx-background-color: #9E21FF;");
        
        Label capitalLetter = new Label("V");
        root.getChildren().add(capitalLetter);
        capitalLetter.setStyle("-fx-font-family: 'makisupa';-fx-weight:bold");
        capitalLetter.setTextFill(Color.web("#FFF"));
        capitalLetter.setFont(new Font(200));
        capitalLetter.setLayoutX(30);
        capitalLetter.setLayoutY(20);
        
        JFXSpinner chargement = new JFXSpinner();
        chargement.setLayoutX(250);
        chargement.setLayoutY(250);
        root.getChildren().add(chargement);
        
        Pane free = new Pane();
        free.setStyle("-fx-background-color: #fff;-fx-padding:0px 3px");
        Label textFree = new Label("Free");
        textFree.setFont(Font.font("blueHightway", FontWeight.BOLD, 20));
        textFree.setTextFill(Color.web("#9E21FF"));
        free.getChildren().add(textFree);
        free.setLayoutX(431);
        free.setLayoutY(90);
        root.getChildren().add(free);
        
        Label name = new Label("Virtual Remote");
        root.getChildren().add(name);
        name.setFont(Font.font("blueHightway", FontWeight.BOLD, 30));
        name.setTextFill(Color.web("#FFF"));
        name.setLayoutX(160);
        name.setLayoutY(120);
        
        Label year = new Label("2016 beta 1");
        root.getChildren().add(year);
        year.setFont(Font.font("blueHightway", FontWeight.BOLD, 18));
        year.setTextFill(Color.web("#FFF"));
        year.setLayoutX(380);
        year.setLayoutY(133);
        
        Label copyright = new Label("Copyright © 2015-2016 Shinka Soft All right reserved");
        root.getChildren().add(copyright);
        copyright.setFont(Font.font("blueHightway", FontWeight.SEMI_BOLD, 13));
        copyright.setTextFill(Color.web("#FFF"));
        copyright.setLayoutX(170);
        copyright.setLayoutY(155);
        
        ImageView plash = new ImageView(new Image("resource/plash.png"));
        plash.setFitHeight(150);
        plash.setFitWidth(150);
        plash.setLayoutX(350);
        plash.setLayoutY(150);
        root.getChildren().add(plash);
        
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Chargement");
        stage.setScene(scene);
        stage.show();
        PlashThread thread = new PlashThread(this);
        thread.setDaemon(true);
        thread.start();
    }

    public void run() {
        stage.close();
        ChoseFonctionnalite singletonchose = new ChoseFonctionnalite( new Stage());
    }
}
