package cat.paucasesnoves.lloguerjocs.interficie;

import cat.paucasesnoves.lloguerjocs.dto.Joc;
import cat.paucasesnoves.lloguerjocs.dto.Lloguer;
import cat.paucasesnoves.lloguerjocs.dto.Plataforma;
import cat.paucasesnoves.lloguerjocs.dto.Usuari;
import cat.paucasesnoves.lloguerjocs.logica.ExcepcioLloguer;
import cat.paucasesnoves.lloguerjocs.logica.LogicaNegoci;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class DialegRegistrarLloguer extends javax.swing.JDialog {

    private ResourceBundle textos = ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private List<Usuari> usuaris = LogicaNegoci.getUsuaris();
    private List<Joc> jocs = LogicaNegoci.getJocs();
    private Plataforma[] plataformes = Plataforma.values();
    private JRadioButton[] radios;
    private JLabel[] etiquetesDisponibles;
    private JLabel[] etiquetesUnitats;

    public DialegRegistrarLloguer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        radios = new JRadioButton[]{jRadioButtonPs5, jRadioButtonSwitch2, jRadioButtonXbox, jRadioButtonPc};
        etiquetesDisponibles = new JLabel[]{jLabelDisponiblesPs5, jLabelDisponiblesSwitch2, jLabelDisponiblesXbox, jLabelDisponiblesPc};
        etiquetesUnitats = new JLabel[]{jLabelValorUnitatsPs5, jLabelValorUnitatsSwitch2, jLabelValorUnitatsXbox, jLabelValorUnitatsPc};
        for (Usuari usuari : usuaris) {
            jComboBoxUsuari.addItem(usuari.toString());
        }
        for (Joc joc : jocs) {
            jComboBoxJoc.addItem(joc.getTitol());
        }
        Calendar calendari = Calendar.getInstance();
        jTextFieldNumero.setText(String.format("%02d", LogicaNegoci.getSeguentNumero()));
        jTextFieldDataInici.setText(sdf.format(calendari.getTime()));
        calendari.add(Calendar.DAY_OF_MONTH, Lloguer.DIES_LLOGUER);
        jTextFieldDataTornada.setText(sdf.format(calendari.getTime()));
        actualitzarPlataformes();
        setLocationRelativeTo(parent);
    }

    public void preseleccionar(Usuari usuari, Joc joc) {
        jComboBoxUsuari.setSelectedIndex(usuaris.indexOf(usuari));
        jComboBoxJoc.setSelectedIndex(jocs.indexOf(joc));
        actualitzarPlataformes();
    }

    private Joc getJocSeleccionat() {
        int index = jComboBoxJoc.getSelectedIndex();
        return index == -1 ? null : jocs.get(index);
    }

    private Usuari getUsuariSeleccionat() {
        int index = jComboBoxUsuari.getSelectedIndex();
        return index == -1 ? null : usuaris.get(index);
    }

    private Plataforma getPlataformaSeleccionada() {
        for (int i = 0; i < radios.length; i++) {
            if (radios[i].isSelected() && radios[i].isEnabled()) {
                return plataformes[i];
            }
        }
        return null;
    }

    private void actualitzarPlataformes() {
        Joc joc = getJocSeleccionat();
        buttonGroupPlataformes.clearSelection();
        boolean primerSeleccionat = false;
        for (int i = 0; i < plataformes.length; i++) {
            int disponibles = joc == null ? 0 : joc.getUnitatsDisponibles(plataformes[i]);
            radios[i].setEnabled(disponibles > 0);
            etiquetesDisponibles[i].setEnabled(disponibles > 0);
            if (joc == null || !joc.teLaPlataforma(plataformes[i])) {
                etiquetesDisponibles[i].setText(textos.getString("DialegRegistrarLloguer.noDisponible"));
                etiquetesUnitats[i].setText("-");
            } else {
                etiquetesDisponibles[i].setText(MessageFormat.format(textos.getString("DialegRegistrarLloguer.unitatsDisponibles"), disponibles));
                etiquetesUnitats[i].setText(disponibles + " / " + joc.getUnitatsTotals(plataformes[i]));
            }
            if (disponibles > 0 && !primerSeleccionat) {
                radios[i].setSelected(true);
                primerSeleccionat = true;
            }
        }
        if (joc == null) {
            jLabelValorGenere.setText("-");
        } else {
            jLabelValorGenere.setText(textos.getString(joc.getGenere().getClau()));
        }
        if (joc != null && !primerSeleccionat) {
            jLabelAvis.setText(textos.getString("DialegRegistrarLloguer.senseEstoc"));
        } else {
            jLabelAvis.setText(" ");
        }
        actualitzarBotoConfirmar();
    }

    private void actualitzarBotoConfirmar() {
        jButtonConfirmar.setEnabled(getUsuariSeleccionat() != null && getJocSeleccionat() != null
                && getPlataformaSeleccionada() != null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupPlataformes = new javax.swing.ButtonGroup();
        jPanelDades = new javax.swing.JPanel();
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabelUsuari = new javax.swing.JLabel();
        jComboBoxUsuari = new javax.swing.JComboBox<>();
        jButtonSeleccionarUsuari = new javax.swing.JButton();
        jLabelJoc = new javax.swing.JLabel();
        jComboBoxJoc = new javax.swing.JComboBox<>();
        jButtonSeleccionarJoc = new javax.swing.JButton();
        jLabelDataInici = new javax.swing.JLabel();
        jTextFieldDataInici = new javax.swing.JTextField();
        jLabelDataTornada = new javax.swing.JLabel();
        jTextFieldDataTornada = new javax.swing.JTextField();
        jPanelPlataforma = new javax.swing.JPanel();
        jRadioButtonPs5 = new javax.swing.JRadioButton();
        jLabelDisponiblesPs5 = new javax.swing.JLabel();
        jRadioButtonSwitch2 = new javax.swing.JRadioButton();
        jLabelDisponiblesSwitch2 = new javax.swing.JLabel();
        jRadioButtonXbox = new javax.swing.JRadioButton();
        jLabelDisponiblesXbox = new javax.swing.JLabel();
        jRadioButtonPc = new javax.swing.JRadioButton();
        jLabelDisponiblesPc = new javax.swing.JLabel();
        jLabelAvis = new javax.swing.JLabel();
        jPanelInfo = new javax.swing.JPanel();
        jLabelGenere = new javax.swing.JLabel();
        jLabelValorGenere = new javax.swing.JLabel();
        jLabelUnitats = new javax.swing.JLabel();
        jLabelUnitatsPs5 = new javax.swing.JLabel();
        jLabelValorUnitatsPs5 = new javax.swing.JLabel();
        jLabelUnitatsSwitch2 = new javax.swing.JLabel();
        jLabelValorUnitatsSwitch2 = new javax.swing.JLabel();
        jLabelUnitatsXbox = new javax.swing.JLabel();
        jLabelValorUnitatsXbox = new javax.swing.JLabel();
        jLabelUnitatsPc = new javax.swing.JLabel();
        jLabelValorUnitatsPc = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancellar = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle(bundle.getString("DialegRegistrarLloguer.title"));

        jPanelDades.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("DialegRegistrarLloguer.jPanelDades.border.title")));

        jLabelNumero.setText(bundle.getString("DialegRegistrarLloguer.jLabelNumero.text"));

        jTextFieldNumero.setEditable(false);
        jTextFieldNumero.setEnabled(false);

        jLabelUsuari.setText(bundle.getString("DialegRegistrarLloguer.jLabelUsuari.text"));

        jComboBoxUsuari.addItemListener(this::jComboBoxUsuariItemStateChanged);

        jButtonSeleccionarUsuari.setText(bundle.getString("DialegRegistrarLloguer.jButtonSeleccionarUsuari.text"));
        jButtonSeleccionarUsuari.addActionListener(this::jButtonSeleccionarUsuariActionPerformed);

        jLabelJoc.setText(bundle.getString("DialegRegistrarLloguer.jLabelJoc.text"));

        jComboBoxJoc.addItemListener(this::jComboBoxJocItemStateChanged);

        jButtonSeleccionarJoc.setText(bundle.getString("DialegRegistrarLloguer.jButtonSeleccionarJoc.text"));
        jButtonSeleccionarJoc.addActionListener(this::jButtonSeleccionarJocActionPerformed);

        jLabelDataInici.setText(bundle.getString("DialegRegistrarLloguer.jLabelDataInici.text"));

        jTextFieldDataInici.setEditable(false);
        jTextFieldDataInici.setEnabled(false);

        jLabelDataTornada.setText(bundle.getString("DialegRegistrarLloguer.jLabelDataTornada.text"));

        jTextFieldDataTornada.setEditable(false);
        jTextFieldDataTornada.setEnabled(false);

        javax.swing.GroupLayout jPanelDadesLayout = new javax.swing.GroupLayout(jPanelDades);
        jPanelDades.setLayout(jPanelDadesLayout);
        jPanelDadesLayout.setHorizontalGroup(
            jPanelDadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadesLayout.createSequentialGroup()
                        .addComponent(jLabelNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                    .addComponent(jLabelUsuari)
                    .addGroup(jPanelDadesLayout.createSequentialGroup()
                        .addComponent(jComboBoxUsuari, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSeleccionarUsuari))
                    .addComponent(jLabelJoc)
                    .addGroup(jPanelDadesLayout.createSequentialGroup()
                        .addComponent(jComboBoxJoc, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSeleccionarJoc))
                    .addComponent(jLabelDataInici)
                    .addComponent(jTextFieldDataInici, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDataTornada)
                    .addComponent(jTextFieldDataTornada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelDadesLayout.setVerticalGroup(
            jPanelDadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelUsuari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSeleccionarUsuari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelJoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxJoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSeleccionarJoc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDataInici)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDataInici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDataTornada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDataTornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelPlataforma.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("DialegRegistrarLloguer.jPanelPlataforma.border.title")));

        buttonGroupPlataformes.add(jRadioButtonPs5);
        jRadioButtonPs5.setText(bundle.getString("DialegRegistrarLloguer.jRadioButtonPs5.text"));
        jRadioButtonPs5.addActionListener(this::jRadioButtonPs5ActionPerformed);

        jLabelDisponiblesPs5.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDisponiblesPs5.setText(bundle.getString("DialegRegistrarLloguer.jLabelDisponiblesPs5.text"));

        buttonGroupPlataformes.add(jRadioButtonSwitch2);
        jRadioButtonSwitch2.setText(bundle.getString("DialegRegistrarLloguer.jRadioButtonSwitch2.text"));
        jRadioButtonSwitch2.addActionListener(this::jRadioButtonSwitch2ActionPerformed);

        jLabelDisponiblesSwitch2.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDisponiblesSwitch2.setText(bundle.getString("DialegRegistrarLloguer.jLabelDisponiblesSwitch2.text"));

        buttonGroupPlataformes.add(jRadioButtonXbox);
        jRadioButtonXbox.setText(bundle.getString("DialegRegistrarLloguer.jRadioButtonXbox.text"));
        jRadioButtonXbox.addActionListener(this::jRadioButtonXboxActionPerformed);

        jLabelDisponiblesXbox.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDisponiblesXbox.setText(bundle.getString("DialegRegistrarLloguer.jLabelDisponiblesXbox.text"));

        buttonGroupPlataformes.add(jRadioButtonPc);
        jRadioButtonPc.setText(bundle.getString("DialegRegistrarLloguer.jRadioButtonPc.text"));
        jRadioButtonPc.addActionListener(this::jRadioButtonPcActionPerformed);

        jLabelDisponiblesPc.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDisponiblesPc.setText(bundle.getString("DialegRegistrarLloguer.jLabelDisponiblesPc.text"));

        jLabelAvis.setForeground(new java.awt.Color(180, 40, 40));
        jLabelAvis.setText(bundle.getString("DialegRegistrarLloguer.jLabelAvis.text"));

        javax.swing.GroupLayout jPanelPlataformaLayout = new javax.swing.GroupLayout(jPanelPlataforma);
        jPanelPlataforma.setLayout(jPanelPlataformaLayout);
        jPanelPlataformaLayout.setHorizontalGroup(
            jPanelPlataformaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlataformaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPlataformaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPlataformaLayout.createSequentialGroup()
                        .addGroup(jPanelPlataformaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonPs5)
                            .addComponent(jRadioButtonSwitch2)
                            .addComponent(jRadioButtonXbox)
                            .addComponent(jRadioButtonPc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPlataformaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisponiblesPs5)
                            .addComponent(jLabelDisponiblesSwitch2)
                            .addComponent(jLabelDisponiblesXbox)
                            .addComponent(jLabelDisponiblesPc)))
                    .addComponent(jLabelAvis))
                .addContainerGap())
        );
        jPanelPlataformaLayout.setVerticalGroup(
            jPanelPlataformaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlataformaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPlataformaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonPs5)
                    .addComponent(jLabelDisponiblesPs5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPlataformaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonSwitch2)
                    .addComponent(jLabelDisponiblesSwitch2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPlataformaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonXbox)
                    .addComponent(jLabelDisponiblesXbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPlataformaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonPc)
                    .addComponent(jLabelDisponiblesPc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAvis)
                .addContainerGap())
        );

        jPanelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("DialegRegistrarLloguer.jPanelInfo.border.title")));

        jLabelGenere.setText(bundle.getString("DialegRegistrarLloguer.jLabelGenere.text"));

        jLabelValorGenere.setFont(jLabelValorGenere.getFont().deriveFont(jLabelValorGenere.getFont().getStyle() | java.awt.Font.BOLD));
        jLabelValorGenere.setText(bundle.getString("DialegRegistrarLloguer.jLabelValorGenere.text"));

        jLabelUnitats.setText(bundle.getString("DialegRegistrarLloguer.jLabelUnitats.text"));

        jLabelUnitatsPs5.setText(bundle.getString("DialegRegistrarLloguer.jLabelUnitatsPs5.text"));

        jLabelValorUnitatsPs5.setFont(jLabelValorUnitatsPs5.getFont().deriveFont(jLabelValorUnitatsPs5.getFont().getStyle() | java.awt.Font.BOLD));
        jLabelValorUnitatsPs5.setText(bundle.getString("DialegRegistrarLloguer.jLabelValorUnitatsPs5.text"));

        jLabelUnitatsSwitch2.setText(bundle.getString("DialegRegistrarLloguer.jLabelUnitatsSwitch2.text"));

        jLabelValorUnitatsSwitch2.setFont(jLabelValorUnitatsSwitch2.getFont().deriveFont(jLabelValorUnitatsSwitch2.getFont().getStyle() | java.awt.Font.BOLD));
        jLabelValorUnitatsSwitch2.setText(bundle.getString("DialegRegistrarLloguer.jLabelValorUnitatsSwitch2.text"));

        jLabelUnitatsXbox.setText(bundle.getString("DialegRegistrarLloguer.jLabelUnitatsXbox.text"));

        jLabelValorUnitatsXbox.setFont(jLabelValorUnitatsXbox.getFont().deriveFont(jLabelValorUnitatsXbox.getFont().getStyle() | java.awt.Font.BOLD));
        jLabelValorUnitatsXbox.setText(bundle.getString("DialegRegistrarLloguer.jLabelValorUnitatsXbox.text"));

        jLabelUnitatsPc.setText(bundle.getString("DialegRegistrarLloguer.jLabelUnitatsPc.text"));

        jLabelValorUnitatsPc.setFont(jLabelValorUnitatsPc.getFont().deriveFont(jLabelValorUnitatsPc.getFont().getStyle() | java.awt.Font.BOLD));
        jLabelValorUnitatsPc.setText(bundle.getString("DialegRegistrarLloguer.jLabelValorUnitatsPc.text"));

        javax.swing.GroupLayout jPanelInfoLayout = new javax.swing.GroupLayout(jPanelInfo);
        jPanelInfo.setLayout(jPanelInfoLayout);
        jPanelInfoLayout.setHorizontalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoLayout.createSequentialGroup()
                        .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelGenere))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelValorGenere)))
                    .addComponent(jLabelUnitats)
                    .addGroup(jPanelInfoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUnitatsPs5)
                            .addComponent(jLabelUnitatsSwitch2)
                            .addComponent(jLabelUnitatsXbox)
                            .addComponent(jLabelUnitatsPc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelValorUnitatsPs5)
                            .addComponent(jLabelValorUnitatsSwitch2)
                            .addComponent(jLabelValorUnitatsXbox)
                            .addComponent(jLabelValorUnitatsPc))))
                .addContainerGap())
        );
        jPanelInfoLayout.setVerticalGroup(
            jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGenere)
                    .addComponent(jLabelValorGenere))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUnitats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUnitatsPs5)
                    .addComponent(jLabelValorUnitatsPs5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUnitatsSwitch2)
                    .addComponent(jLabelValorUnitatsSwitch2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUnitatsXbox)
                    .addComponent(jLabelValorUnitatsXbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUnitatsPc)
                    .addComponent(jLabelValorUnitatsPc))
                .addContainerGap())
        );

        jButtonConfirmar.setBackground(new java.awt.Color(86, 150, 86));
        jButtonConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/confirmar.png")));
        jButtonConfirmar.setText(bundle.getString("DialegRegistrarLloguer.jButtonConfirmar.text"));
        jButtonConfirmar.addActionListener(this::jButtonConfirmarActionPerformed);

        jButtonCancellar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cat/paucasesnoves/lloguerjocs/imatges/cancellar.png")));
        jButtonCancellar.setText(bundle.getString("DialegRegistrarLloguer.jButtonCancellar.text"));
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
                            .addComponent(jPanelDades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelPlataforma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancellar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxUsuariItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxUsuariItemStateChanged
        if (radios != null) {
            actualitzarBotoConfirmar();
        }
    }//GEN-LAST:event_jComboBoxUsuariItemStateChanged

    private void jComboBoxJocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxJocItemStateChanged
        if (radios != null && evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            actualitzarPlataformes();
        }
    }//GEN-LAST:event_jComboBoxJocItemStateChanged

    private void jButtonSeleccionarUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarUsuariActionPerformed
        List<String> noms = new ArrayList<>();
        for (Usuari usuari : usuaris) {
            noms.add(usuari.getNomComplet() + " (" + usuari.getDni() + ")");
        }
        DialegSeleccio dialeg = new DialegSeleccio(this, true);
        dialeg.setElements(textos.getString("DialegSeleccio.titolUsuari"), noms);
        dialeg.setVisible(true);
        if (dialeg.getIndexSeleccionat() != -1) {
            jComboBoxUsuari.setSelectedIndex(dialeg.getIndexSeleccionat());
        }
    }//GEN-LAST:event_jButtonSeleccionarUsuariActionPerformed

    private void jButtonSeleccionarJocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarJocActionPerformed
        List<String> titols = new ArrayList<>();
        for (Joc joc : jocs) {
            titols.add(joc.getTitol());
        }
        DialegSeleccio dialeg = new DialegSeleccio(this, true);
        dialeg.setElements(textos.getString("DialegSeleccio.titolJoc"), titols);
        dialeg.setVisible(true);
        if (dialeg.getIndexSeleccionat() != -1) {
            jComboBoxJoc.setSelectedIndex(dialeg.getIndexSeleccionat());
        }
    }//GEN-LAST:event_jButtonSeleccionarJocActionPerformed

    private void jRadioButtonPs5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPs5ActionPerformed
        actualitzarBotoConfirmar();
    }//GEN-LAST:event_jRadioButtonPs5ActionPerformed

    private void jRadioButtonSwitch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSwitch2ActionPerformed
        actualitzarBotoConfirmar();
    }//GEN-LAST:event_jRadioButtonSwitch2ActionPerformed

    private void jRadioButtonXboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonXboxActionPerformed
        actualitzarBotoConfirmar();
    }//GEN-LAST:event_jRadioButtonXboxActionPerformed

    private void jRadioButtonPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPcActionPerformed
        actualitzarBotoConfirmar();
    }//GEN-LAST:event_jRadioButtonPcActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        Usuari usuari = getUsuariSeleccionat();
        Joc joc = getJocSeleccionat();
        Plataforma plataforma = getPlataformaSeleccionada();
        try {
            Lloguer lloguer = LogicaNegoci.registrarLloguer(usuari, joc, plataforma);
            String missatge = MessageFormat.format(textos.getString("DialegRegistrarLloguer.registrat"),
                    lloguer.getNumeroFormatat(), joc.getTitol(), plataforma.getNom(), usuari.toString(),
                    sdf.format(lloguer.getDataPrevista()));
            JOptionPane.showMessageDialog(this, missatge, textos.getString("comu.informacio"), JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (ExcepcioLloguer e) {
            JOptionPane.showMessageDialog(this, textos.getString(e.getMessage()), textos.getString("comu.error"), JOptionPane.ERROR_MESSAGE);
            actualitzarPlataformes();
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonCancellarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancellarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancellarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupPlataformes;
    private javax.swing.JButton jButtonCancellar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonSeleccionarJoc;
    private javax.swing.JButton jButtonSeleccionarUsuari;
    private javax.swing.JComboBox<String> jComboBoxJoc;
    private javax.swing.JComboBox<String> jComboBoxUsuari;
    private javax.swing.JLabel jLabelAvis;
    private javax.swing.JLabel jLabelDataInici;
    private javax.swing.JLabel jLabelDataTornada;
    private javax.swing.JLabel jLabelDisponiblesPc;
    private javax.swing.JLabel jLabelDisponiblesPs5;
    private javax.swing.JLabel jLabelDisponiblesSwitch2;
    private javax.swing.JLabel jLabelDisponiblesXbox;
    private javax.swing.JLabel jLabelGenere;
    private javax.swing.JLabel jLabelJoc;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelUnitats;
    private javax.swing.JLabel jLabelUnitatsPc;
    private javax.swing.JLabel jLabelUnitatsPs5;
    private javax.swing.JLabel jLabelUnitatsSwitch2;
    private javax.swing.JLabel jLabelUnitatsXbox;
    private javax.swing.JLabel jLabelUsuari;
    private javax.swing.JLabel jLabelValorGenere;
    private javax.swing.JLabel jLabelValorUnitatsPc;
    private javax.swing.JLabel jLabelValorUnitatsPs5;
    private javax.swing.JLabel jLabelValorUnitatsSwitch2;
    private javax.swing.JLabel jLabelValorUnitatsXbox;
    private javax.swing.JPanel jPanelDades;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelPlataforma;
    private javax.swing.JRadioButton jRadioButtonPc;
    private javax.swing.JRadioButton jRadioButtonPs5;
    private javax.swing.JRadioButton jRadioButtonSwitch2;
    private javax.swing.JRadioButton jRadioButtonXbox;
    private javax.swing.JTextField jTextFieldDataInici;
    private javax.swing.JTextField jTextFieldDataTornada;
    private javax.swing.JTextField jTextFieldNumero;
    // End of variables declaration//GEN-END:variables
}
