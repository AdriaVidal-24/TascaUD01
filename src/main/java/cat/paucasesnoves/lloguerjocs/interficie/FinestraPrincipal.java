package cat.paucasesnoves.lloguerjocs.interficie;

import cat.paucasesnoves.lloguerjocs.dto.EstatLloguer;
import cat.paucasesnoves.lloguerjocs.dto.Lloguer;
import cat.paucasesnoves.lloguerjocs.interficie.models.ModelTaulaLloguers;
import cat.paucasesnoves.lloguerjocs.interficie.models.RenderitzadorEstat;
import cat.paucasesnoves.lloguerjocs.logica.LogicaNegoci;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

public class FinestraPrincipal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FinestraPrincipal.class.getName());

    private ResourceBundle textos = ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
    private ModelTaulaLloguers modelTaula;

    public FinestraPrincipal() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/app.png")).getImage());
        jTableLloguers.setDefaultRenderer(Object.class, new RenderitzadorEstat());
        jTableLloguers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableLloguers.getTableHeader().setReorderingAllowed(false);
        marcarIdiomaActual();
        refrescarTaula();
    }

    private void refrescarTaula() {
        List<Lloguer> lloguers = LogicaNegoci.getLloguers();
        modelTaula = new ModelTaulaLloguers(lloguers);
        jTableLloguers.setModel(modelTaula);
        jLabelTotal.setText(MessageFormat.format(textos.getString("FinestraPrincipal.total"), lloguers.size()));
        jLabelResum.setText(MessageFormat.format(textos.getString("FinestraPrincipal.resum"),
                LogicaNegoci.comptarLloguers(EstatLloguer.ACTIU),
                LogicaNegoci.comptarLloguers(EstatLloguer.FORA_DE_TERMINI),
                LogicaNegoci.comptarLloguers(EstatLloguer.RETORNAT)));
    }

    private Lloguer getLloguerSeleccionat() {
        int fila = jTableLloguers.getSelectedRow();
        if (fila == -1) {
            return null;
        }
        return modelTaula.getLloguer(fila);
    }

    private void obrirRegistreLloguer() {
        DialegRegistrarLloguer dialeg = new DialegRegistrarLloguer(this, true);
        Lloguer seleccionat = getLloguerSeleccionat();
        if (seleccionat != null) {
            dialeg.preseleccionar(seleccionat.getUsuari(), seleccionat.getJoc());
        }
        dialeg.setVisible(true);
        refrescarTaula();
    }

    private void obrirDevolucio() {
        if (LogicaNegoci.getLloguersPendents().isEmpty()) {
            JOptionPane.showMessageDialog(this, textos.getString("FinestraPrincipal.senseLloguersPendents"),
                    textos.getString("comu.informacio"), JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        DialegTornarLloguer dialeg = new DialegTornarLloguer(this, true);
        Lloguer seleccionat = getLloguerSeleccionat();
        if (seleccionat != null && !seleccionat.isRetornat()) {
            dialeg.preseleccionar(seleccionat);
        }
        dialeg.setVisible(true);
        refrescarTaula();
    }

    private void marcarIdiomaActual() {
        String idioma = Locale.getDefault().getLanguage();
        jRadioButtonMenuItemCatala.setSelected(idioma.equals("ca"));
        jRadioButtonMenuItemCastella.setSelected(idioma.equals("es"));
        jRadioButtonMenuItemAngles.setSelected(idioma.equals("en"));
    }

    private void canviarIdioma(String etiqueta) {
        if (Locale.getDefault().toLanguageTag().equals(etiqueta)) {
            return;
        }
        establirIdioma(Locale.forLanguageTag(etiqueta));
        dispose();
        FinestraPrincipal finestra = new FinestraPrincipal();
        finestra.setVisible(true);
    }

    private static void establirIdioma(Locale idioma) {
        Locale.setDefault(idioma);
        ResourceBundle.clearCache();
        ResourceBundle textos = ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
        UIManager.put("OptionPane.yesButtonText", textos.getString("comu.si"));
        UIManager.put("OptionPane.noButtonText", textos.getString("comu.no"));
        UIManager.put("OptionPane.okButtonText", textos.getString("comu.acceptar"));
        UIManager.put("OptionPane.cancelButtonText", textos.getString("comu.cancellar"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupIdiomes = new javax.swing.ButtonGroup();
        jLabelTitol = new javax.swing.JLabel();
        jButtonRegistrarLloguer = new javax.swing.JButton();
        jButtonRegistrarDevolucio = new javax.swing.JButton();
        jScrollPaneLloguers = new javax.swing.JScrollPane();
        jTableLloguers = new javax.swing.JTable();
        jLabelTotal = new javax.swing.JLabel();
        jLabelResum = new javax.swing.JLabel();
        jMenuBarPrincipal = new javax.swing.JMenuBar();
        jMenuLloguer = new javax.swing.JMenu();
        jMenuItemRegistrarLloguer = new javax.swing.JMenuItem();
        jMenuItemTornarLloguer = new javax.swing.JMenuItem();
        jMenuUsuari = new javax.swing.JMenu();
        jMenuItemCrearUsuari = new javax.swing.JMenuItem();
        jMenuItemEsborrarUsuari = new javax.swing.JMenuItem();
        jMenuJoc = new javax.swing.JMenu();
        jMenuItemCrearJoc = new javax.swing.JMenuItem();
        jMenuItemEsborrarJoc = new javax.swing.JMenuItem();
        jMenuIdioma = new javax.swing.JMenu();
        jRadioButtonMenuItemCatala = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemCastella = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemAngles = new javax.swing.JRadioButtonMenuItem();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(bundle.getString("FinestraPrincipal.title"));

        jLabelTitol.setFont(jLabelTitol.getFont().deriveFont(jLabelTitol.getFont().getStyle() | java.awt.Font.BOLD, jLabelTitol.getFont().getSize()+4));
        jLabelTitol.setText(bundle.getString("FinestraPrincipal.jLabelTitol.text"));

        jButtonRegistrarLloguer.setBackground(new java.awt.Color(86, 150, 86));
        jButtonRegistrarLloguer.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistrarLloguer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/afegir.png")));
        jButtonRegistrarLloguer.setText(bundle.getString("FinestraPrincipal.jButtonRegistrarLloguer.text"));
        jButtonRegistrarLloguer.addActionListener(this::jButtonRegistrarLloguerActionPerformed);

        jButtonRegistrarDevolucio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/retornar.png")));
        jButtonRegistrarDevolucio.setText(bundle.getString("FinestraPrincipal.jButtonRegistrarDevolucio.text"));
        jButtonRegistrarDevolucio.addActionListener(this::jButtonRegistrarDevolucioActionPerformed);

        jScrollPaneLloguers.setViewportView(jTableLloguers);

        jLabelTotal.setText(bundle.getString("FinestraPrincipal.jLabelTotal.text"));

        jLabelResum.setForeground(new java.awt.Color(102, 102, 102));
        jLabelResum.setText(bundle.getString("FinestraPrincipal.jLabelResum.text"));

        jMenuLloguer.setText(bundle.getString("FinestraPrincipal.jMenuLloguer.text"));

        jMenuItemRegistrarLloguer.setText(bundle.getString("FinestraPrincipal.jMenuItemRegistrarLloguer.text"));
        jMenuItemRegistrarLloguer.addActionListener(this::jMenuItemRegistrarLloguerActionPerformed);
        jMenuLloguer.add(jMenuItemRegistrarLloguer);

        jMenuItemTornarLloguer.setText(bundle.getString("FinestraPrincipal.jMenuItemTornarLloguer.text"));
        jMenuItemTornarLloguer.addActionListener(this::jMenuItemTornarLloguerActionPerformed);
        jMenuLloguer.add(jMenuItemTornarLloguer);

        jMenuBarPrincipal.add(jMenuLloguer);

        jMenuUsuari.setText(bundle.getString("FinestraPrincipal.jMenuUsuari.text"));

        jMenuItemCrearUsuari.setText(bundle.getString("FinestraPrincipal.jMenuItemCrearUsuari.text"));
        jMenuItemCrearUsuari.addActionListener(this::jMenuItemCrearUsuariActionPerformed);
        jMenuUsuari.add(jMenuItemCrearUsuari);

        jMenuItemEsborrarUsuari.setText(bundle.getString("FinestraPrincipal.jMenuItemEsborrarUsuari.text"));
        jMenuItemEsborrarUsuari.addActionListener(this::jMenuItemEsborrarUsuariActionPerformed);
        jMenuUsuari.add(jMenuItemEsborrarUsuari);

        jMenuBarPrincipal.add(jMenuUsuari);

        jMenuJoc.setText(bundle.getString("FinestraPrincipal.jMenuJoc.text"));

        jMenuItemCrearJoc.setText(bundle.getString("FinestraPrincipal.jMenuItemCrearJoc.text"));
        jMenuItemCrearJoc.addActionListener(this::jMenuItemCrearJocActionPerformed);
        jMenuJoc.add(jMenuItemCrearJoc);

        jMenuItemEsborrarJoc.setText(bundle.getString("FinestraPrincipal.jMenuItemEsborrarJoc.text"));
        jMenuItemEsborrarJoc.addActionListener(this::jMenuItemEsborrarJocActionPerformed);
        jMenuJoc.add(jMenuItemEsborrarJoc);

        jMenuBarPrincipal.add(jMenuJoc);

        jMenuIdioma.setText(bundle.getString("FinestraPrincipal.jMenuIdioma.text"));

        buttonGroupIdiomes.add(jRadioButtonMenuItemCatala);
        jRadioButtonMenuItemCatala.setText(bundle.getString("FinestraPrincipal.jRadioButtonMenuItemCatala.text"));
        jRadioButtonMenuItemCatala.addActionListener(this::jRadioButtonMenuItemCatalaActionPerformed);
        jMenuIdioma.add(jRadioButtonMenuItemCatala);

        buttonGroupIdiomes.add(jRadioButtonMenuItemCastella);
        jRadioButtonMenuItemCastella.setText(bundle.getString("FinestraPrincipal.jRadioButtonMenuItemCastella.text"));
        jRadioButtonMenuItemCastella.addActionListener(this::jRadioButtonMenuItemCastellaActionPerformed);
        jMenuIdioma.add(jRadioButtonMenuItemCastella);

        buttonGroupIdiomes.add(jRadioButtonMenuItemAngles);
        jRadioButtonMenuItemAngles.setText(bundle.getString("FinestraPrincipal.jRadioButtonMenuItemAngles.text"));
        jRadioButtonMenuItemAngles.addActionListener(this::jRadioButtonMenuItemAnglesActionPerformed);
        jMenuIdioma.add(jRadioButtonMenuItemAngles);

        jMenuBarPrincipal.add(jMenuIdioma);

        setJMenuBar(jMenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitol)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonRegistrarLloguer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRegistrarDevolucio))
                    .addComponent(jScrollPaneLloguers, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTotal)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelResum)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitol)
                    .addComponent(jButtonRegistrarLloguer)
                    .addComponent(jButtonRegistrarDevolucio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneLloguers, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotal)
                    .addComponent(jLabelResum))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemRegistrarLloguerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistrarLloguerActionPerformed
        obrirRegistreLloguer();
    }//GEN-LAST:event_jMenuItemRegistrarLloguerActionPerformed

    private void jMenuItemTornarLloguerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTornarLloguerActionPerformed
        obrirDevolucio();
    }//GEN-LAST:event_jMenuItemTornarLloguerActionPerformed

    private void jMenuItemCrearUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearUsuariActionPerformed
        DialegCrearUsuari dialeg = new DialegCrearUsuari(this, true);
        dialeg.setVisible(true);
        refrescarTaula();
    }//GEN-LAST:event_jMenuItemCrearUsuariActionPerformed

    private void jMenuItemEsborrarUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEsborrarUsuariActionPerformed
        DialegEsborrarUsuari dialeg = new DialegEsborrarUsuari(this, true);
        dialeg.setVisible(true);
        refrescarTaula();
    }//GEN-LAST:event_jMenuItemEsborrarUsuariActionPerformed

    private void jMenuItemCrearJocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearJocActionPerformed
        DialegCrearJoc dialeg = new DialegCrearJoc(this, true);
        dialeg.setVisible(true);
        refrescarTaula();
    }//GEN-LAST:event_jMenuItemCrearJocActionPerformed

    private void jMenuItemEsborrarJocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEsborrarJocActionPerformed
        DialegEsborrarJoc dialeg = new DialegEsborrarJoc(this, true);
        dialeg.setVisible(true);
        refrescarTaula();
    }//GEN-LAST:event_jMenuItemEsborrarJocActionPerformed

    private void jRadioButtonMenuItemCatalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemCatalaActionPerformed
        canviarIdioma("ca-ES");
    }//GEN-LAST:event_jRadioButtonMenuItemCatalaActionPerformed

    private void jRadioButtonMenuItemCastellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemCastellaActionPerformed
        canviarIdioma("es-ES");
    }//GEN-LAST:event_jRadioButtonMenuItemCastellaActionPerformed

    private void jRadioButtonMenuItemAnglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemAnglesActionPerformed
        canviarIdioma("en-GB");
    }//GEN-LAST:event_jRadioButtonMenuItemAnglesActionPerformed

    private void jButtonRegistrarLloguerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarLloguerActionPerformed
        obrirRegistreLloguer();
    }//GEN-LAST:event_jButtonRegistrarLloguerActionPerformed

    private void jButtonRegistrarDevolucioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarDevolucioActionPerformed
        obrirDevolucio();
    }//GEN-LAST:event_jButtonRegistrarDevolucioActionPerformed

    public static void main(String args[]) {
        establirIdioma(Locale.forLanguageTag("ca-ES"));
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new FinestraPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupIdiomes;
    private javax.swing.JButton jButtonRegistrarDevolucio;
    private javax.swing.JButton jButtonRegistrarLloguer;
    private javax.swing.JLabel jLabelResum;
    private javax.swing.JLabel jLabelTitol;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenu jMenuIdioma;
    private javax.swing.JMenuItem jMenuItemCrearJoc;
    private javax.swing.JMenuItem jMenuItemCrearUsuari;
    private javax.swing.JMenuItem jMenuItemEsborrarJoc;
    private javax.swing.JMenuItem jMenuItemEsborrarUsuari;
    private javax.swing.JMenuItem jMenuItemRegistrarLloguer;
    private javax.swing.JMenuItem jMenuItemTornarLloguer;
    private javax.swing.JMenu jMenuJoc;
    private javax.swing.JMenu jMenuLloguer;
    private javax.swing.JMenu jMenuUsuari;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemAngles;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemCastella;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemCatala;
    private javax.swing.JScrollPane jScrollPaneLloguers;
    private javax.swing.JTable jTableLloguers;
    // End of variables declaration//GEN-END:variables
}
