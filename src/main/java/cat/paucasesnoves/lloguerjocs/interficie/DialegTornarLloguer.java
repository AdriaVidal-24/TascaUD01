package cat.paucasesnoves.lloguerjocs.interficie;

import cat.paucasesnoves.lloguerjocs.dto.EstatLloguer;
import cat.paucasesnoves.lloguerjocs.dto.Lloguer;
import cat.paucasesnoves.lloguerjocs.interficie.models.ModelTaulaLloguers;
import cat.paucasesnoves.lloguerjocs.interficie.models.RenderitzadorEstat;
import cat.paucasesnoves.lloguerjocs.logica.ExcepcioLloguer;
import cat.paucasesnoves.lloguerjocs.logica.LogicaNegoci;
import java.awt.Color;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DialegTornarLloguer extends javax.swing.JDialog {

    private ResourceBundle textos = ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private ModelTaulaLloguers model;

    public DialegTornarLloguer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTableLloguers.setDefaultRenderer(Object.class, new RenderitzadorEstat());
        jTableLloguers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableLloguers.getTableHeader().setReorderingAllowed(false);
        jTableLloguers.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                mostrarDetall();
            }
        });
        carregarLloguers();
        setLocationRelativeTo(parent);
    }

    public void preseleccionar(Lloguer lloguer) {
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getLloguer(i) == lloguer) {
                jTableLloguers.setRowSelectionInterval(i, i);
            }
        }
    }

    private void carregarLloguers() {
        List<Lloguer> pendents = LogicaNegoci.getLloguersPendents();
        model = new ModelTaulaLloguers(pendents);
        jTableLloguers.setModel(model);
        if (pendents.isEmpty()) {
            jLabelInstruccions.setText(textos.getString("DialegTornarLloguer.senseLloguers"));
        } else {
            jTableLloguers.setRowSelectionInterval(0, 0);
        }
        mostrarDetall();
    }

    private Lloguer getLloguerSeleccionat() {
        int fila = jTableLloguers.getSelectedRow();
        if (fila == -1) {
            return null;
        }
        return model.getLloguer(fila);
    }

    private void mostrarDetall() {
        Lloguer lloguer = getLloguerSeleccionat();
        if (lloguer == null) {
            jLabelValorJoc.setText("-");
            jLabelValorUsuari.setText("-");
            jLabelValorPlataforma.setText("-");
            jLabelValorDataInici.setText("-");
            jLabelValorDataPrevista.setText("-");
            jLabelValorEstat.setText("-");
            jButtonMarcarRetornat.setEnabled(false);
            return;
        }
        jLabelValorJoc.setText(lloguer.getJoc().getTitol());
        jLabelValorUsuari.setText(lloguer.getUsuari().getNomComplet());
        jLabelValorPlataforma.setText(lloguer.getPlataforma().getNom());
        jLabelValorDataInici.setText(sdf.format(lloguer.getDataInici()));
        jLabelValorDataPrevista.setText(sdf.format(lloguer.getDataPrevista()));
        jLabelValorEstat.setText(textos.getString(lloguer.getEstat().getClau()));
        if (lloguer.getEstat() == EstatLloguer.FORA_DE_TERMINI) {
            jLabelValorEstat.setForeground(new Color(180, 40, 40));
        } else {
            jLabelValorEstat.setForeground(jLabelValorJoc.getForeground());
        }
        jButtonMarcarRetornat.setEnabled(!lloguer.isRetornat());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelInstruccions = new javax.swing.JLabel();
        jScrollPaneLloguers = new javax.swing.JScrollPane();
        jTableLloguers = new javax.swing.JTable();
        jPanelDetall = new javax.swing.JPanel();
        jLabelJoc = new javax.swing.JLabel();
        jLabelValorJoc = new javax.swing.JLabel();
        jLabelUsuari = new javax.swing.JLabel();
        jLabelValorUsuari = new javax.swing.JLabel();
        jLabelPlataforma = new javax.swing.JLabel();
        jLabelValorPlataforma = new javax.swing.JLabel();
        jLabelDataInici = new javax.swing.JLabel();
        jLabelValorDataInici = new javax.swing.JLabel();
        jLabelDataPrevista = new javax.swing.JLabel();
        jLabelValorDataPrevista = new javax.swing.JLabel();
        jLabelEstat = new javax.swing.JLabel();
        jLabelValorEstat = new javax.swing.JLabel();
        jButtonMarcarRetornat = new javax.swing.JButton();
        jButtonTancar = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(bundle.getString("DialegTornarLloguer.title"));

        jLabelInstruccions.setText(bundle.getString("DialegTornarLloguer.jLabelInstruccions.text"));

        jScrollPaneLloguers.setViewportView(jTableLloguers);

        jPanelDetall.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("DialegTornarLloguer.jPanelDetall.border.title")));

        jLabelJoc.setText(bundle.getString("DialegTornarLloguer.jLabelJoc.text"));

        jLabelValorJoc.setFont(jLabelValorJoc.getFont().deriveFont(jLabelValorJoc.getFont().getStyle() | java.awt.Font.BOLD));
        jLabelValorJoc.setText(bundle.getString("DialegTornarLloguer.jLabelValorJoc.text"));

        jLabelUsuari.setText(bundle.getString("DialegTornarLloguer.jLabelUsuari.text"));

        jLabelValorUsuari.setFont(jLabelValorUsuari.getFont().deriveFont(jLabelValorUsuari.getFont().getStyle() | java.awt.Font.BOLD));
        jLabelValorUsuari.setText(bundle.getString("DialegTornarLloguer.jLabelValorUsuari.text"));

        jLabelPlataforma.setText(bundle.getString("DialegTornarLloguer.jLabelPlataforma.text"));

        jLabelValorPlataforma.setFont(jLabelValorPlataforma.getFont().deriveFont(jLabelValorPlataforma.getFont().getStyle() | java.awt.Font.BOLD));
        jLabelValorPlataforma.setText(bundle.getString("DialegTornarLloguer.jLabelValorPlataforma.text"));

        jLabelDataInici.setText(bundle.getString("DialegTornarLloguer.jLabelDataInici.text"));

        jLabelValorDataInici.setFont(jLabelValorDataInici.getFont().deriveFont(jLabelValorDataInici.getFont().getStyle() | java.awt.Font.BOLD));
        jLabelValorDataInici.setText(bundle.getString("DialegTornarLloguer.jLabelValorDataInici.text"));

        jLabelDataPrevista.setText(bundle.getString("DialegTornarLloguer.jLabelDataPrevista.text"));

        jLabelValorDataPrevista.setFont(jLabelValorDataPrevista.getFont().deriveFont(jLabelValorDataPrevista.getFont().getStyle() | java.awt.Font.BOLD));
        jLabelValorDataPrevista.setText(bundle.getString("DialegTornarLloguer.jLabelValorDataPrevista.text"));

        jLabelEstat.setText(bundle.getString("DialegTornarLloguer.jLabelEstat.text"));

        jLabelValorEstat.setFont(jLabelValorEstat.getFont().deriveFont(jLabelValorEstat.getFont().getStyle() | java.awt.Font.BOLD));
        jLabelValorEstat.setText(bundle.getString("DialegTornarLloguer.jLabelValorEstat.text"));

        javax.swing.GroupLayout jPanelDetallLayout = new javax.swing.GroupLayout(jPanelDetall);
        jPanelDetall.setLayout(jPanelDetallLayout);
        jPanelDetallLayout.setHorizontalGroup(
            jPanelDetallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetallLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDetallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDetallLayout.createSequentialGroup()
                        .addGroup(jPanelDetallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelJoc)
                            .addComponent(jLabelUsuari)
                            .addComponent(jLabelPlataforma)
                            .addComponent(jLabelDataInici)
                            .addComponent(jLabelDataPrevista)
                            .addComponent(jLabelEstat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDetallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelValorJoc)
                            .addComponent(jLabelValorUsuari)
                            .addComponent(jLabelValorPlataforma)
                            .addComponent(jLabelValorDataInici)
                            .addComponent(jLabelValorDataPrevista)
                            .addComponent(jLabelValorEstat))))
                .addContainerGap())
        );
        jPanelDetallLayout.setVerticalGroup(
            jPanelDetallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDetallLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDetallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelJoc)
                    .addComponent(jLabelValorJoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuari)
                    .addComponent(jLabelValorUsuari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlataforma)
                    .addComponent(jLabelValorPlataforma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataInici)
                    .addComponent(jLabelValorDataInici))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataPrevista)
                    .addComponent(jLabelValorDataPrevista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDetallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstat)
                    .addComponent(jLabelValorEstat))
                .addContainerGap())
        );

        jButtonMarcarRetornat.setBackground(new java.awt.Color(86, 150, 86));
        jButtonMarcarRetornat.setEnabled(false);
        jButtonMarcarRetornat.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMarcarRetornat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/retornar_blanc.png")));
        jButtonMarcarRetornat.setText(bundle.getString("DialegTornarLloguer.jButtonMarcarRetornat.text"));
        jButtonMarcarRetornat.addActionListener(this::jButtonMarcarRetornatActionPerformed);

        jButtonTancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/cancellar.png")));
        jButtonTancar.setText(bundle.getString("DialegTornarLloguer.jButtonTancar.text"));
        jButtonTancar.addActionListener(this::jButtonTancarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelInstruccions)
                    .addComponent(jScrollPaneLloguers, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jPanelDetall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonMarcarRetornat)
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
                .addComponent(jScrollPaneLloguers, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDetall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMarcarRetornat)
                    .addComponent(jButtonTancar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMarcarRetornatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarcarRetornatActionPerformed
        Lloguer lloguer = getLloguerSeleccionat();
        if (lloguer == null) {
            return;
        }
        String descripcio = MessageFormat.format(textos.getString("DialegTornarLloguer.descripcio"), lloguer.getNumeroFormatat(),
                lloguer.getJoc().getTitol(), lloguer.getPlataforma().getNom(), lloguer.getUsuari().toString());
        int resposta = JOptionPane.showConfirmDialog(this, MessageFormat.format(textos.getString("DialegTornarLloguer.confirmar"), descripcio),
                textos.getString("comu.confirmacio"), JOptionPane.YES_NO_OPTION);
        if (resposta != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            LogicaNegoci.registrarDevolucio(lloguer);
            JOptionPane.showMessageDialog(this, MessageFormat.format(textos.getString("DialegTornarLloguer.retornat"), descripcio),
                    textos.getString("comu.informacio"), JOptionPane.INFORMATION_MESSAGE);
        } catch (ExcepcioLloguer e) {
            JOptionPane.showMessageDialog(this, textos.getString(e.getMessage()), textos.getString("comu.error"), JOptionPane.ERROR_MESSAGE);
        }
        carregarLloguers();
    }//GEN-LAST:event_jButtonMarcarRetornatActionPerformed

    private void jButtonTancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTancarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonTancarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMarcarRetornat;
    private javax.swing.JButton jButtonTancar;
    private javax.swing.JLabel jLabelDataInici;
    private javax.swing.JLabel jLabelDataPrevista;
    private javax.swing.JLabel jLabelEstat;
    private javax.swing.JLabel jLabelInstruccions;
    private javax.swing.JLabel jLabelJoc;
    private javax.swing.JLabel jLabelPlataforma;
    private javax.swing.JLabel jLabelUsuari;
    private javax.swing.JLabel jLabelValorDataInici;
    private javax.swing.JLabel jLabelValorDataPrevista;
    private javax.swing.JLabel jLabelValorEstat;
    private javax.swing.JLabel jLabelValorJoc;
    private javax.swing.JLabel jLabelValorPlataforma;
    private javax.swing.JLabel jLabelValorUsuari;
    private javax.swing.JPanel jPanelDetall;
    private javax.swing.JScrollPane jScrollPaneLloguers;
    private javax.swing.JTable jTableLloguers;
    // End of variables declaration//GEN-END:variables
}
