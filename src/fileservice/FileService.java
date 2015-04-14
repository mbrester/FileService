/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author Mitch
 */
public class FileService {
    FileReaderStrategy fileReader;
    FileWriterStrategy fileWriter;
    

    public FileService(FileReaderStrategy fileReader, FileWriterStrategy fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        
    }
  
    public List<LinkedHashMap<String,String>> getAllRecords()throws IOException{
        return fileReader.getRecords();
        
    }
    
    public void overWriteRecords(List<LinkedHashMap<String,String>> data) throws IOException{
        fileWriter.writeOverData(data);
    }
    
    public void updateRecords(List<LinkedHashMap<String,String>> data) throws IOException{
        fileWriter.addData(data);
    }
    
}
