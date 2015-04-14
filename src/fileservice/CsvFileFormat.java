/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.util.*;

/**
 *
 * @author Mitch
 */
public class CsvFileFormat implements FileFormaterStrategy{

    @Override
    public List<LinkedHashMap<String, String>> unformatData(String data) {
         List<LinkedHashMap<String,String>> records = new ArrayList<>();
         String[] rows = data.split("\n");
         String[] header = rows[0].split(",");
         
         for(int i  = 1 ; i < rows.length; i++ ){
             LinkedHashMap<String,String> record = new LinkedHashMap<>();
             String[] rowData = rows[i].split(",");
             for(int t = 0;t<rowData.length;t++){
                 record.put(header[t], rowData[t]);
             }
             records.add(record);
         }
         return records;
    }

    @Override
    public String formatData(List<LinkedHashMap<String, String>> data) {
        StringBuilder formatedData = new StringBuilder();
        
        for (int t = 0; t<data.size(); t++ ) {
            
            Set keySet = data.get(t).keySet();
            List<String> keys = new ArrayList<>(keySet);
            if(t==0){
                for(String key: keys){
                    formatedData.append(key).append(",");
                }
                formatedData.append("\n");
            }
            
            for(int i =0; i<data.get(t).size();i++){
                String key = keys.get(i);
                if(i < (data.get(t).size()-1)){
                    
                
                formatedData.append(data.get(t).get(key)).append(",");
                }else{
                  formatedData.append(data.get(t).get(key));  
                }
                    
                
            }
            formatedData.append("\n");
        }
        
        return formatedData.toString();
        
    }
    
}
