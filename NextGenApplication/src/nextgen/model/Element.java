/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nextgen.model;

import java.util.HashSet;

/**
 *
 * @author Rodrigo
 */
public class Element extends Entity {

    private Element parent;
    private HashSet<Attribute> attributes;
    private HashSet<Key> keys;

    public Element(int id, String name, String description, Element parent, HashSet<Attribute> attributes, HashSet<Key> keys) {
        super(id, name, description);
        this.parent = parent;
        this.attributes = attributes;
        this.keys = keys;
    }

    public Element(int id, String name, String description) {
        super(id, name, description);
        parent = null;
        attributes = new HashSet<>();
        keys = new HashSet<>();
    }

    // <editor-fold defaultstate="collapsed" desc="Get and Set">
    
    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }

    public HashSet<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashSet<Attribute> attributes) {
        this.attributes = attributes;
    }

    public HashSet<Key> getKeys() {
        return keys;
    }

    public void setKeys(HashSet<Key> keys) {
        this.keys = keys;
    }
    // </editor-fold>
}
