package cat.paucasesnoves.lloguerjocs.interficie.models;

import cat.paucasesnoves.lloguerjocs.dto.Usuari;
import cat.paucasesnoves.lloguerjocs.logica.LogicaNegoci;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

public class ModelTaulaUsuaris extends AbstractTableModel {

    private List<Usuari> llistaUsuaris;
    private ResourceBundle textos = ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String[] columnes = {"taula.nomComplet", "taula.dni", "taula.telefon", "taula.dataRegistre", "taula.lloguersActius"};

    public ModelTaulaUsuaris(List<Usuari> llistaUsuaris) {
        this.llistaUsuaris = llistaUsuaris;
    }

    public Usuari getUsuari(int fila) {
        return llistaUsuaris.get(fila);
    }

    @Override
    public int getRowCount() {
        return llistaUsuaris.size();
    }

    @Override
    public int getColumnCount() {
        return columnes.length;
    }

    @Override
    public String getColumnName(int columna) {
        return textos.getString(columnes[columna]);
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Usuari usuari = llistaUsuaris.get(fila);
        switch (columna) {
            case 0:
                return usuari.getNomComplet();
            case 1:
                return usuari.getDni();
            case 2:
                return usuari.getTelefon();
            case 3:
                return sdf.format(usuari.getDataRegistre());
            case 4:
                return LogicaNegoci.comptarLloguersActius(usuari);
            default:
                return null;
        }
    }
}
