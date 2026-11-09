package cat.paucasesnoves.lloguerjocs.interficie;

import cat.paucasesnoves.lloguerjocs.dto.Joc;
import cat.paucasesnoves.lloguerjocs.interficie.models.ModelTaulaJocs;
import cat.paucasesnoves.lloguerjocs.logica.ExcepcioLloguer;
import cat.paucasesnoves.lloguerjocs.logica.LogicaNegoci;
import java.awt.Color;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DialegEsborrarJoc extends javax.swing.JDialog {

    private ResourceBundle textos = ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
    private ModelTaulaJocs model;

    public DialegEsborrarJoc(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTableJocs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableJocs.getTableHeader().setReorderingAllowed(false);
        jTableJocs.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                actualitzarEstat();
            }
        });
        refrescarTaula();
        setLocationRelativeTo(parent);
    }

    private void refrescarTaula() {
        model = new ModelTaulaJocs(LogicaNegoci.getJocs());
        jTableJocs.setModel(model);
        actualitzarEstat();
    }

    private Joc getJocSeleccionat() {
        int fila = jTableJocs.getSelectedRow();
        if (fila == -1) {
            return null;
        }
        return model.getJoc(fila);
    }

    private void actualitzarEstat() {
        Joc joc = getJocSeleccionat();
        jButtonEsborrar.setEnabled(joc != null);
        if (joc == null) {
            jLabelEstat.setText(textos.getString("DialegEsborrarJoc.jLabelEstat.text"));
            jLabelEstat.setForeground(Color.GRAY);
        } else if (LogicaNegoci.comptarLloguersActius(joc) > 0) {
            jLabelEstat.setText(MessageFormat.format(textos.getString("DialegEsborrarJoc.noEsborrable"), LogicaNegoci.comptarLloguersActius(joc)));
            jLabelEstat.setForeground(new Color(180, 40, 40));
        } else {
            jLabelEstat.setText(textos.getString("DialegEsborrarJoc.esborrable"));
            jLabelEstat.setForeground(new Color(40, 120, 60));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelInstruccions = new javax.swing.JLabel();
        jScrollPaneJocs = new javax.swing.JScrollPane();
        jTableJocs = new javax.swing.JTable();
        jLabelEstat = new javax.swing.JLabel();
        jButtonEsborrar = new javax.swing.JButton();
        jButtonTancar = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(bundle.getString("DialegEsborrarJoc.title"));

        jLabelInstruccions.setText(bundle.getString("DialegEsborrarJoc.jLabelInstruccions.text"));

        jScrollPaneJocs.setViewportView(jTableJocs);

        jLabelEstat.setForeground(new java.awt.Color(102, 102, 102));
        jLabelEstat.setText(bundle.getString("DialegEsborrarJoc.jLabelEstat.text"));

        jButtonEsborrar.setBackground(new java.awt.Color(200, 86, 86));
        jButtonEsborrar.setEnabled(false);
        jButtonEsborrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEsborrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/esborrar.png")));
        jButtonEsborrar.setText(bundle.getString("DialegEsborrarJoc.jButtonEsborrar.text"));
        jButtonEsborrar.addActionListener(this::jButtonEsborrarActionPerformed);

        jButtonTancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/cancellar.png")));
        jButtonTancar.setText(bundle.getString("DialegEsborrarJoc.jButtonTancar.text"));
        jButtonTancar.addActionListener(this::jButtonTancarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInstruccions)
                    .addComponent(jScrollPaneJocs, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(jLabelEstat)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonEsborrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTancar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelInstruccions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneJocs, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEstat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEsborrar)
                    .addComponent(jButtonTancar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEsborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEsborrarActionPerformed
        Joc joc = getJocSeleccionat();
        if (joc == null) {
            return;
        }
        if (LogicaNegoci.comptarLloguersActius(joc) == 0) {
            int resposta = JOptionPane.showConfirmDialog(this, MessageFormat.format(textos.getString("DialegEsborrarJoc.confirmar"), joc.getTitol()),
                    textos.getString("comu.confirmacio"), JOptionPane.YES_NO_OPTION);
            if (resposta != JOptionPane.YES_OPTION) {
                return;
            }
        }
        try {
            LogicaNegoci.eliminarJoc(joc);
            JOptionPane.showMessageDialog(this, MessageFormat.format(textos.getString("DialegEsborrarJoc.esborrat"), joc.getTitol()),
                    textos.getString("comu.informacio"), JOptionPane.INFORMATION_MESSAGE);
        } catch (ExcepcioLloguer e) {
            JOptionPane.showMessageDialog(this, textos.getString(e.getMessage()), textos.getString("comu.error"), JOptionPane.ERROR_MESSAGE);
        }
        refrescarTaula();
    }//GEN-LAST:event_jButtonEsborrarActionPerformed

    private void jButtonTancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTancarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonTancarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEsborrar;
    private javax.swing.JButton jButtonTancar;
    private javax.swing.JLabel jLabelEstat;
    private javax.swing.JLabel jLabelInstruccions;
    private javax.swing.JScrollPane jScrollPaneJocs;
    private javax.swing.JTable jTableJocs;
    // End of variables declaration//GEN-END:variables
}
