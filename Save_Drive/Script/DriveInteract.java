/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Script;

import Compression.ZipUtils;
import Drive.ResumableUpload;
import Frame.Notifications;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LBC
 */
public class DriveInteract {
    
    //Get date and hour

    /**
     *
     * @return
     */
    public static String getDate(){
        SimpleDateFormat formater = null;

        Date aujourdhui = new Date();
        
        formater = new SimpleDateFormat("dd_MM_yy-H_m_s");
        return formater.format(aujourdhui);
    }
    
    /**
     *
     * @param args
     * @throws IOException
     * @throws GeneralSecurityException
     * @throws ResumableUpload.UploadFileException
     */
    public static void main(String... args) throws IOException, GeneralSecurityException, ResumableUpload.UploadFileException {
        
        String source = "C:\\Users\\LBC\\Documents\\Coffre";
        String name ="Save_Coffre_"+DriveInteract.getDate()+".zip";
        String output = "C:\\Users\\LBC\\Desktop\\ZipShit\\"+name;
        
        //Coffre_Notes (ID)
        String DestinationID = "1JhIvvK0Dm__HOSS_Zjl02-zjAJ9eZdhN";
        
        //Type of the file
        String mimeType = "application/zip";
        
        //Compress file
        new ZipUtils(source,output).Zip();
        
        //Upload file
        ProxyUpload proxy = new ProxyUpload(output, mimeType, name, DestinationID);
        
        if (proxy.Upload()) {
            Notifications.SaveState("Sauvegarde reussie !!!");
        } else {
            Notifications.SaveState("Echec de la sauvegarde !!!");
        }
        
    }
}
