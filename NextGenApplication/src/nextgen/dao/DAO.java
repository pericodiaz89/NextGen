package nextgen.dao;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

    public DAO() {
        fileManager = new FileManager();
    }

    public Project getProjects(String dir) throws Exception {

        JSONObject obj = fileManager.loadData(dir);

        Gson gson = new Gson();
        Map<String, String> mapResult = new HashMap<>();
        mapResult = gson.fromJson(obj.toString(), mapResult.getClass());

        HashSet<Element> elementsList = new HashSet();

        for (int i = 2; i < mapResult.size(); i++) {
            
            List list = new ArrayList();
            list.add(mapResult.values().toArray()[i]);
                        
            System.out.println("");
            //Package package1 = new Package(list.get(0)[0] , list.get(0)[0]);
//
//            Entity entity = new Entity("Entity1", "An Entity");
//
//            Attribute atrribute = new Attribute(25, "roomId", entity, Cardinality.Single, true, null, null, false, "");
//
//            HashSet<Attribute> attributes = new HashSet<>();
//            attributes.add(atrribute);
//
//            Key key = new Key("Key", KeyType.Unique, attributes);
//
//            HashSet<Key> keys = new HashSet<>();
//            keys.add(key);
//
//            Element element = new Element("House", "Pretty House", "Tbl_House", package1, null, attributes, keys);
//
//            HashSet<Element> elements = new HashSet<>();
//            elements.add(element);
//
//            Project project = new Project(1, "TestProject", "This is a test project", elements);

            //elementsList.add((Element) mapResult.values().toArray()[i]);
        }

        Project project = new Project(5, (String) mapResult.values().toArray()[0], (String) mapResult.values().toArray()[1], elementsList);

        //System.out.println(project.getElements().toArray()[0]);

        return project;
    }

    public void saveProject(Project project) {
        int iter = 1;
        HashMap<String, Object> data = new HashMap<>();

        Iterator elements = project.getElements().iterator();
        data.put("Name", project.getName());
        data.put("Description", project.getDescription());

        while (elements.hasNext()) {
            data.put("Element-" + iter++, elements.next());
        }

        JSONObject obj = new JSONObject(data);
        try {
            fileManager.saveData(obj, "src/nextgen/files/" + project.getName() + ".ng");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Package package1 = new Package("nextgen.Entities", "No desc");
        Package package2 = new Package("nextgen.Entities", "No desc");

        Entity entity = new Entity("Entity1", "An Entity");
        Entity entity2 = new Entity("Entity2", "A Greater Entity");

        Attribute atrribute = new Attribute(25, "roomId", entity, Cardinality.Single, true, null, null, false, "");
        Attribute atrribute2 = new Attribute(26, "roomTenant", entity, Cardinality.Single, true, null, null, false, "");
        Attribute atrribute3 = new Attribute(27, "roomState", entity2, Cardinality.Multiple, true, null, null, false, "");
        Attribute atrribute4 = new Attribute(28, "roomTomcat", entity2, Cardinality.Multiple, true, null, null, false, "");

        HashSet<Attribute> attributes = new HashSet<>();
        attributes.add(atrribute);
        attributes.add(atrribute2);

        HashSet<Attribute> attributes2 = new HashSet<>();
        attributes2.add(atrribute3);
        attributes2.add(atrribute4);

        Key key = new Key("Key", KeyType.Unique, attributes);
        Key key2 = new Key("Key", KeyType.Unique, attributes2);

        HashSet<Key> keys = new HashSet<>();
        keys.add(key);

        HashSet<Key> keys2 = new HashSet<>();
        keys2.add(key2);

        Element element = new Element("House", "Pretty House", "Tbl_House", package1, null, attributes, keys);
        Element element2 = new Element("Room", "Pretty Room", "Tbl_Room", package2, null, attributes2, keys2);

        HashSet<Element> elements = new HashSet<>();
        elements.add(element);
        elements.add(element2);

        Project project =
                new Project(1, "TestProject", "This is a test project", elements);

        DAO dao = new DAO();
        try {
            //dao.saveProject(project);
            dao.getProjects("src/nextgen/files/TestProject.ng");
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
