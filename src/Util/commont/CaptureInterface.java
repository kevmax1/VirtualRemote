package Util.commont;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Image;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author HP
 */
public interface CaptureInterface extends Remote{
    public byte[] capture() throws RemoteException;
}
