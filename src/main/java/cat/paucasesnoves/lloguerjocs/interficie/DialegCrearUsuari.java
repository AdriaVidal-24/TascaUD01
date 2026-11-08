package cat.paucasesnoves.lloguerjocs.interficie;

import cat.paucasesnoves.lloguerjocs.dto.Usuari;
import cat.paucasesnoves.lloguerjocs.logica.ExcepcioLloguer;
import cat.paucasesnoves.lloguerjocs.logica.LogicaNegoci;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class DialegCrearUsuari extends javax.swing.JDialog {

    private ResourceBundle textos = ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date dataRegistre = new Date();

    public DialegCrearUsuari(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTextFieldDataRegistre.setText(sdf.format(dataRegistre));

        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNom = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jLabelLlinatge1 = new javax.swing.JLabel();
        jTextFieldLlinatge1 = new javax.swing.JTextField();
        jLabelLlinatge2 = new javax.swing.JLabel();
        jTextFieldLlinatge2 = new javax.swing.JTextField();
        jLabelDni = new javax.swing.JLabel();
        jTextFieldDni = new javax.swing.JTextField();
        jLabelTelefon = new javax.swing.JLabel();
        jTextFieldTelefon = new javax.swing.JTextField();
        jLabelDataRegistre = new javax.swing.JLabel();
        jTextFieldDataRegistre = new javax.swing.JTextField();
        jLabelObligatoris = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancellar = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle(bundle.getString("DialegCrearUsuari.title"));

        jLabelNom.setText(bundle.getString("DialegCrearUsuari.jLabelNom.text"));

        jTextFieldNom.setName(bundle.getString("DialegCrearUsuari.jTextFieldNom.name"));

        jLabelLlinatge1.setText(bundle.getString("DialegCrearUsuari.jLabelLlinatge1.text"));

        jTextFieldLlinatge1.setName(bundle.getString("DialegCrearUsuari.jTextFieldLlinatge1.name"));

        jLabelLlinatge2.setText(bundle.getString("DialegCrearUsuari.jLabelLlinatge2.text"));

        jTextFieldLlinatge2.setName(bundle.getString("DialegCrearUsuari.jTextFieldLlinatge2.name"));

        jLabelDni.setText(bundle.getString("DialegCrearUsuari.jLabelDni.text"));

        jTextFieldDni.setName(bundle.getString("DialegCrearUsuari.jTextFieldDni.name"));

        jLabelTelefon.setText(bundle.getString("DialegCrearUsuari.jLabelTelefon.text"));

        jTextFieldTelefon.setName(bundle.getString("DialegCrearUsuari.jTextFieldTelefon.name"));

        jLabelDataRegistre.setText(bundle.getString("DialegCrearUsuari.jLabelDataRegistre.text"));

        jTextFieldDataRegistre.setEditable(false);
        jTextFieldDataRegistre.setEnabled(false);

        jLabelObligatoris.setForeground(new java.awt.Color(102, 102, 102));
        jLabelObligatoris.setText(bundle.getString("DialegCrearUsuari.jLabelObligatoris.text"));

        jButtonConfirmar.setBackground(new java.awt.Color(86, 150, 86));
        jButtonConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/confirmar.png")));
        jButtonConfirmar.setText(bundle.getString("DialegCrearUsuari.jButtonConfirmar.text"));
        jButtonConfirmar.addActionListener(this::jButtonConfirmarActionPerformed);

        jButtonCancellar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/cancellar.png")));
        jButtonCancellar.setText(bundle.getString("DialegCrearUsuari.jButtonCancellar.text"));
        jButtonCancellar.addActionListener(this::jButtonCancellarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNom)
                            .addComponent(jLabelLlinatge1)
                            .addComponent(jLabelLlinatge2)
                            .addComponent(jLabelDni)
                            .addComponent(jLabelTelefon)
                            .addComponent(jLabelDataRegistre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNom, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jTextFieldLlinatge1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jTextFieldLlinatge2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jTextFieldDni, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jTextFieldTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(jTextFieldDataRegistre, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                    .addComponent(jLabelObligatoris)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancellar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNom)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLlinatge1)
                    .addComponent(jTextFieldLlinatge1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLlinatge2)
                    .addComponent(jTextFieldLlinatge2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDni)
                    .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefon)
                    .addComponent(jTextFieldTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataRegistre)
                    .addComponent(jTextFieldDataRegistre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelObligatoris)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancellar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        Usuari usuari = new Usuari(jTextFieldNom.getText().trim(), jTextFieldLlinatge1.getText().trim(),
                jTextFieldLlinatge2.getText().trim(), jTextFieldDni.getText().trim().toUpperCase(),
                jTextFieldTelefon.getText().trim(), dataRegistre);
        try {
            LogicaNegoci.afegirUsuari(usuari);
            JOptionPane.showMessageDialog(this, MessageFormat.format(textos.getString("DialegCrearUsuari.creat"), usuari.getNomComplet()),
                    textos.getString("comu.informacio"), JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (ExcepcioLloguer e) {
            JOptionPane.showMessageDialog(this, textos.getString(e.getMessage()), textos.getString("comu.error"), JOptionPane.ERROR_MESSAGE);
            jTextFieldDni.requestFocus();
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonCancellarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancellarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancellarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancellar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabelDataRegistre;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelLlinatge1;
    private javax.swing.JLabel jLabelLlinatge2;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelObligatoris;
    private javax.swing.JLabel jLabelTelefon;
    private javax.swing.JTextField jTextFieldDataRegistre;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldLlinatge1;
    private javax.swing.JTextField jTextFieldLlinatge2;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldTelefon;
    // End of variables declaration//GEN-END:variables
}
