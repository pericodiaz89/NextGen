/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nextgen.dao;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import lib.json.JSONObject;

/**
 *
 * @author Rodrigo
 */
public class FileManager {
    
    public Object loadData(String fileName) throws Exception {
        FileInputStream fis;
        ObjectInputStream in;
        fis = new FileInputStream(fileName);
        in = new ObjectInputStream(fis);
        Object object = in.readObject();
        in.close();
        return object;
    }
    
    public void saveData(JSONObject object, String fileName) throws Exception {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(object.toString());
            file.flush();
        }
    }
}
