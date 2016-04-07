/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.commont;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import ui.Plash;

/**
 *
 * @author HP
 */
public class Config {
    public static String colorP ;
    public static String colorS ;
    public static String colorT ;
    public static String height ;
    public static String width ;
    public static String appName ;
    public static String copyright ;
    public static String year_version ;
    public static String logo ;
    public static String type ;
    public static void initConfig(Plash plash){
        FileReader fr = null;
        try {
            File f = new File("resource/uiConfig.json");
            fr = new FileReader(f);
            String jsonStr = "";
            int k;
            while((k=fr.read())!=-1)
                jsonStr += ( char) k;
            JSONObject obj = new JSONObject(jsonStr);
            colorP = obj.getString("colorP");
            colorS = obj.getString("colorS");
            colorT = obj.getString("colorT");
            height = obj.getString("height");
            width = obj.getString("width");
            type = obj.getString("type");
            logo = obj.getString("logo");
            year_version = obj.getString("year_version");
            copyright = obj.getString("copyright");
            appName = obj.getString("appName");
            plash.init();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
