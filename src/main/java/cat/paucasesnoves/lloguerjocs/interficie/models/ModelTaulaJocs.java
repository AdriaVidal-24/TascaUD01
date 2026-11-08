package cat.paucasesnoves.lloguerjocs.interficie.models;

import cat.paucasesnoves.lloguerjocs.dto.Joc;
import cat.paucasesnoves.lloguerjocs.dto.Plataforma;
import cat.paucasesnoves.lloguerjocs.logica.LogicaNegoci;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

public class ModelTaulaJocs extends AbstractTableModel {

    private List<Joc> llistaJocs;
    private ResourceBundle textos = ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
    private Plataforma[] plataformes = Plataforma.values();

    public ModelTaulaJocs(List<Joc> llistaJocs) {
        this.llistaJocs = llistaJocs;
    }

    public Joc getJoc(int fila) {
        return llistaJocs.get(fila);
    }

    @Override
    public int getRowCount() {
        return llistaJocs.size();
    }

    @Override
    public int getColumnCount() {
        return plataformes.length + 3;
    }

    @Override
    public String getColumnName(int columna) {
        if (columna == 0) {
            return textos.getString("taula.titol");
        } else if (columna == 1) {
            return textos.getString("taula.genere");
        } else if (columna == getColumnCount() - 1) {
            return textos.getString("taula.lloguersActius");
        }
        return plataformes[columna - 2].getNom();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Joc joc = llistaJocs.get(fila);
        if (columna == 0) {
            return joc.getTitol();
        } else if (columna == 1) {
            return textos.getString(joc.getGenere().getClau());
        } else if (columna == getColumnCount() - 1) {
            return LogicaNegoci.comptarLloguersActius(joc);
        }
        Plataforma plataforma = plataformes[columna - 2];
        if (!joc.teLaPlataforma(plataforma)) {
            return "-";
        }
        return joc.getUnitatsDisponibles(plataforma) + " / " + joc.getUnitatsTotals(plataforma);
    }
}
