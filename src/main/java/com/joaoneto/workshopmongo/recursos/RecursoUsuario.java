package com.joaoneto.workshopmongo.recursos;

import com.joaoneto.workshopmongo.dominio.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class RecursoUsuario {

    @GetMapping
    public ResponseEntity<List<Usuario>> encontrarTudo() {
        Usuario joao = new Usuario("1", "Joao Neto", "joaoneto@gmail.com");
        Usuario maria = new Usuario("2", "Maria Clara", "mariaclara@gmail.com");
        List<Usuario> list = new ArrayList<>();
        list.addAll(Arrays.asList(joao, maria));
        return ResponseEntity.ok().body(list);
    }
}
