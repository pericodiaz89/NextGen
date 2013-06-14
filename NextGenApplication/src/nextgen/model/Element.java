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
    private String tableName;
    private Package package1;
    private HashSet<Attribute> attributes;
    private HashSet<Key> keys;

    public Element(String name, String description, String tableName, Package package1, Element parent, HashSet<Attribute> attributes, HashSet<Key> keys) {
        super(name, description);
        this.parent = parent;
        this.tableName = tableName;
        this.package1 = package1;
        this.attributes = attributes;
        this.keys = keys;
    }

    public Element(String name, String description, String tableName) {
        super(name, description);
        parent = null;
        this.tableName = tableName;
        this.package1 = new Package("", "");
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

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Package getPackage1() {
        return package1;
    }

    public void setPackage1(Package package1) {
        this.package1 = package1;
    }

    // </editor-fold>

}
