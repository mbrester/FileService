/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Mitch
 */
public class TextFileWriter implements FileWriterStrategy {
    FileFormaterStrategy formater;
    String filePath;

    public TextFileWriter(FileFormaterStrategy formater, String filePath) {
        this.formater = formater;
        this.filePath = filePath;
    }
    
    
    @Override
    public void writeOverData(List<LinkedHashMap<String, String>> data)throws IOException{ 
        final boolean APPEND = false;
        File file = new File(filePath);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, APPEND)));
        String formatedData = formater.formatData(data);
        out.print(formatedData);
        out.close();
    }

    @Override
    public void addData(List<LinkedHashMap<String, String>> data) throws IOException {
        final boolean APPEND = true;
        File file = new File(filePath);
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, APPEND)));
        String formatedData = formater.formatData(data);
        out.print(formatedData);
        out.close();
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
