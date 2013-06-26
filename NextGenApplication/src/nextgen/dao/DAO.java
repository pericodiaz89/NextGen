package nextgen.dao;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.json.JSONArray;
import lib.json.JSONObject;
import nextgen.model.Attribute;
import nextgen.model.Element;
import nextgen.model.Entity;
import nextgen.model.Key;
import nextgen.model.Project;
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

    public Project getProjects(String dir) throws Exception {
        
        //Read JSON
        JSONObject obj;
        obj = fileManager.loadData(dir);
        
        //Capture name and description project
        String nameProject = obj.getString("name");
        String descriptionProject = obj.getString("description");

        //Capture elements project
        HashSet<Element> elementList = new HashSet<>();        
        JSONArray elements = obj.getJSONArray("elements");
        
        //Cycle for each element
        for (int i = 0; i < elements.length(); i++) {
            
            //Capture keys element
            JSONObject elem = elements.getJSONObject(i);            
            JSONArray keys = elem.getJSONArray("keys");
            
            HashSet<Key> keysList = new HashSet<>();    
            
            if (keys != null) {
                //Cycle for each key
                for (int j = 0; j < elements.length(); j++) {
                    JSONObject eachKey = keys.getJSONObject(j);
                    
                    //Capture key information
                    String keyName = eachKey.getString("name");
                    String k = eachKey.getJSONObject("type").toString();                    
                    KeyType keyType = (k.equals("Primary")) ? KeyType.Primary : KeyType.Unique;                    
                    
                    //Attributes
                    JSONArray attributes = elem.getJSONArray("attributes");
                    HashSet<Attribute> attributeList = getAttributes(attributes);
                    
                    //Add key List
                    keysList.add((attributeList == null) ? new Key(keyName, keyType) : new Key(keyName, keyType, attributeList));                                        
                }                
            }
            
            //Capture information element
            String descriptionElement = elem.getString("description");
            String tableNameElement = elem.getString("tablename");
            String nameElement = elem.getString("name");
            
            //Package
            JSONObject packageElem = elem.getJSONObject("package");
            String descriptionPackage = packageElem.getString("description");
            String namePackage = packageElem.getString("name");
            Package packageElement = new Package(namePackage, descriptionPackage);
            
            //Attributes
            JSONArray attributes = elem.getJSONArray("attributes");
            HashSet<Attribute> attributeList = getAttributes(attributes);
            
            //Add to element list
            elementList.add(new Element(nameElement, descriptionElement, tableNameElement, packageElement, null, attributeList, keysList));

        }        
        return new Project(nameProject, descriptionProject, elementList);

    }
    
    private HashSet<Attribute> getAttributes(JSONArray attributes) throws Exception{        
        HashSet<Attribute> attributeList = new HashSet<>();
        if (attributes != null) {
            for (int k = 0; k < attributes.length(); k++) {
                //Capture Attribute information                
                JSONObject attr = attributes.getJSONObject(k);
                String autoIncrement = attr.getString("autoincrement");
                String nameAttr = attr.getString("name");
                
                //Entity
                JSONObject entity = attr.getJSONObject("entity");
                String descriptionEntity = entity.getString("description");
                String nameEntity = entity.getString("name");

                Entity entityModel = new Entity(nameEntity, descriptionEntity);
                
                String commonTable = attr.getString("commonTable");
                String required = attr.getString("required");
                String comment = attr.getString("comment");
                String defaultValue = attr.getString("defaultValue");
                
                String cardinality = attr.getJSONObject("cardinality").toString();
                Cardinality c = (cardinality.equals("Multiple")) ? Cardinality.Multiple : Cardinality.Single;
                
                //Add attribute List
                attributeList.add(new Attribute(1, nameAttr, entityModel, c, Boolean.parseBoolean(required), comment, defaultValue, Boolean.parseBoolean(autoIncrement), commonTable));
            }
        }else{
            return null;
        }
        return attributeList;
    }

    public void saveProject(Project project, String path) throws Exception {
        JSONObject obj = new JSONObject(project.toHashMap());
        fileManager.saveData(obj, path + project.getName() + ".ng");
    }

    public static void main(String[] args) {
        DAO dao = new DAO();

        try {
            Project p = dao.getProjects("src/nextgen/files/test.ng");
            System.out.println(p.toHashMap().toString());            
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
