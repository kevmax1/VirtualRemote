/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.commont;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.imageio.ImageIO;

/**
 *
 * @author HP
 */
public class Capture extends UnicastRemoteObject implements CaptureInterface{
    public Capture() throws RemoteException{
        
    }
    @Override
    public byte[] capture() throws RemoteException {
        try {
            Robot robot = new Robot();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Rectangle tailleEcran = new Rectangle(toolkit.getScreenSize());
            BufferedImage captureBuffered = robot.createScreenCapture(tailleEcran);
            ByteArrayOutputStream byteAOS = new ByteArrayOutputStream();
            ImageIO.write( captureBuffered, "png", byteAOS );
            byteAOS.flush();
            byte[] captureByte = byteAOS.toByteArray();
            byteAOS.close();
            return captureByte;
		
        } catch (AWTException | HeadlessException |IOException  e) {
            return null;
        }
    }    
}
