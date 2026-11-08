package cat.paucasesnoves.lloguerjocs.dto;

import java.util.Calendar;
import java.util.Date;

public class Lloguer {

    public static final int DIES_LLOGUER = 7;

    private int numero;
    private Usuari usuari;
    private Joc joc;
    private Plataforma plataforma;
    private Date dataInici;
    private Date dataPrevista;
    private Date dataRetorn;

    public Lloguer(int numero, Usuari usuari, Joc joc, Plataforma plataforma, Date dataInici) {
        this.numero = numero;
        this.usuari = usuari;
        this.joc = joc;
        this.plataforma = plataforma;
        this.dataInici = dataInici;
        Calendar calendari = Calendar.getInstance();
        calendari.setTime(dataInici);
        calendari.add(Calendar.DAY_OF_MONTH, DIES_LLOGUER);
        this.dataPrevista = calendari.getTime();
    }

    public int getNumero() {
        return numero;
    }

    public String getNumeroFormatat() {
        return String.format("%02d", numero);
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public Joc getJoc() {
        return joc;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public Date getDataInici() {
        return dataInici;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public Date getDataRetorn() {
        return dataRetorn;
    }

    public void setDataRetorn(Date dataRetorn) {
        this.dataRetorn = dataRetorn;
    }

    public boolean isRetornat() {
        return dataRetorn != null;
    }

    public EstatLloguer getEstat() {
        if (isRetornat()) {
            return EstatLloguer.RETORNAT;
        }
        if (new Date().after(dataPrevista)) {
            return EstatLloguer.FORA_DE_TERMINI;
        }
        return EstatLloguer.ACTIU;
    }
}
