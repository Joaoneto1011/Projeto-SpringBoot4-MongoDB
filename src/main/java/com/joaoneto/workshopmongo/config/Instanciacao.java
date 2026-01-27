package com.joaoneto.workshopmongo.config;

import com.joaoneto.workshopmongo.dominio.Post;
import com.joaoneto.workshopmongo.dominio.Usuario;
import com.joaoneto.workshopmongo.repositorios.RepositorioPost;
import com.joaoneto.workshopmongo.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instanciacao implements CommandLineRunner {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Autowired
    private RepositorioPost repositorioPost;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repositorioUsuario.deleteAll();
        repositorioPost.deleteAll();

        Usuario maria = new Usuario(null, "Maria Clara", "mariaclara@gmail.com");
        Usuario joao = new Usuario(null, "Joao Neto", "joaoneto@gmail.com");
        Usuario silvania = new Usuario(null, "Silvania Martins", "silvaniamartins@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2025"), "Partiu viagem", "Vou viajar para Sao Paulo. Abraços!", maria );
        Post post2 = new Post(null, sdf.parse("23/03/2025"), "Bom dia", "Acordei feliz hoje!", maria);

        repositorioUsuario.saveAll(Arrays.asList(maria, joao, silvania));
        repositorioPost.saveAll(Arrays.asList(post1, post2));
    }
}
