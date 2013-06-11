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
public class Project extends Entity {

    private HashSet<Package> packages;

    public Project(int id, String name, String description) {
        super(id, name, description);
        packages = new HashSet<>();
    }

    public Project(int id, String name, String description, HashSet<Package> packages) {
        super(id, name, description);
        this.packages = packages;
    }

    // <editor-fold defaultstate="collapsed" desc="Get and Set">
    public HashSet<Package> getPackages() {
        return packages;
    }

    public void setPackages(HashSet<Package> packages) {
        this.packages = packages;
    }
    // </editor-fold>
}
