package nextgen.view;

import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import nextgen.model.Element;
import nextgen.model.Package;
import nextgen.model.Project;

public final class FProject extends javax.swing.JFrame {

    private Project project;
    private DefaultListModel<Element> model;
    private HashMap<String, nextgen.model.Package> packages;

    public FProject() {
        this.project = new Project("", "");
        initComponents();
        setLocationRelativeTo(null);
        packages = new HashMap<>();
        model = new DefaultListModel<>();
        listElements.setModel(model);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listElements = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        bAdd = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        spElements = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        tName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tDescription = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        bUpdate = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mNew = new javax.swing.JMenuItem();
        mImport = new javax.swing.JMenuItem();
        mSave = new javax.swing.JMenuItem();
        mGenerate = new javax.swing.JMenuItem();
        mAddPackage = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NextGen Application\n");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Elements"));

        listElements.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listElementsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listElements);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        bAdd.setText("Add");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });
        jPanel2.add(bAdd);

        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(bDelete);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Project Information"));

        jLabel1.setText("Name:");

        tDescription.setColumns(20);
        tDescription.setRows(5);
        jScrollPane2.setViewportView(tDescription);

        jLabel2.setText("Description:");

        bUpdate.setText("Update");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tName))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bUpdate)
                .addContainerGap())
        );

        jMenu1.setText("NextGen Functions");

        mNew.setText("New");
        jMenu1.add(mNew);

        mImport.setText("Import");
        jMenu1.add(mImport);

        mSave.setText("Save");
        jMenu1.add(mSave);

        mGenerate.setText("Generate");
        jMenu1.add(mGenerate);

        jMenuBar1.add(jMenu1);

        mAddPackage.setText("Packages");

        jMenuItem1.setText("Add Package");
        mAddPackage.add(jMenuItem1);

        jMenuBar1.add(mAddPackage);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spElements, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spElements, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listElementsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listElementsValueChanged
        int[] selected = listElements.getSelectedIndices();
        if (selected.length == 0){
        }else if (selected.length == 1){
            Element element = (Element) listElements.getSelectedValue();
            PElement pElement = new PElement(this, element);
            spElements.setViewportView(pElement);
        }else{
            spElements.setViewportView(new JPanel());
        }
    }//GEN-LAST:event_listElementsValueChanged

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        Element e = new Element("NewElement", "", "newelement");
        project.getElements().add(e);
        if (PElement.cbEntities != null){
            PElement.cbEntities.addItem(e);
        }
        refreshElementList();
        listElements.setSelectionInterval(listElements.getLastVisibleIndex(), listElements.getLastVisibleIndex());
    }//GEN-LAST:event_bAddActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        int[] selected = listElements.getSelectedIndices();
        if (selected.length > 0){
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete " + selected.length + " Element(s)?", "Warning!", JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_OPTION){
                for (int index : selected){
                    project.getElements().remove((Element)listElements.getModel().getElementAt(index));
                    PElement.cbEntities.removeItem(listElements.getModel().getElementAt(index));
                }
                refreshElementList();
            }
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        project.setName(tName.getText());
        project.setDescription(tDescription.getText());
    }//GEN-LAST:event_bUpdateActionPerformed

    // <editor-fold defaultstate="collapsed" desc="Variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listElements;
    private javax.swing.JMenu mAddPackage;
    private javax.swing.JMenuItem mGenerate;
    private javax.swing.JMenuItem mImport;
    private javax.swing.JMenuItem mNew;
    private javax.swing.JMenuItem mSave;
    private javax.swing.JScrollPane spElements;
    private javax.swing.JTextArea tDescription;
    private javax.swing.JTextField tName;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>

    public void refreshElementList() {
        model.removeAllElements();
        for (Element e : project.getElements()){
            model.addElement(e);
            if (!packages.containsKey(e.getPackage1().getName())){
                packages.put(e.getPackage1().getName(), e.getPackage1());
            }else{
                e.setPackage1(packages.get(e.getPackage1().getName()));
            }
        }
    }

    public HashMap<String, Package> getPackages() {
        return packages;
    }

    public Project getProject() {
        return project;
    }

    private void setData() {
        tName.setText(project.getName());
        tDescription.setText(project.getDescription());
    }
}
