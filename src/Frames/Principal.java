/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import RastreoCovid.dao.PeopleJpaController;
import RastreoCovid.entity.People;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;

/**
 *
 * @author angep
 */
public class Principal extends javax.swing.JFrame {
    ImageIcon imageFondo = new ImageIcon("fondo.png");
    PeopleJpaController CPeople = new PeopleJpaController();
    List<People> listP = CPeople.findPeopleEntities(); //Lista de todas las Personas.
    People p = new People();
    DefaultTableModel modeloPersonas;   //tabla de Personas
    DefaultListModel modeloAmigos = new DefaultListModel<>();
    DefaultListModel modeloDisponibles = new DefaultListModel<>();

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setIconoBoton();
        crearTablaPersonas();
        rellenarTablaPersonas();
        
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        bDer = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla3 = new javax.swing.JList<>();
        bIzq = new javax.swing.JButton();
        lFondo = new javax.swing.JLabel();
        jPersonas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rastreo Covid19");
        setBounds(new java.awt.Rectangle(500, 200, 400, 300));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Personas");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(210, 40, 96, 29);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(40, 90, 430, 260);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Amigos");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(580, 40, 80, 40);

        jScrollPane2.setViewportView(tabla2);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(510, 90, 220, 260);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Disponibles");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(940, 40, 140, 40);

        bDer.setBackground(new java.awt.Color(255, 255, 255));
        bDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frames/FlechaD2.png"))); // NOI18N
        bDer.setToolTipText("");
        bDer.setBorderPainted(false);
        bDer.setContentAreaFilled(false);
        bDer.setFocusPainted(false);
        bDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDerActionPerformed(evt);
            }
        });
        jPanel2.add(bDer);
        bDer.setBounds(760, 150, 70, 40);

        jScrollPane3.setViewportView(tabla3);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(870, 90, 260, 260);

        bIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frames/FlechaI2.png"))); // NOI18N
        bIzq.setBorderPainted(false);
        bIzq.setContentAreaFilled(false);
        bIzq.setFocusPainted(false);
        bIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIzqActionPerformed(evt);
            }
        });
        jPanel2.add(bIzq);
        bIzq.setBounds(760, 240, 70, 40);

        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frames/fondo.png"))); // NOI18N
        lFondo.setText(" ");
        jPanel2.add(lFondo);
        lFondo.setBounds(0, -40, 1400, 800);

        jPersonas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPersonas.setForeground(new java.awt.Color(255, 255, 255));
        jPersonas.setText("Personas");
        jPanel2.add(jPersonas);
        jPersonas.setBounds(190, 40, 96, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setIconoBoton() {
        ImageIcon iconD = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FlechaD2.png")));
        Image img = iconD.getImage();

        Image newimg = img.getScaledInstance(bDer.getWidth(), bDer.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconD = new ImageIcon(newimg);
        bDer.setIcon(iconD);

        ImageIcon iconI = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FlechaI2.png")));
        img = iconI.getImage();

        Image newimg2 = img.getScaledInstance(bIzq.getWidth(), bIzq.getHeight(), java.awt.Image.SCALE_SMOOTH);
        iconI = new ImageIcon(newimg2);
        bIzq.setIcon(iconI);
    }

    //esto crea la tabla de Personas
    private void crearTablaPersonas() {
        try {
            modeloPersonas = (new DefaultTableModel(
                    null, new String[]{
                        "ID", "Nombre",
                        "Apellidos"}) {
                Class[] types = new Class[]{
                    java.lang.Integer.class,
                    java.lang.String.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tabla.setModel(modeloPersonas);
            tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabla2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabla3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }

    //Esto rellena la tabla de personas
    private void rellenarTablaPersonas() {
        try {
            Object o[] = null;

            for (int i = 0; i < listP.size(); i++) {
                modeloPersonas.addRow(o);
                modeloPersonas.setValueAt(listP.get(i).getId(), i, 0);
                modeloPersonas.setValueAt(listP.get(i).getFirstname(), i, 1);
                modeloPersonas.setValueAt(listP.get(i).getLastname(), i, 2);

                //esto pone la columna id mas pequeña
                tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
                tabla.getColumnModel().getColumn(0).setMaxWidth(50);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    //AQUI SE SELECCIONA A UNA PERSONA DE LA LISTA DE PERSONAS
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (tabla.getSelectedRowCount() > 0) {
            int index = tabla.getSelectedRow();
            int id = Integer.parseInt(modeloPersonas.getValueAt(index, 0).toString());
            p = CPeople.findPeople(id);
            rellenarTablaAmigos();
            rellenarTablaDisponibles();
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void rellenarTablaAmigos() {
        modeloAmigos.clear();
        tabla2.setModel(modeloAmigos);

        for (int i = 0; i < listP.size(); i++) {
            if ((p.getPeopleList()).contains(listP.get(i)) || (p.getPeopleList1()).contains(listP.get(i))) {
                modeloAmigos.addElement(listP.get(i).getId() + "; " + listP.get(i).getFirstname() + "; " + listP.get(i).getLastname());
            }
        }
        tabla2.setModel(modeloAmigos);
    }

    private void rellenarTablaDisponibles() {
        modeloDisponibles.clear();
        tabla3.setModel(modeloDisponibles);
        
        for(int i = 0; i < listP.size(); i++) {
            if (!p.getPeopleList().contains(listP.get(i)) && (!p.getPeopleList1().contains(listP.get(i))) && (!listP.get(i).equals(p))) {
                modeloDisponibles.addElement(listP.get(i).getId() + "; " + listP.get(i).getFirstname() + "; " + listP.get(i).getLastname());
            }
        }
        tabla3.setModel(modeloDisponibles);
    }
    
    private void bDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDerActionPerformed
        if (!tabla2.isSelectionEmpty()) {
            String amigoSeleccionado = tabla2.getSelectedValue();
            String[] partes = amigoSeleccionado.split(";");
            int idAmigo = Integer.parseInt(partes[0]);
            People personaAmigo = CPeople.findPeople(idAmigo);
            List<People> listaModificada;
            
            int posicion = p.getPeopleList().indexOf(personaAmigo);
            if (posicion != -1) {
                listaModificada = p.getPeopleList();
                listaModificada.remove(posicion);
                p.setPeopleList(listaModificada);
            }
            
            posicion = p.getPeopleList1().indexOf(personaAmigo);
            if(posicion != -1) {
                listaModificada = p.getPeopleList1();
                listaModificada.remove(posicion);
                p.setPeopleList1(listaModificada);
            }
            try {
                CPeople.edit(p);
            } catch (Exception ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            rellenarTablaAmigos();
            rellenarTablaDisponibles();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione a una persona de la lista de Amigos.");
        }
    }//GEN-LAST:event_bDerActionPerformed

    private void bIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIzqActionPerformed
        if (!tabla3.isSelectionEmpty()) {
            String disponibleSeleccionado = tabla3.getSelectedValue();
            String[] partes = disponibleSeleccionado.split(";");
            int idDisponible = Integer.parseInt(partes[0]);
            People personaDisponible = CPeople.findPeople(idDisponible);
            List<People> listaModificada;
            
            listaModificada = p.getPeopleList();
            listaModificada.add(personaDisponible);
            p.setPeopleList(listaModificada);
            
            try {
                CPeople.edit(p);
            } catch (Exception ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            rellenarTablaAmigos();
            rellenarTablaDisponibles();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione a una persona de la lista de Disponibles.");
        }
    }//GEN-LAST:event_bIzqActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDer;
    private javax.swing.JButton bIzq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jPersonas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lFondo;
    private javax.swing.JTable tabla;
    private javax.swing.JList<String> tabla2;
    private javax.swing.JList<String> tabla3;
    // End of variables declaration//GEN-END:variables

}
