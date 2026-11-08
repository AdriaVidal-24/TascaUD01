package cat.paucasesnoves.lloguerjocs.interficie.models;

import cat.paucasesnoves.lloguerjocs.dto.EstatLloguer;
import cat.paucasesnoves.lloguerjocs.dto.Lloguer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderitzadorEstat extends DefaultTableCellRenderer {

    private static final Color VERD = new Color(198, 239, 206);
    private static final Color VERMELL = new Color(255, 199, 206);

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Component cella = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (isSelected) {
            return cella;
        }
        ModelTaulaLloguers model = (ModelTaulaLloguers) table.getModel();
        Lloguer lloguer = model.getLloguer(row);
        if (lloguer.getEstat() == EstatLloguer.RETORNAT) {
            cella.setBackground(VERD);
        } else if (lloguer.getEstat() == EstatLloguer.FORA_DE_TERMINI) {
            cella.setBackground(VERMELL);
        } else {
            cella.setBackground(Color.WHITE);
        }
        return cella;
    }
}
