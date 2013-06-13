package nextgen.dao;

import java.util.HashSet;
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
    
    public Project getProjects(){
        return null;
    }
    
    public void saveProject(Project project){
        
    }
    
    public static void main(String [] args){       

        Package package1 = new Package("nextgen.Entities", "No desc");
        
        Entity entity = new Entity("Entity1", "An Entity");
        
        Attribute atrribute = new Attribute("roomId", entity, Cardinality.Single, true, null, null);
        
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
        dao.saveProject(project);
    }
}
