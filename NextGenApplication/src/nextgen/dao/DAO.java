package nextgen.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.json.JSONObject;
import nextgen.model.Element;
import nextgen.model.Project;
import nextgen.model.Attribute;
import nextgen.model.Entity;
import nextgen.model.Key;
import nextgen.model.Package;
import nextgen.model.enums.Cardinality;
import nextgen.model.enums.KeyType;

/**
 *
 * @author Rodrigo
 */
public class DAO {
    
    private FileManager fileManager;
    
    public DAO(){
        fileManager = new FileManager();
    }
    
    public Project getProjects(String dir){
        return null;
    }
    
    public void saveProject(Project project){
        int iter = 1;
        HashMap<String, Object> data = new HashMap<>();
        
        Iterator elements = project.getElements().iterator();
        while(elements.hasNext()){
            data.put("Entity-" + iter++, elements.next());            
        }
        JSONObject obj = new JSONObject(data);
        
        try {
            fileManager.saveData(obj, "file1.txt");
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        
    }
    
    public static void main(String [] args){       

        Package package1 = new Package("nextgen.Entities", "No desc");
        
        Entity entity = new Entity("Entity1", "An Entity");
        
        Attribute atrribute = new Attribute(25, "roomId", entity, Cardinality.Single, true, null, null, false, "" );
        
        HashSet<Attribute> attributes = new HashSet<>();
        attributes.add(atrribute);
        
        Key key = new Key("Key", KeyType.Unique, attributes);
        
        HashSet<Key> keys = new HashSet<>();
        keys.add(key);
        
        Element element = new Element("House", "Pretty House", "Tbl_House", package1, null, attributes, keys);
        
        HashSet<Element> elements = new HashSet<>();       
        elements.add(element);
        
        Project project = 
                new Project(1, "TestProject", "This is a test project" , elements);
        
        DAO dao = new DAO();
        try {
            dao.saveProject(project);
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
