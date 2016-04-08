/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import Util.client.InitClient;
import Util.commont.Config;
import Util.server.InitServer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author HP
 */
public class ChoseFonctionnalite {
    Stage stage;
    Pane container;
    Label textFooter;
    double xInit,yInit;
    public ChoseFonctionnalite(Stage stage){
        this.stage = stage;
        initUI();
    }

    private void initUI() {
        Pane root = new Pane();
        root.setStyle("-fx-background-color:"+Config.colorT+";");
        //entête
        Pane entete = new Pane();
        entete.setStyle("-fx-background-color:"+Config.colorP+";");
        entete.setMaxSize(400, 150);
        entete.setMinSize(400, 150);
        entete.setLayoutX(0);
        entete.setLayoutY(0);
        root.getChildren().add(entete);
        //gestion des activités basique de la fenêtre
        JFXButton fermer = new JFXButton("X");
        fermer.setTextFill(Color.WHITE);
        fermer.setCursor(Cursor.HAND);
        fermer.setRipplerFill(Color.RED);
        fermer.setLayoutX(365);
        fermer.setLayoutY(5);
        fermer.setMinSize(30, 30);
        fermer.setOnAction(event -> {System.exit(1);});
        fermer.setFont(Font.font("blueHightway",FontWeight.BOLD,18));
        JFXButton reduire = new JFXButton("-");
        reduire.setCursor(Cursor.HAND);
        reduire.setRipplerFill(Color.BLUE);
        reduire.setTextFill(Color.WHITE);
        reduire.setLayoutX(330);
        reduire.setLayoutY(3);
        reduire.setMinSize(30, 30);
        reduire.setOnAction(event -> {stage.setIconified(true);});
        JFXButton param = new JFXButton();
        param.setCursor(Cursor.HAND);
        param.setRipplerFill(Color.GRAY);
        param.setTextFill(Color.WHITE);
        param.setLayoutX(300);
        param.setLayoutY(3);
        param.setGraphic(new ImageView("resource/param.png"));
        param.setMinSize(30, 40);
        root.getChildren().add(param);
        ImageView logo = new ImageView("resource/logo.png");
        logo.setLayoutX(5);
        logo.setLayoutY(5);
        root.getChildren().add(logo);
        reduire.setFont(Font.font("blueHightway",FontWeight.BOLD,18));
        Label appName = new Label(Config.appName);
        appName.setTextFill(Color.web(Config.colorT));
        appName.setFont(new Font(15));
        appName.setLayoutX(50);
        appName.setLayoutY(5);
        root.getChildren().add(appName);
        root.getChildren().add(fermer);
        root.getChildren().add(reduire);
        
        //footer
        BorderPane footer = new BorderPane();
        footer.setStyle("-fx-background-color:"+Config.colorP+";");
        footer.setMaxSize(400, 40);
        footer.setMinSize(400, 40);
        footer.setLayoutX(0);
        footer.setLayoutY(515);
        root.getChildren().add(footer);
        //texte du footer
        textFooter = new Label("Choisir une fonctionnalité");
        textFooter.setTextFill(Color.web(Config.colorT));
        textFooter.setFont(new Font(20));
        footer.setCenter(textFooter);
        //version
        Label version = new Label("Version 1.1");
        version.setTextFill(Color.web(Config.colorS));
        version.setFont(new Font(15));
        version.setLayoutX(310);
        version.setLayoutY(575);
        root.getChildren().add(version);
        //icone profile
        
        Circle profil = new Circle(14);
        ImagePattern pattern = new ImagePattern(new Image("resource/profil.png"));
        profil.setFill(pattern);
        profil.setLayoutX(20);
        profil.setLayoutY(575);
        root.getChildren().add(profil);
        //profil
        Label textProfil;
        try {
            textProfil = new Label(InetAddress.getLocalHost().getHostName());
            textProfil.setTextFill(Color.web(Config.colorS));
            textProfil.setFont(Font.font("blueHightway",FontWeight.BOLD, 15));
            textProfil.setLayoutX(50);
            textProfil.setLayoutY(563);
            root.getChildren().add(textProfil);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ChoseFonctionnalite.class.getName()).log(Level.SEVERE, null, ex);
        }
        container = new Pane();
        container.setMinSize(400, 365);
        container.setLayoutX(0);
        container.setLayoutY(150);
        root.getChildren().add(container);
        
        Label inform = new Label("Application de partage d'ecran");
        inform.setTextFill(Color.web(Config.colorS));
        inform.setFont(Font.font("blueHightway",FontWeight.BOLD,18));
        inform.setLayoutX(50);
        inform.setLayoutY(10);
        container.getChildren().add(inform);
        
        JFXButton serveur = new JFXButton("SERVEUR");
        serveur.setCursor(Cursor.HAND);
        serveur.setMinSize(170, 57);
        serveur.setLayoutX(115);
        serveur.setLayoutY(100);
        serveur.setFont(new Font(27));
        serveur.setStyle("-fx-background-color:"+Config.colorP+";");
        serveur.setTextFill(Color.web(Config.colorT));
        serveur.setOnAction(event -> {startServerMode();});
        
        //splash
        ImageView splash = new ImageView("resource/splash_color.png");
        splash.setLayoutX(270);
        splash.setLayoutY(265);
        container.getChildren().add(splash);
        
        JFXButton client = new JFXButton("CLIENT");
        client.setCursor(Cursor.HAND);
        client.setMinSize(170, 57);
        client.setLayoutX(115);
        client.setLayoutY(200);
        client.setFont(new Font(27));
        client.setStyle("-fx-background-color: "+Config.colorP+";");
        client.setTextFill(Color.web(Config.colorT));
        client.setOnAction(event -> {startClientMode(event);});
        
        container.getChildren().add(client);
        container.getChildren().add(serveur);
        Scene scene = new Scene(root, 400, 600);
        String style = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().addAll(style);
        entete.setOnMousePressed(event -> {
            xInit = event.getScreenX()-stage.getX();
            yInit = event.getScreenY()-stage.getY();
        });
        entete.setCursor(Cursor.HAND);
        entete.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX()-xInit);
            stage.setY(event.getScreenY()-yInit);
        });
        stage.setTitle("Fontionnalité");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setOnCloseRequest(event->{System.exit(1);});
        stage.initStyle(StageStyle.UNDECORATED); 
        stage.getIcons().add(new Image("resource/icone.png"));
        stage.show();
    }

    private void startServerMode() {
        textFooter.setText("mode serveur activer");
        InitServer initializeServer = new InitServer(container);
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
        valider.setStyle("-fx-background-color: "+Config.colorP+";");
        valider.setOnAction(event -> {
           if(adresseInput.getText()!=""){
                stageModal.close();
                stage.close();
                InitClient initializeClient = new InitClient(new Stage(),adresseInput.getText(),port);
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
