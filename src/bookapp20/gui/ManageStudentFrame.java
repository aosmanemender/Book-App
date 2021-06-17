/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookapp20.gui;

import bookapp20.controllers.StudentController;
import bookapp20.entities.Student;
import bookapp20.utilities.StudentTableModel;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author hover
 */
public class ManageStudentFrame extends javax.swing.JInternalFrame {

    private final StudentTableModel stdModel = new StudentTableModel();
    private Student currentStudent = null;

    public ManageStudentFrame() {
        initComponents();
        initialize();
    }

    private void initialize() {
        this.setLocation(50, 50);
        disableAll();
        editBtn.setEnabled(false);
        saveBtn.setEnabled(false);
        deleteBtn.setEnabled(false);

        stdTable.setModel(stdModel);
        stdTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        stdTable.getColumnModel().getColumn(0).setMinWidth(64);
        stdTable.getColumnModel().getColumn(0).setMaxWidth(64);
        stdTable.getColumnModel().getColumn(1).setMinWidth(128);
        stdTable.getColumnModel().getColumn(1).setMaxWidth(128);

        stdTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tableRowSelectedPerformed(e);
            }
        });

    }

    private void enableAll() {
        idField.setEditable(true);
        firstField.setEditable(true);
        lastField.setEditable(true);
    }

    private void disableAll() {
        idField.setEditable(false);
        firstField.setEditable(false);
        lastField.setEditable(false);
    }

    private void clearFields() {
        idField.setText(null);
        firstField.setText(null);
        lastField.setText(null);
    }

    public void reset() {
        sidField.setText(null);
        sfirstField.setText(null);
        slastField.setText(null);
        stdModel.removeAll();
        clearFields();
        saveBtn.setEnabled(false);
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sidField = new javax.swing.JTextField();
        sfirstField = new javax.swing.JTextField();
        slastField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        stdTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        firstField = new javax.swing.JTextField();
        lastField = new javax.swing.JTextField();
        cancelBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        newBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Manage Student");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Student"));

        jLabel1.setText("ID");

        sidField.setColumns(8);

        sfirstField.setColumns(10);

        slastField.setColumns(10);

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        stdTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        stdTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(stdTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sfirstField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(slastField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchBtn)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sfirstField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slastField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Add or Edit Student"));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("ID");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("First Name");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Last Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstField)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel6});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(firstField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lastField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelBtn)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelBtn, deleteBtn, editBtn, newBtn, saveBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn)
                    .addComponent(deleteBtn)
                    .addComponent(editBtn)
                    .addComponent(saveBtn)
                    .addComponent(newBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableRowSelectedPerformed(ListSelectionEvent e) {
        saveBtn.setEnabled(false);
        if (stdTable.getSelectedRow() >= 0) {
            disableAll();
            currentStudent = stdModel.get(stdTable.getSelectedRow());
            idField.setText(currentStudent.getId());
            firstField.setText(currentStudent.getFirstName());
            lastField.setText(currentStudent.getLastName());
            editBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
        } else {
            clearFields();
            editBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
            currentStudent = null;
        }
    }

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        clearFields();
        enableAll();
        idField.requestFocus();
        stdTable.clearSelection();
        saveBtn.setEnabled(true);        
        currentStudent = null;
    }//GEN-LAST:event_newBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String id = idField.getText();
        String first = firstField.getText();
        String last = lastField.getText();
        disableAll();
        
        saveBtn.setEnabled(false);
        if (stdTable.getSelectedRow() < 0) {
            //save
            new SaveStudentWorker(new Student(id, first, last)).execute();
            clearFields();
        } else {
            currentStudent.setFirstName(first);
            currentStudent.setLastName(last);
            new UpdateStudentWorker(currentStudent).execute();
            
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        enableAll();
        saveBtn.setEnabled(true);
        editBtn.setEnabled(false);
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        deleteBtn.setEnabled(false);
        if (currentStudent != null) {
            new DeleteStudentWorker(currentStudent).execute();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private class UpdateStudentWorker extends SwingWorker<String, Void> {

        private Student student;

        public UpdateStudentWorker(Student student) {
            this.student = student;
        }

        @Override
        protected String doInBackground() throws Exception {            
            StudentController.instance.update(student);
            return null;
        }

        @Override
        public void done() {
            try {
                if (get() == null) {
                    stdModel.update(student);                    
                }
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(ManageStudentFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class SaveStudentWorker extends SwingWorker<String, Void> {

        private Student student;

        public SaveStudentWorker(Student student) {
            this.student = student;
        }

        @Override
        protected String doInBackground() throws Exception {
            try {
                StudentController.instance.create(student);
            } catch (SQLException ex) {
                return ex.getMessage();
            }
            return null;
        }

        @Override
        public void done() {
            try {
                if (get() == null) {
                    stdModel.add(student);
                }
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(ManageStudentFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class DeleteStudentWorker extends SwingWorker<String, Void> {

        private Student std;

        public DeleteStudentWorker(Student std) {
            this.std = std;
        }

        @Override
        protected String doInBackground() throws Exception {
            StudentController.instance.deleteByKey(std);
            return null;
        }

        @Override
        public void done() {
            try {
                if (get() == null) {
                    stdTable.clearSelection();
                    stdModel.remove(std);
                    currentStudent = null;
                }
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(ManageStudentFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String subId = sidField.getText();
        String subFirst = sfirstField.getText();
        String subLast = slastField.getText();
        stdModel.removeAll();
        new SearchStudentWorker(subId, subFirst, subLast).execute();
    }//GEN-LAST:event_searchBtnActionPerformed

    private class SearchStudentWorker extends SwingWorker<List<Student>, Void> {

        private final String subId;
        private final String subFirst;
        private final String subLast;

        public SearchStudentWorker(String subId, String subFirst, String subLast) {
            this.subId = subId;
            this.subFirst = subFirst;
            this.subLast = subLast;
        }

        @Override
        protected List<Student> doInBackground() throws Exception {
            return StudentController.instance.findByLike(subId, subFirst, subLast);
        }

        @Override
        public void done() {
            try {
                stdModel.set(get());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(ManageStudentFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField firstField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastField;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField sfirstField;
    private javax.swing.JTextField sidField;
    private javax.swing.JTextField slastField;
    private javax.swing.JTable stdTable;
    // End of variables declaration//GEN-END:variables
}
