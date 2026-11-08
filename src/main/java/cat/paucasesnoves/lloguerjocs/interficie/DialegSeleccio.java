package cat.paucasesnoves.lloguerjocs.interficie;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DialegSeleccio extends javax.swing.JDialog {

    private List<String> elements = new ArrayList<>();
    private List<Integer> indexosVisibles = new ArrayList<>();
    private int indexSeleccionat = -1;

    public DialegSeleccio(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jListElements.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                jButtonAcceptar.setEnabled(jListElements.getSelectedIndex() != -1);
            }
        });
        jTextFieldCerca.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrar();
            }
        });
        setLocationRelativeTo(parent);
    }

    public void setElements(String titol, List<String> elements) {
        setTitle(titol);
        this.elements = elements;
        filtrar();
    }

    public int getIndexSeleccionat() {
        return indexSeleccionat;
    }

    private void filtrar() {
        String text = jTextFieldCerca.getText().toLowerCase();
        DefaultListModel<String> model = new DefaultListModel<>();
        indexosVisibles.clear();
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).toLowerCase().contains(text)) {
                model.addElement(elements.get(i));
                indexosVisibles.add(i);
            }
        }
        jListElements.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCerca = new javax.swing.JLabel();
        jTextFieldCerca = new javax.swing.JTextField();
        jScrollPaneElements = new javax.swing.JScrollPane();
        jListElements = new javax.swing.JList<>();
        jButtonAcceptar = new javax.swing.JButton();
        jButtonCancellar = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCerca.setText(bundle.getString("DialegSeleccio.jLabelCerca.text"));

        jScrollPaneElements.setViewportView(jListElements);

        jButtonAcceptar.setBackground(new java.awt.Color(86, 150, 86));
        jButtonAcceptar.setEnabled(false);
        jButtonAcceptar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAcceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/confirmar.png")));
        jButtonAcceptar.setText(bundle.getString("DialegSeleccio.jButtonAcceptar.text"));
        jButtonAcceptar.addActionListener(this::jButtonAcceptarActionPerformed);

        jButtonCancellar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/cancellar.png")));
        jButtonCancellar.setText(bundle.getString("DialegSeleccio.jButtonCancellar.text"));
        jButtonCancellar.addActionListener(this::jButtonCancellarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCerca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCerca, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                    .addComponent(jScrollPaneElements, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAcceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancellar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCerca)
                    .addComponent(jTextFieldCerca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneElements, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAcceptar)
                    .addComponent(jButtonCancellar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAcceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcceptarActionPerformed
        int fila = jListElements.getSelectedIndex();
        if (fila != -1) {
            indexSeleccionat = indexosVisibles.get(fila);
            dispose();
        }
    }//GEN-LAST:event_jButtonAcceptarActionPerformed

    private void jButtonCancellarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancellarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancellarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcceptar;
    private javax.swing.JButton jButtonCancellar;
    private javax.swing.JLabel jLabelCerca;
    private javax.swing.JList<String> jListElements;
    private javax.swing.JScrollPane jScrollPaneElements;
    private javax.swing.JTextField jTextFieldCerca;
    // End of variables declaration//GEN-END:variables
}
