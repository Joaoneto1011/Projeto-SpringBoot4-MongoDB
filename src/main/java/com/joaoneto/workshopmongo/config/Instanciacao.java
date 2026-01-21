package com.joaoneto.workshopmongo.config;

import com.joaoneto.workshopmongo.dominio.Usuario;
import com.joaoneto.workshopmongo.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instanciacao implements CommandLineRunner {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Override
    public void run(String... args) throws Exception {

        repositorioUsuario.deleteAll();

        Usuario maria = new Usuario(null, "Maria Clara", "mariaclara@gmail.com");
        Usuario joao = new Usuario(null, "Joao Neto", "joaoneto@gmail.com");
        Usuario silvania = new Usuario(null, "Silvania Martins", "silvaniamartins@gmail.com");

        repositorioUsuario.saveAll(Arrays.asList(maria, joao, silvania));
    }
}
