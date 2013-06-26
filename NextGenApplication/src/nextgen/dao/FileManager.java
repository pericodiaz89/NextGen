/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nextgen.dao;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import lib.json.JSONObject;

/**
 *
 * @author Rodrigo
 */
public class FileManager {

    public JSONObject loadData(String fileName) throws Exception {
        //http://codigomaldito.blogspot.com/2011/06/como-leer-un-archivo-de-texto-en-java.html
        DataInputStream in = new DataInputStream(new FileInputStream(fileName));
        BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
        StringBuilder jsonFormat = new StringBuilder();
        String strLinea;
        while ((strLinea = buffer.readLine()) != null) {
            jsonFormat.append(strLinea);
        }

        JSONObject obj = new JSONObject(jsonFormat.toString());
        in.close();
        return obj;
    }

    public void saveData(JSONObject object, String fileName) throws Exception {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(object.toString());
            file.flush();
        }
    }
}
