/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Mitch
 */
public interface FileFormaterStrategy {

    public List<LinkedHashMap<String, String>> unformatData(String data);

    public String formatData(List<LinkedHashMap<String, String>> data);
    
}
