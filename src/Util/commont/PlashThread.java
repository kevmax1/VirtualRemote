/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.commont;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import ui.Plash;

/**
 *
 * @author HP
 */
public class PlashThread extends Thread{
    private Plash plash;
    public PlashThread(Plash plash){
        super("chargement");
        this.plash=plash;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PlashThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        Platform.runLater(()->plash.run());                   
    }
}
