/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.client;

import Util.commont.Capture;
import Util.commont.CaptureInterface;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import ui.ChoseFonctionnalite;
import ui.ClientUi;
import ui.ServerUi;

/**
 *
 * @author HP
 */

public class InitClient {
    Stage stage;
    ClientUi ui ;
    CaptureInterface capture;
    String host,port;
    public InitClient(Stage stage,String host,String port){
        this.stage = stage;
        this.host = host;
        this.port = port;
        startUI();
        startRemoteConnect();
    }

    private void startUI() {
        ui = new ClientUi(stage);
    }

    private void startRemoteConnect() {
        try {
            String connectParam = "rmi://"+host+":"+port+"/capture";
            capture = (CaptureInterface)Naming.lookup(connectParam);
            UpdateCapture update = new UpdateCapture(this);
            update.setDaemon(true);
            update.start();
        } catch(NotBoundException ex){
            System.out.println("serveur not found");
        } catch (MalformedURLException ex) {
            Logger.getLogger(InitClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(InitClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        ui.stage.setOnCloseRequest(event ->{disconnect();});
        ui.back.setOnAction(event ->{back();});
        ui.param.setOnAction(event ->{param();});
    }
    public void disconnect(){
        try {
            System.exit(1);
        } catch (Exception e) {
                    
        }
    }
    public void param(){
        
    }
    public void back(){
        ChoseFonctionnalite singletonchose = new ChoseFonctionnalite(this.stage);
    }
}
