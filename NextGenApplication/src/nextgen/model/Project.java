/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nextgen.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Rodrigo
 */
public class Project extends Entity {

    private HashSet<Element> elements;

    public Project(String name, String description) {
        super(name, description);
        elements = new HashSet<>();
    }

    public Project(String name, String description, HashSet<Element> elements) {
        super(name, description);
        this.elements = elements;
    }
    
    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = super.toHashMap();
        ArrayList<HashMap<String, Object>> elementList = new ArrayList<>();
        for (Element a : this.elements) {
            elementList.add(a.toHashMap());
        }
        map.put("elements", elementList);
        
        return map;
    }

    // <editor-fold defaultstate="collapsed" desc="Get and Set">
    public HashSet<Element> getElements() {
        return elements;
    }

    public void setElements(HashSet<Element> elements) {
        this.elements = elements;
    }
    // </editor-fold>
}
