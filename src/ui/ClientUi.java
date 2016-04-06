/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.jfoenix.controls.JFXButton;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class ClientUi {
    public Stage stage;
    public ImageView vue;
    public JFXButton back;
    public JFXButton param;
    public ClientUi(Stage stage){
        this.stage = stage;
        initUI();
    }
    private void initUI() {
        Pane root = new Pane();
        vue = new ImageView();
        vue.setLayoutX(0);
        vue.setLayoutY(0);
        root.getChildren().add(vue);
                
        back = new JFXButton();
        back.setMinSize(50, 50);
        back.setLayoutX(70);
        back.setLayoutY(5);
        back.setStyle("-fx-background-radius: 50%; -fx-background-color: #9E21FF;");
        back.setCursor(Cursor.HAND);
        back.setGraphic(new ImageView(new Image("resource/back.png")));
        back.setOpacity(0.5);
        root.getChildren().add(back);
        
        param = new JFXButton();
        param.setMinSize(50, 50);
        param.setLayoutX(10);
        param.setLayoutY(5);
        param.setStyle("-fx-background-radius: 50%; -fx-background-color: #9E21FF;");
        param.setCursor(Cursor.HAND);
        param.setGraphic(new ImageView(new Image("resource/gear.png")));
        param.setOpacity(0.5);
        root.getChildren().add(param);
        
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Client");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.setOnCloseRequest(event->{System.exit(1);});
        stage.show();
    }
    public void updateCapture(InputStream ss){
        Image temp = new Image(ss,stage.getWidth(),stage.getHeight(), false, false);
        vue.setImage(temp);
    }
}
