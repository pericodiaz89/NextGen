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
public class Package extends Entity {

    private HashSet<Package> packages;

    public Package(String name, String description, HashSet<Package> packages) {
        super(name, description);
        this.packages = packages;
    }

    public Package(int id, String name, String description) {
        super(name, description);
        this.packages = new HashSet<>();
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
