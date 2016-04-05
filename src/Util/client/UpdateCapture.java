/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.client;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javax.imageio.ImageIO;

/**
 *
 * @author WAMBA KEVIN
 */
public class UpdateCapture extends Thread{
    private InitClient client;
    public UpdateCapture(InitClient client){
        super("updateCapture");
        this.client=client;
    }
    @Override
    public void run(){
        for(int i=1;i<2;i--){
            try {
                Thread.sleep(500);
                try{
                    byte[] screenShot = client.capture.capture();
                    InputStream in = new ByteArrayInputStream(screenShot);
                    Platform.runLater(()->client.ui.updateCapture(in)); 
                }catch(RemoteException  e){

                }
            } catch (InterruptedException ex) {
                Logger.getLogger(UpdateCapture.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }            
    }
}
