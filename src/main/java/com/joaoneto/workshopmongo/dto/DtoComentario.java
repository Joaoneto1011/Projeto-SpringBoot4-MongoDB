package com.joaoneto.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class DtoComentario implements Serializable {

    private String texto;
    private Date data;
    private DtoAutor autor;

    public DtoComentario() {
    }

    public DtoComentario(String texto, Date data, DtoAutor autor) {
        this.texto = texto;
        this.data = data;
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public DtoAutor getAutor() {
        return autor;
    }

    public void setAutor(DtoAutor autor) {
        this.autor = autor;
    }
}
