package nextgen.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.json.JSONArray;
import lib.json.JSONException;
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
        
        JSONObject obj;
        obj = fileManager.loadData(dir);
        
        System.out.println(obj.toString());
        String nameProject = obj.getString("name");
        String descriptionProject = obj.getString("description");

        HashSet<Element> elementList = new HashSet<>();        
        JSONArray elements = obj.getJSONArray("elements");
        
        for (int i = 0; i < elements.length(); i++) {
            
            JSONObject elem = elements.getJSONObject(i);            
            JSONArray keys = elem.getJSONArray("keys");
            
            HashSet<Key> keysList = new HashSet<>();    
            
            if (keys != null) {
                //DUDA PARA RODRIGO, creo que la segunda KEYS es attributes
                for (int j = 0; j < elements.length(); j++) {
                    JSONObject eachKey = keys.getJSONObject(j);
                    
                    String keyName = eachKey.getString("name");
                    String k = eachKey.getJSONObject("type").toString();
                    
                    KeyType keyType;
                    if (k.equals("Primary")) {
                        keyType = KeyType.Primary;
                    } else {
                        keyType = KeyType.Unique;
                    }
                    
                    JSONArray attributes = elem.getJSONArray("attributes");
                    HashSet<Attribute> attributeList = getAttribute(attributes);
                    
                    if(attributeList == null){
                        keysList.add(new Key(keyName, keyType));
                    }else{
                        keysList.add(new Key(keyName, keyType, attributeList));
                    }
                }                
            }
            
            String descriptionElement = elem.getString("description");
            String tableNameElement = elem.getString("tablename");
            String nameElement = elem.getString("name");

            JSONObject packageElem = elem.getJSONObject("package");
            String descriptionPackage = packageElem.getString("description");
            String namePackage = packageElem.getString("name");

            Package packageElement = new Package(namePackage, descriptionPackage);

            JSONArray attributes = elem.getJSONArray("attributes");
            HashSet<Attribute> attributeList = getAttribute(attributes);
                                    
            elementList.add(new Element(nameElement, descriptionElement, tableNameElement, packageElement, null, attributeList, keysList));

        }        
        return new Project(nameProject, descriptionProject, elementList);

    }
    
    private HashSet<Attribute> getAttribute(JSONArray attributes) throws Exception{
        
        HashSet<Attribute> attributeList = new HashSet<>();
        if (attributes != null) {
            for (int k = 0; k < attributes.length(); k++) {
                JSONObject attr = attributes.getJSONObject(k);
                String autoIncrement = attr.getString("autoincrement");
                String nameAttr = attr.getString("name");

                JSONObject entity = attr.getJSONObject("entity");
                String descriptionEntity = entity.getString("description");
                String nameEntity = entity.getString("name");

                Entity entityModel = new Entity(nameEntity, descriptionEntity);

                String commonTable = attr.getString("commonTable");
                String required = attr.getString("required");
                String comment = attr.getString("comment");
                String defaultValue = attr.getString("defaultValue");
                String cardinality = attr.getJSONObject("cardinality").toString();

                Cardinality c;
                if (cardinality.equals("Multiple")) {
                    c = Cardinality.Multiple;
                } else {
                    c = Cardinality.Single;
                }
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
