package com.joaoneto.workshopmongo.dto;

import com.joaoneto.workshopmongo.dominio.Usuario;

import java.io.Serializable;

public class DtoAutor implements Serializable {

    private String id;
    private String nome;

    public DtoAutor() {
    }

    public DtoAutor(Usuario obj) {
        id = obj.getId();
        nome = obj.getNome();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
