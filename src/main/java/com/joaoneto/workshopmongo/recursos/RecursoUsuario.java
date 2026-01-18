package com.joaoneto.workshopmongo.recursos;

import com.joaoneto.workshopmongo.dominio.Usuario;
import com.joaoneto.workshopmongo.servicos.ServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ServicoUsuario servico;

    @GetMapping
    public ResponseEntity<List<Usuario>> encontrarTudo() {
        List<Usuario> list = servico.encontrarTudo();
        return ResponseEntity.ok().body(list);
    }
}
