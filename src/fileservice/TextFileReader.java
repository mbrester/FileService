/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mitch
 */
public class TextFileReader implements FileReaderStrategy{
    FileFormaterStrategy formater;
    String filePath;

    public TextFileReader(FileFormaterStrategy formater, String filePath) {
        this.formater = formater;
        this.filePath = filePath;
    }
    
    
    @Override
    public List<LinkedHashMap<String, String>> getRecords() throws IOException {
                
        String data = "";
        
        File file = new File(filePath);
        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(file));
	   String row = in.readLine();
	   while(row != null){
                data += (row + "\n");
                row = in.readLine(); 
           }
        } catch(IOException ioe) {
            throw ioe;
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                throw new IOException(e.getMessage());
            }
        }
        return formater.unformatData(data);
    }

    public FileFormaterStrategy getFormater() {
        return formater;
    }

    public void setFormater(FileFormaterStrategy formater) {
        this.formater = formater;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    
    
    
}
