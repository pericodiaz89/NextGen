package nextgen.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.json.JSONException;
import lib.json.JSONObject;
import nextgen.model.Element;
import nextgen.model.Project;

/**
 *
 * @author Rodrigo
 */
public class DAO {

    private FileManager fileManager;

    public DAO(){
        fileManager = new FileManager();
    }

    public Project getProjects(String dir) throws JSONException{
        JSONObject obj = new JSONObject();        
        try {
            obj = fileManager.loadData(dir);
            
            JSONObject elements = obj.getJSONObject("elements");
                        
            Iterator i = elements.keys();
            while(i.hasNext()){  
                JSONObject elem = (JSONObject) i.next();
                JSONObject keys = elem.getJSONObject("keys");
                if(keys != null){
                    ////////////DUDA PARA RODRIGO ////////////////////
                }
                String descriptionElement = elem.getString("description");
                String tableNameElement = elem.getString("tablename");
                String nameElement = elem.getString("name");
                
                JSONObject packageElement = elem.getJSONObject("package");
                String descriptionPackage = packageElement.getString("description");
                String namePackage = packageElement.getString("name");
                
                JSONObject attributes = elem.getJSONObject("attributes");
                if (attributes != null){
                    
                    Iterator attributeIter = attributes.keys();
                    while(attributeIter.hasNext()){
                        JSONObject attr = (JSONObject) attributeIter.next();
                        String autoIncrement = attr.getString("true");
                        String nameAttr = attr.getString("name");
                        
                        JSONObject entity = attr.getJSONObject("entity");
                        String descriptionEntity = entity.getString("description");
                        String nameEntity = entity.getString("name");
                        
                        String commonTable = entity.getString("commonTable");
                        String required = entity.getString("required");
                        String comment = entity.getString("comment");
                        String defaultValue = entity.getString("defaultValue");
                        String cardinality = entity.getJSONObject("cardinality").toString();
                    }
                }
            }
        } catch (Exception ex) {
            ex.getMessage();
        }        
        return null;
    }

     public HashSet<Element> getElements(JSONObject obj){
         HashSet<Element> elementList = new HashSet<>();
         
         return null;
     }
    
    public void saveProject(Project project, String path) throws Exception {
        JSONObject obj = new JSONObject(project.toHashMap());
        fileManager.saveData(obj, path + project.getName() + ".ng");
    }
    
    public static void main(String [] args){
        DAO dao = new DAO();
        
        try {
            dao.getProjects("src/nextgen/files/test.ng");
        } catch (JSONException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
