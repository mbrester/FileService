/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Mitch
 */
public interface FileReaderStrategy {

    public abstract List<LinkedHashMap<String,String>> getRecords() throws IOException;
    
}
