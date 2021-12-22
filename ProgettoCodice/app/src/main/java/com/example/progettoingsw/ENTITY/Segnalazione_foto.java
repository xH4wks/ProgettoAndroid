package com.example.progettoingsw.ENTITY;

import android.media.Image;

import com.example.progettoingsw.INTERFACE.Segnalazione;

import java.util.ArrayList;

public class Segnalazione_foto implements Segnalazione {

    private enum motivo{
        nudo_o_atti_sessuali,
        incitamento_all_odio,
        atti_violenti,
        suicidio_e_autolesionismo;
    }
    private String autore;
    private String destinatario;
    private ArrayList<Image> foto;
    private motivo motivo_segnalazione;


    public Segnalazione_foto(String autore, String destinatario, ArrayList<Image> foto, motivo motivo_segnalazione) {
        this.autore = autore;
        this.destinatario = destinatario;
        this.foto = foto;
        this.motivo_segnalazione = motivo_segnalazione;
    }


    @Override
    public void visualizza_segnalazione() {

        //todo implementazione metodo visualizza_segnalazione

    }

    @Override
    public void invia_segnalazione() {

        //todo implementazione metodo invia_segnalazione

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

    public ArrayList<Image> getFoto() {
        return foto;
    }

    public void setFoto(ArrayList<Image> foto) {
        this.foto = foto;
    }

    public motivo getMotivo_segnalazione() {
        return motivo_segnalazione;
    }

    public void setMotivo_segnalazione(motivo motivo_segnalazione) {
        this.motivo_segnalazione = motivo_segnalazione;
    }

}