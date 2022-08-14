/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Script;
import Drive.DriveQuickstart;
import Drive.ResumableUpload;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 *
 * @author LBC
 */
public class ProxyUpload {
    
    private final File File;
    private final String Source;
    private final String MimeType;
    private final String NameNewFile;
    private final String Destination;
    
    public ProxyUpload(String source,String MimeType,String nameNewFile, String destination){
        this.File = new File(source);
        this.Source = source;
        this.MimeType = MimeType;
        this.NameNewFile = nameNewFile;
        this.Destination = destination;
    }
    public boolean Upload() throws IOException, GeneralSecurityException, ResumableUpload.UploadFileException{
        
        if (this.File.length() < 4928307 ) {
            System.out.println("Simple upload called");
            return DriveQuickstart.UploadFile(Source, NameNewFile, MimeType,Destination);            
        } else if(DriveQuickstart.ResumableUploadFile(Source, NameNewFile, MimeType) == true) {          
            System.out.println("Resumable upload called");
            String fileID = DriveQuickstart.SearchFileName(NameNewFile);
            DriveQuickstart.MoveFile(fileID, Destination);
            return true;
        }else{
            return false;
        }  
    }
    
    
}
