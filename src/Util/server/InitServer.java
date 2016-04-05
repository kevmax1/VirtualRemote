/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.server;

import Util.commont.Capture;
import com.jfoenix.controls.JFXDialog;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Optional;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui.ChoseFonctionnalite;
import ui.ServerUi;
/**
 *
 * @author HP
 */
public class InitServer {
    Stage stage;
    ServerUi ui ;
    Registry registry;
    boolean started = false;
    public InitServer(Stage stage){
        this.stage = stage;
        startUI();
        startRemoteObjet();
    }

    private void startUI() {
        ui = new ServerUi(stage);
    }

    private void startRemoteObjet() {
        try {
            InetAddress ia = InetAddress.getLocalHost();
            String serverAddr = ia.getHostAddress();
            if(started==false){
                registry = LocateRegistry.createRegistry(8000);
                Capture cf = new Capture();
                Naming.rebind("rmi://localhost:8000/capture", cf);
                started =true;
            }
            ui.info.setText("Le serveur a bien demarer l'adresse "+serverAddr+" au port 8000");
        } catch (Exception ex) {
            ui.info.setText("L'erreur suivante est survenue lors de l'initialisation du serveur :"+ex.getMessage());
        }
        ui.stage.setOnCloseRequest(event ->{disconnect();});
        ui.back.setOnAction(event ->{back();});
    }
    public void disconnect(){
        try {
            InetAddress ia = InetAddress.getLocalHost();
            String serverAddr = ia.getHostAddress();
            Naming.unbind("rmi://"+serverAddr+":8000/capture");
            System.exit(1);
        } catch (Exception e) {
                    
        }
    }
    public void back(){
        try {
            InetAddress ia = InetAddress.getLocalHost();
            String serverAddr = ia.getHostAddress();
            Naming.unbind("rmi://"+serverAddr+":8000/capture");
        } catch (Exception e) {
                    
        }
        ChoseFonctionnalite singletonchose = new ChoseFonctionnalite(this.stage);
    }
}
