/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nextgen.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import nextgen.model.enums.KeyType;

/**
 *
 * @author Rodrigo
 */
public class Key {

    private String name;
    private KeyType type;
    private HashSet<Attribute> attributes;

    public Key(String name, KeyType type) {
        this.name = name;
        this.type = type;
        attributes = new HashSet<>();
    }

    public Key(String name, KeyType type, HashSet<Attribute> attributes) {
        this.name = name;
        this.type = type;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return name + " : " + type.toString();
    }

    public HashMap<String, Object> toHashMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", this.getName());
        map.put("type", this.getType());

        ArrayList<Integer> attributeList = new ArrayList<>();
        for (Attribute a : this.attributes) {
            attributeList.add(a.getId());
        }
        map.put("attributes", attributeList);

        return map;
    }


    // <editor-fold defaultstate="collapsed" desc="Get and Set">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public KeyType getType() {
        return type;
    }

    public void setType(KeyType type) {
        this.type = type;
    }

    public HashSet<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashSet<Attribute> attributes) {
        this.attributes = attributes;
    }
    // </editor-fold>
}
