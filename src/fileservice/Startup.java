/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Mitch
 */
public class Startup {
    public static void main(String[] args) throws IOException {
        FileService fileService= new FileService(
                        new TextFileReader(new CsvFileFormat(),"src/mydata.csv"),
                        new TextFileWriter(new CsvFileFormat(),"src/mydata.csv"));

        List<LinkedHashMap<String, String>> inData = fileService.getAllRecords();
        System.out.println(inData);

        List<LinkedHashMap<String, String>> updatedFileContent = new ArrayList<LinkedHashMap<String, String>>();
        LinkedHashMap<String, String> record= new LinkedHashMap<String, String>();

        record.put("firstName", "Mitch");
        record.put("lastName", "Brester");
        record.put("age", "21");
        updatedFileContent.add(record);

        record = new LinkedHashMap<String, String>();
        record.put("firstName", "Mike");
        record.put("lastName", "Brester");
        record.put("age", "26");
        updatedFileContent.add(record);

        fileService.overWriteRecords(updatedFileContent);
    }
}
