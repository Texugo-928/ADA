package br.com.ada.crud.model.estado;

import java.io.Serializable;
import java.util.UUID;

public class Estado implements Serializable {

    public static final long serialVersionUID = 1l;

    private UUID id;
    private String nome;
    private String sigla;
    private String paisSigla;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla.toUpperCase();
    }

    public String getPaisSigla() {
        return paisSigla;
    }

    public void setPaisSigla(String paisSigla) {
        this.paisSigla = paisSigla.toUpperCase();
    }
}