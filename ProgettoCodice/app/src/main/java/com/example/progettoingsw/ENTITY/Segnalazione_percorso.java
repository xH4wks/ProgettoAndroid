package com.example.progettoingsw.ENTITY;

import com.example.progettoingsw.INTERFACE.Segnalazione;

public class Segnalazione_percorso  implements Segnalazione {

    private enum motivo {
        informazioni_false,
        percorso_non_praticabile,
        assenza_di_luoghi_di_ristoro,
        percorso_non_accessibile_ai_cani,
        percorso_non_accessibile_ai_diversamente_abili,
        descrizione_forviante;
    }
    private String autore;
    private String destinatario;
    private motivo motivo_segnalazione;

    public Segnalazione_percorso(String autore, String destinatario, motivo motivo_segnalazione) {
        this.autore = autore;
        this.destinatario = destinatario;
        this.motivo_segnalazione = motivo_segnalazione;
    }

    @Override
    public void visualizza_segnalazione() {

        //todo

    }

    @Override
    public void invia_segnalazione() {

        //todo

    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public motivo getMotivo_segnalazione() {
        return motivo_segnalazione;
    }

    public void setMotivo_segnalazione(motivo motivo_segnalazione) {
        this.motivo_segnalazione = motivo_segnalazione;
    }

}
