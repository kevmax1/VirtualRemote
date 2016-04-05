/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualremote;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.ChoseFonctionnalite;

/**
 *
 * @author HP
 */
public class VirtualRemote extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setOnCloseRequest(event->{System.exit(1);});
        ChoseFonctionnalite singletonchose = new ChoseFonctionnalite(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
