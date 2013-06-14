/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nextgen.dao;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

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
    
    public void saveData(Object object, String fileName) throws Exception {
        
        /*FileOutputStream fos;
        ObjectOutputStream out;
        fos = new FileOutputStream(fileName);
        out = new ObjectOutputStream(fos);
        out.writeUTF(object);
        out.close();
        System.out.println("all ok");*/
        
    }
}
