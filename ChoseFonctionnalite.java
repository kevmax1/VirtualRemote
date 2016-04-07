/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Util.client.InitClient;
import Util.server.InitServer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author HP
 */
public class ChoseFonctionnalite {
    Stage stage;
    public ChoseFonctionnalite(Stage stage){
        this.stage = stage;
        initUI();
    }

    private void initUI() {
        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundImage(new Image("resource/background.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(530, 400, true, true, true, true))));
        
        JFXButton serveur = new JFXButton("SERVEUR");
        serveur.setCursor(Cursor.HAND);
        serveur.setMinSize(171, 57);
        serveur.setLayoutX(179);
        serveur.setLayoutY(90);
        serveur.setFont(new Font(27));
        serveur.setStyle("-fx-background-color: #9E21FF;");
        serveur.setOnAction(event -> {startServerMode();});
        
        JFXButton client = new JFXButton("CLIENT");
        client.setCursor(Cursor.HAND);
        client.setMinSize(171, 57);
        client.setLayoutX(179);
        client.setLayoutY(197);
        client.setFont(new Font(27));
        client.setStyle("-fx-background-color: #9E21FF;");
        client.setOnAction(event -> {startClientMode(event);});
        
        Label info = new Label("choisir la maniere d'utiliser virtual remote");
        info.setMinSize(529, 43);
        info.setLayoutX(10);
        info.setLayoutY(14);
        info.setFont(new Font("Algerian", 20));
        root.getChildren().add(client);
        root.getChildren().add(serveur);
        root.getChildren().add(info);
        Scene scene = new Scene(root, 530, 400);
        stage.setTitle("Fontionnalité");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.DECORATED);
        stage.setOnCloseRequest(event->{System.exit(1);});
        stage.show();
    }

    private void startServerMode() {
        InitServer initializeServer = new InitServer(stage);
    }

    private void startClientMode(ActionEvent eventT) {
        //File config = new File("resource/config.json");
        String host="";
        String port="8000";
        Stage stageModal = new Stage();
        Pane root =new Pane();
        root.setBackground(new Background(new BackgroundImage(new Image("resource/background.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(530, 400, true, true, true, true))));
        stageModal.setScene(new Scene(root,200,200));
        stageModal.initStyle(StageStyle.UTILITY);
        Label adresse = new Label("Adresse serveur:");
        adresse.setLayoutX(10);
        adresse.setLayoutY(10);
        adresse.setFont(Font.font("Arial", 16));
        JFXTextField adresseInput = new JFXTextField("127.0.0.1");
        adresseInput.setPrefWidth(180);
        adresseInput.setLayoutX(10);
        adresseInput.setLayoutY(40);
        JFXButton valider = new JFXButton("Se connecter");
        valider.setCursor(Cursor.HAND);
        valider.setMinSize(100, 30);
        valider.setLayoutX(20);
        valider.setLayoutY(130);
        valider.setFont(new Font(20));
        valider.setStyle("-fx-background-color: #9E21FF;");
        valider.setOnAction(event -> {
           if(adresseInput.getText()!=""){
                stageModal.close();
                InitClient initializeClient = new InitClient(stage,adresseInput.getText(),port);
           }
        });
        root.getChildren().add(valider);
        root.getChildren().add(adresse);
        root.getChildren().add(adresseInput);
        stageModal.setTitle("Adresse serveur");
        stageModal.initModality(Modality.WINDOW_MODAL);
        stageModal.initOwner(
            ((Node)eventT.getSource()).getScene().getWindow() );
        stageModal.show();
    }
    
}
