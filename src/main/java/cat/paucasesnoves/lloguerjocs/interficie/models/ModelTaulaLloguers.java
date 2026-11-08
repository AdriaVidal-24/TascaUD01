package cat.paucasesnoves.lloguerjocs.interficie.models;

import cat.paucasesnoves.lloguerjocs.dto.Lloguer;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.table.AbstractTableModel;

public class ModelTaulaLloguers extends AbstractTableModel {

    private List<Lloguer> llistaLloguers;
    private ResourceBundle textos = ResourceBundle.getBundle("cat/paucasesnoves/lloguerjocs/interficie/Bundle");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String[] columnes = {"taula.numero", "taula.joc", "taula.usuari", "taula.plataforma",
        "taula.dataInici", "taula.dataPrevista", "taula.genere", "taula.estat"};

    public ModelTaulaLloguers(List<Lloguer> llistaLloguers) {
        this.llistaLloguers = llistaLloguers;
    }

    public Lloguer getLloguer(int fila) {
        return llistaLloguers.get(fila);
    }

    @Override
    public int getRowCount() {
        return llistaLloguers.size();
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
        Lloguer lloguer = llistaLloguers.get(fila);
        switch (columna) {
            case 0:
                return lloguer.getNumeroFormatat();
            case 1:
                return lloguer.getJoc().getTitol();
            case 2:
                return lloguer.getUsuari().toString();
            case 3:
                return lloguer.getPlataforma().getNom();
            case 4:
                return sdf.format(lloguer.getDataInici());
            case 5:
                return sdf.format(lloguer.getDataPrevista());
            case 6:
                return textos.getString(lloguer.getJoc().getGenere().getClau());
            case 7:
                return textos.getString(lloguer.getEstat().getClau());
            default:
                return null;
        }
    }
}
