/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nextgen.view;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import nextgen.model.Attribute;
import nextgen.model.Element;
import nextgen.model.Entity;
import nextgen.model.Key;
import nextgen.model.Package;
import nextgen.model.enums.Cardinality;

/**
 *
 * @author Rodrigo
 */
public class PElement extends javax.swing.JPanel {

    private FProject project;
    private Element element;
    private String[] columnTitles = new String[]{"Id", "Name", "Type", "Cardinality", "Required", "Default Value", "Comment"};
    private DefaultTableModel tableModel;
    private DefaultListModel<Key> listModel;
    public static JComboBox<Entity> cbEntities;
    public static JComboBox<Cardinality> cbCardinality;

    public PElement(FProject project, Element element) {
        this.project = project;
        this.element = element;
        initComponents();
        setTableModels();
        setListModel();
        setPackages();
        setParents();
        setElement();
        addListeners();
        refreshTable();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbPackages = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        tDescription = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tTableName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbParents = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAttributes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listKeys = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bUpdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bCreateKey = new javax.swing.JButton();
        bEditKey = new javax.swing.JButton();
        bDeleteKey = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bCreateAttribute = new javax.swing.JButton();
        bDeleteAttribute = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Basic Information"));

        jLabel1.setText("Name:");

        jLabel2.setText("Package:");

        jLabel3.setText("Description:");

        jLabel4.setText("TableName:");

        jLabel5.setText("Parent:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPackages, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tDescription))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tTableName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbParents, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbPackages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tTableName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbParents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        taAttributes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(taAttributes);

        jScrollPane2.setViewportView(listKeys);

        jLabel6.setText("Attributes:");

        jLabel7.setText("Keys:");

        bUpdate.setText("Update");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        bCreateKey.setText("Create");
        jPanel2.add(bCreateKey);

        bEditKey.setText("Edit");
        jPanel2.add(bEditKey);

        bDeleteKey.setText("Delete");
        jPanel2.add(bDeleteKey);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        bCreateAttribute.setText("Create");
        bCreateAttribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateAttributeActionPerformed(evt);
            }
        });
        jPanel3.add(bCreateAttribute);

        bDeleteAttribute.setText("Delete");
        jPanel3.add(bDeleteAttribute);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addComponent(bUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        element.setName(tName.getText());
        element.setDescription(tDescription.getText());
        element.setTableName(tTableName.getText());
        element.setPackage1((Package) cbPackages.getSelectedItem());
        if (cbParents.getSelectedIndex() > 0) {
            element.setParent((Element) cbParents.getSelectedItem());
        } else {
            element.setParent(null);
        }

        project.refreshElementList();
    }//GEN-LAST:event_bUpdateActionPerformed

    private void bCreateAttributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateAttributeActionPerformed
        Attribute attribute = new Attribute("", new Element("", "", ""), Cardinality.Single, false, "", "");
        element.getAttributes().add(attribute);
        tableModel.addRow(attribute.getRow());
        NextGenHelper.adjustColumns(taAttributes);
    }//GEN-LAST:event_bCreateAttributeActionPerformed
    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCreateAttribute;
    private javax.swing.JButton bCreateKey;
    private javax.swing.JButton bDeleteAttribute;
    private javax.swing.JButton bDeleteKey;
    private javax.swing.JButton bEditKey;
    private javax.swing.JButton bUpdate;
    private javax.swing.JComboBox cbPackages;
    private javax.swing.JComboBox cbParents;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listKeys;
    private javax.swing.JTextField tDescription;
    private javax.swing.JTextField tName;
    private javax.swing.JTextField tTableName;
    private javax.swing.JTable taAttributes;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>

    private void setElement() {
        tName.setText(element.getName());
        tDescription.setText(element.getDescription());
        tTableName.setText(element.getTableName());
        cbPackages.setSelectedItem(element.getPackage1());
        if (element.getParent() != null) {
            cbParents.setSelectedItem(element.getParent());
        }
    }

    private void setPackages() {
        for (nextgen.model.Package p : project.getPackages().values()) {
            cbPackages.addItem(p);
        }
    }

    private void setParents() {
        cbParents.addItem(new Element("", "", ""));
        for (Element e : project.getProject().getElements()) {
            if (!e.equals(element)) {
                cbParents.addItem(e);
            }
        }
    }

    private void addListeners() {
        tName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                tTableName.setText(tName.getText().toLowerCase());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                tTableName.setText(tName.getText().toLowerCase());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    private void setTableModels() {
        if (cbEntities == null) {
            cbEntities = new JComboBox<>();
            for (Entity e : NextGenHelper.primitives) {
                cbEntities.addItem(e);
            }
            for (Entity e : project.getProject().getElements()) {
                cbEntities.addItem(e);
            }
        }
        if (cbCardinality == null) {
            cbCardinality = new JComboBox<>();
            for (Cardinality c : Cardinality.values()) {
                cbCardinality.addItem(c);
            }
        }
        tableModel = new DefaultTableModel(null, columnTitles) {
            @Override
            public Class getColumnClass(int c) {
                return getValueAt(0, c).getClass();
            }
        };
        taAttributes.setModel(tableModel);
        TableColumn colEntity = taAttributes.getColumnModel().getColumn(2);
        colEntity.setCellEditor(new DefaultCellEditor(cbEntities));
        TableColumn colCardinality = taAttributes.getColumnModel().getColumn(3);
        colCardinality.setCellEditor(new DefaultCellEditor(cbCardinality));

        tableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                Attribute attribute = (Attribute) tableModel.getValueAt(e.getFirstRow(), 0);
                switch (e.getColumn()) {
                    case 1:
                        attribute.setName((String) tableModel.getValueAt(e.getFirstRow(), e.getColumn()));
                        break;
                    case 2:
                        attribute.setEntity((Entity) tableModel.getValueAt(e.getFirstRow(), e.getColumn()));
                        break;
                    case 3:
                        attribute.setCardinality((Cardinality) tableModel.getValueAt(e.getFirstRow(), e.getColumn()));
                        break;
                    case 4:
                        attribute.setRequired((Boolean) tableModel.getValueAt(e.getFirstRow(), e.getColumn()));
                        break;
                    case 5:
                        attribute.setDefaultValue((String) tableModel.getValueAt(e.getFirstRow(), e.getColumn()));
                        break;
                    case 6:
                        attribute.setComment((String) tableModel.getValueAt(e.getFirstRow(), e.getColumn()));
                        break;
                }
            }
        });
    }

    private void setListModel() {
        listModel = new DefaultListModel<>();
        listKeys.setModel(listModel);
    }

    private void refreshTable() {
        if (tableModel.getRowCount() > 0){
            tableModel.removeRow(0);
        }
        for (Attribute attribute : element.getAttributes()){
            tableModel.addRow(attribute.getRow());
        }
        NextGenHelper.adjustColumns(taAttributes);
    }
}
