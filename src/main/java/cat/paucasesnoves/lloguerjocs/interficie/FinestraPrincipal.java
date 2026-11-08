package cat.paucasesnoves.lloguerjocs.interficie;

import cat.paucasesnoves.lloguerjocs.dto.EstatLloguer;
import cat.paucasesnoves.lloguerjocs.dto.Lloguer;
import cat.paucasesnoves.lloguerjocs.interficie.models.ModelTaulaLloguers;
import cat.paucasesnoves.lloguerjocs.interficie.models.RenderitzadorEstat;
import cat.paucasesnoves.lloguerjocs.logica.LogicaNegoci;
import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;

public class FinestraPrincipal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FinestraPrincipal.class.getName());

    private ResourceBundle textos = ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
    private ModelTaulaLloguers modelTaula;

    public FinestraPrincipal() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/app.png")).getImage());
        jTableLloguers.setDefaultRenderer(Object.class, new RenderitzadorEstat());
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitol = new javax.swing.JLabel();
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

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(bundle.getString("FinestraPrincipal.title"));

        jLabelTitol.setFont(jLabelTitol.getFont().deriveFont(jLabelTitol.getFont().getStyle() | java.awt.Font.BOLD, jLabelTitol.getFont().getSize()+4));
        jLabelTitol.setText(bundle.getString("FinestraPrincipal.jLabelTitol.text"));

        jScrollPaneLloguers.setViewportView(jTableLloguers);

        jLabelTotal.setText(bundle.getString("FinestraPrincipal.jLabelTotal.text"));

        jLabelResum.setForeground(new java.awt.Color(102, 102, 102));
        jLabelResum.setText(bundle.getString("FinestraPrincipal.jLabelResum.text"));

        jMenuLloguer.setText(bundle.getString("FinestraPrincipal.jMenuLloguer.text"));

        jMenuItemRegistrarLloguer.setText(bundle.getString("FinestraPrincipal.jMenuItemRegistrarLloguer.text"));
        jMenuLloguer.add(jMenuItemRegistrarLloguer);

        jMenuItemTornarLloguer.setText(bundle.getString("FinestraPrincipal.jMenuItemTornarLloguer.text"));
        jMenuLloguer.add(jMenuItemTornarLloguer);

        jMenuBarPrincipal.add(jMenuLloguer);

        jMenuUsuari.setText(bundle.getString("FinestraPrincipal.jMenuUsuari.text"));

        jMenuItemCrearUsuari.setText(bundle.getString("FinestraPrincipal.jMenuItemCrearUsuari.text"));
        jMenuUsuari.add(jMenuItemCrearUsuari);

        jMenuItemEsborrarUsuari.setText(bundle.getString("FinestraPrincipal.jMenuItemEsborrarUsuari.text"));
        jMenuUsuari.add(jMenuItemEsborrarUsuari);

        jMenuBarPrincipal.add(jMenuUsuari);

        jMenuJoc.setText(bundle.getString("FinestraPrincipal.jMenuJoc.text"));

        jMenuItemCrearJoc.setText(bundle.getString("FinestraPrincipal.jMenuItemCrearJoc.text"));
        jMenuJoc.add(jMenuItemCrearJoc);

        jMenuItemEsborrarJoc.setText(bundle.getString("FinestraPrincipal.jMenuItemEsborrarJoc.text"));
        jMenuJoc.add(jMenuItemEsborrarJoc);

        jMenuBarPrincipal.add(jMenuJoc);

        setJMenuBar(jMenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitol)
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
                .addComponent(jLabelTitol)
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

    public static void main(String args[]) {
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
    private javax.swing.JLabel jLabelResum;
    private javax.swing.JLabel jLabelTitol;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenuItem jMenuItemCrearJoc;
    private javax.swing.JMenuItem jMenuItemCrearUsuari;
    private javax.swing.JMenuItem jMenuItemEsborrarJoc;
    private javax.swing.JMenuItem jMenuItemEsborrarUsuari;
    private javax.swing.JMenuItem jMenuItemRegistrarLloguer;
    private javax.swing.JMenuItem jMenuItemTornarLloguer;
    private javax.swing.JMenu jMenuJoc;
    private javax.swing.JMenu jMenuLloguer;
    private javax.swing.JMenu jMenuUsuari;
    private javax.swing.JScrollPane jScrollPaneLloguers;
    private javax.swing.JTable jTableLloguers;
    // End of variables declaration//GEN-END:variables
}
