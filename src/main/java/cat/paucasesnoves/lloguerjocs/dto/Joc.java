package cat.paucasesnoves.lloguerjocs.dto;

import java.util.HashMap;

public class Joc {

    private String titol;
    private Genere genere;
    private HashMap<Plataforma, Integer> unitatsTotals = new HashMap<>();
    private HashMap<Plataforma, Integer> unitatsDisponibles = new HashMap<>();

    public Joc(String titol, Genere genere) {
        this.titol = titol;
        this.genere = genere;
    }

    public void afegirUnitats(Plataforma plataforma, int unitats) {
        if (unitats > 0) {
            unitatsTotals.put(plataforma, unitats);
            unitatsDisponibles.put(plataforma, unitats);
        }
    }

    public String getTitol() {
        return titol;
    }

    public Genere getGenere() {
        return genere;
    }

    public boolean teLaPlataforma(Plataforma plataforma) {
        return unitatsTotals.containsKey(plataforma);
    }

    public boolean teAlgunaPlataforma() {
        return !unitatsTotals.isEmpty();
    }

    public int getUnitatsTotals(Plataforma plataforma) {
        return unitatsTotals.getOrDefault(plataforma, 0);
    }

    public int getUnitatsDisponibles(Plataforma plataforma) {
        return unitatsDisponibles.getOrDefault(plataforma, 0);
    }

    public void llogarUnitat(Plataforma plataforma) {
        unitatsDisponibles.put(plataforma, getUnitatsDisponibles(plataforma) - 1);
    }

    public void retornarUnitat(Plataforma plataforma) {
        unitatsDisponibles.put(plataforma, getUnitatsDisponibles(plataforma) + 1);
    }

    @Override
    public String toString() {
        return titol;
    }
}
