/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class ServerUi {
    public Pane stage;
    public Label info ;
    public JFXButton back;
    public ServerUi(Pane stage){
        this.stage = stage;
        info = new Label("");
        info.setMaxSize(400, 400);
        info.setLayoutX(10);
        info.setLayoutY(14);
        info.setFont(new Font("Algerian", 20));
        info.setWrapText(true);
        stage.getChildren().remove(0, stage.getChildren().size());
        stage.getChildren().add(info);
        initUI();
    }
    private void initUI() {
        /*Pane root = new Pane();
        root.setBackground(new Background(new BackgroundImage(new Image("resource/background.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(530, 400, true, true, true, true))));
        
        back = new JFXButton();
        back.setMinSize(50, 50);
        back.setLayoutX(440);
        back.setLayoutY(340);
        back.setStyle("-fx-background-radius: 50%; -fx-background-color: #9E21FF;");
        back.setCursor(Cursor.HAND);
        back.setGraphic(new ImageView(new Image("resource/back.png")));
        root.getChildren().add(back);
        
        info = new Label("");
        info.setMaxSize(500, 400);
        info.setLayoutX(10);
        info.setLayoutY(14);
        info.setFont(new Font("Algerian", 20));
        info.setWrapText(true);
        root.getChildren().add(info);
        Scene scene = new Scene(root, 530, 400);
        stage.setTitle("Serveur");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
                */
    }
}
