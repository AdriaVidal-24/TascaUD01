package cat.paucasesnoves.lloguerjocs.interficie;


public class FinestraPrincipal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FinestraPrincipal.class.getName());

    public FinestraPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitol = new javax.swing.JLabel();
        jScrollPaneLloguers = new javax.swing.JScrollPane();
        jTableLloguers = new javax.swing.JTable();
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
                    .addComponent(jScrollPaneLloguers, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneLloguers, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabelTitol;
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
