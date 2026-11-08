package cat.paucasesnoves.lloguerjocs.interficie;

import cat.paucasesnoves.lloguerjocs.dto.Genere;
import cat.paucasesnoves.lloguerjocs.dto.Joc;
import cat.paucasesnoves.lloguerjocs.dto.Plataforma;
import cat.paucasesnoves.lloguerjocs.logica.ExcepcioLloguer;
import cat.paucasesnoves.lloguerjocs.logica.LogicaNegoci;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.builtin.stringvalidation.ValidacioMajuscula;
import org.netbeans.validation.api.ui.ValidationGroup;

public class DialegCrearJoc extends javax.swing.JDialog {

    private ResourceBundle textos = ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
    private Plataforma[] plataformes = Plataforma.values();
    private Genere[] generes = Genere.values();
    private JCheckBox[] caselles;
    private JSpinner[] spinners;

    public DialegCrearJoc(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        caselles = new JCheckBox[]{jCheckBoxPs5, jCheckBoxSwitch2, jCheckBoxXbox, jCheckBoxPc};
        spinners = new JSpinner[]{jSpinnerPs5, jSpinnerSwitch2, jSpinnerXbox, jSpinnerPc};
        for (Genere genere : generes) {
            jComboBoxGenere.addItem(textos.getString(genere.getClau()));
        }

        ValidationGroup group = validationPanel.getValidationGroup();
        group.add(jTextFieldNom, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(jTextFieldNom, new ValidacioMajuscula());

        validationPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanel.getProblem() == null) {
                    jButtonConfirmar.setEnabled(true);
                } else {
                    jButtonConfirmar.setEnabled(false);
                }
            }
        });
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        validationPanel = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jLabelNom = new javax.swing.JLabel();
        jLabelGenere = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jComboBoxGenere = new javax.swing.JComboBox<>();
        jPanelPlataformes = new javax.swing.JPanel();
        jCheckBoxPs5 = new javax.swing.JCheckBox();
        jLabelUnitatsPs5 = new javax.swing.JLabel();
        jSpinnerPs5 = new javax.swing.JSpinner();
        jCheckBoxSwitch2 = new javax.swing.JCheckBox();
        jLabelUnitatsSwitch2 = new javax.swing.JLabel();
        jSpinnerSwitch2 = new javax.swing.JSpinner();
        jCheckBoxXbox = new javax.swing.JCheckBox();
        jLabelUnitatsXbox = new javax.swing.JLabel();
        jSpinnerXbox = new javax.swing.JSpinner();
        jCheckBoxPc = new javax.swing.JCheckBox();
        jLabelUnitatsPc = new javax.swing.JLabel();
        jSpinnerPc = new javax.swing.JSpinner();
        jLabelObligatoris = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancellar = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle(bundle.getString("DialegCrearJoc.title"));

        jLabelNom.setText(bundle.getString("DialegCrearJoc.jLabelNom.text"));

        jLabelGenere.setText(bundle.getString("DialegCrearJoc.jLabelGenere.text"));

        jTextFieldNom.setName(bundle.getString("DialegCrearJoc.jTextFieldNom.name"));

        jPanelPlataformes.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("DialegCrearJoc.jPanelPlataformes.border.title")));

        jCheckBoxPs5.setText(bundle.getString("DialegCrearJoc.jCheckBoxPs5.text"));

        jLabelUnitatsPs5.setText(bundle.getString("DialegCrearJoc.jLabelUnitatsPs5.text"));

        jSpinnerPs5.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

        jCheckBoxSwitch2.setText(bundle.getString("DialegCrearJoc.jCheckBoxSwitch2.text"));

        jLabelUnitatsSwitch2.setText(bundle.getString("DialegCrearJoc.jLabelUnitatsSwitch2.text"));

        jSpinnerSwitch2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

        jCheckBoxXbox.setText(bundle.getString("DialegCrearJoc.jCheckBoxXbox.text"));

        jLabelUnitatsXbox.setText(bundle.getString("DialegCrearJoc.jLabelUnitatsXbox.text"));

        jSpinnerXbox.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

        jCheckBoxPc.setText(bundle.getString("DialegCrearJoc.jCheckBoxPc.text"));

        jLabelUnitatsPc.setText(bundle.getString("DialegCrearJoc.jLabelUnitatsPc.text"));

        jSpinnerPc.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

        javax.swing.GroupLayout jPanelPlataformesLayout = new javax.swing.GroupLayout(jPanelPlataformes);
        jPanelPlataformes.setLayout(jPanelPlataformesLayout);
        jPanelPlataformesLayout.setHorizontalGroup(
            jPanelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlataformesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPlataformesLayout.createSequentialGroup()
                        .addGroup(jPanelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxPs5)
                            .addComponent(jCheckBoxSwitch2)
                            .addComponent(jCheckBoxXbox)
                            .addComponent(jCheckBoxPc))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUnitatsPs5)
                            .addComponent(jLabelUnitatsSwitch2)
                            .addComponent(jLabelUnitatsXbox)
                            .addComponent(jLabelUnitatsPc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerPs5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerSwitch2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerXbox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerPc, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanelPlataformesLayout.setVerticalGroup(
            jPanelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlataformesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxPs5)
                    .addComponent(jLabelUnitatsPs5)
                    .addComponent(jSpinnerPs5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxSwitch2)
                    .addComponent(jLabelUnitatsSwitch2)
                    .addComponent(jSpinnerSwitch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxXbox)
                    .addComponent(jLabelUnitatsXbox)
                    .addComponent(jSpinnerXbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPlataformesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxPc)
                    .addComponent(jLabelUnitatsPc)
                    .addComponent(jSpinnerPc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabelObligatoris.setForeground(new java.awt.Color(102, 102, 102));
        jLabelObligatoris.setText(bundle.getString("DialegCrearJoc.jLabelObligatoris.text"));

        jButtonConfirmar.setBackground(new java.awt.Color(86, 150, 86));
        jButtonConfirmar.setEnabled(false);
        jButtonConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/confirmar.png")));
        jButtonConfirmar.setText(bundle.getString("DialegCrearJoc.jButtonConfirmar.text"));
        jButtonConfirmar.addActionListener(this::jButtonConfirmarActionPerformed);

        jButtonCancellar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/cancellar.png")));
        jButtonCancellar.setText(bundle.getString("DialegCrearJoc.jButtonCancellar.text"));
        jButtonCancellar.addActionListener(this::jButtonCancellarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(validationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNom)
                            .addComponent(jTextFieldNom, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelGenere)
                            .addComponent(jComboBoxGenere, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addComponent(jPanelPlataformes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(validationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNom)
                    .addComponent(jLabelGenere))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxGenere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelPlataformes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        if (validationPanel.getProblem() != null) {
            return;
        }
        Joc joc = new Joc(jTextFieldNom.getText().trim(), generes[jComboBoxGenere.getSelectedIndex()]);
        for (int i = 0; i < caselles.length; i++) {
            if (caselles[i].isSelected()) {
                joc.afegirUnitats(plataformes[i], (Integer) spinners[i].getValue());
            }
        }
        if (!joc.teAlgunaPlataforma()) {
            JOptionPane.showMessageDialog(this, textos.getString("error.joc.sensePlataformes"), textos.getString("comu.error"), JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            LogicaNegoci.afegirJoc(joc);
            JOptionPane.showMessageDialog(this, MessageFormat.format(textos.getString("DialegCrearJoc.creat"), joc.getTitol()),
                    textos.getString("comu.informacio"), JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (ExcepcioLloguer e) {
            JOptionPane.showMessageDialog(this, textos.getString(e.getMessage()), textos.getString("comu.error"), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonCancellarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancellarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancellarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancellar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JCheckBox jCheckBoxPc;
    private javax.swing.JCheckBox jCheckBoxPs5;
    private javax.swing.JCheckBox jCheckBoxSwitch2;
    private javax.swing.JCheckBox jCheckBoxXbox;
    private javax.swing.JComboBox<String> jComboBoxGenere;
    private javax.swing.JLabel jLabelGenere;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelObligatoris;
    private javax.swing.JLabel jLabelUnitatsPc;
    private javax.swing.JLabel jLabelUnitatsPs5;
    private javax.swing.JLabel jLabelUnitatsSwitch2;
    private javax.swing.JLabel jLabelUnitatsXbox;
    private javax.swing.JPanel jPanelPlataformes;
    private javax.swing.JSpinner jSpinnerPc;
    private javax.swing.JSpinner jSpinnerPs5;
    private javax.swing.JSpinner jSpinnerSwitch2;
    private javax.swing.JSpinner jSpinnerXbox;
    private javax.swing.JTextField jTextFieldNom;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanel;
    // End of variables declaration//GEN-END:variables
}
