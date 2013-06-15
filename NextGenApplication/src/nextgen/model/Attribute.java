/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nextgen.model;

import nextgen.model.enums.Cardinality;

/**
 *
 * @author Rodrigo
 */
public class Attribute {

    private String name;
    private Entity entity;
    private Cardinality cardinality;
    private boolean required;
    private String comment;
    private String defaultValue;
    private int id;
    private boolean autoincrement; 

    public Attribute(int id, String name, Entity entity, Cardinality cardinality, boolean required, String comment, String defaultValue, boolean autoincrement, String commonTable) {
        this.name = name;
        this.entity = entity;
        this.cardinality = cardinality;
        this.required = required;
        this.comment = comment;
        this.defaultValue = defaultValue;
        this.autoincrement = autoincrement;
    }

    // <editor-fold defaultstate="collapsed" desc="Get and Set">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Cardinality getCardinality() {
        return cardinality;
    }

    public void setCardinality(Cardinality cardinality) {
        this.cardinality = cardinality;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the autoincrement
     */
    public boolean isAutoincrement() {
        return autoincrement;
    }

    /**
     * @param autoincrement the autoincrement to set
     */
    public void setAutoincrement(boolean autoincrement) {
        this.autoincrement = autoincrement;
    }
    // </editor-fold>

}
