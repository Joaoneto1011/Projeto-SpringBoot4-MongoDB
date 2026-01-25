package com.joaoneto.workshopmongo.recursos;

import com.joaoneto.workshopmongo.dominio.Usuario;
import com.joaoneto.workshopmongo.dto.DtoUsuario;
import com.joaoneto.workshopmongo.servicos.ServicoUsuario;
import com.joaoneto.workshopmongo.servicos.excecao.ExcecaoParaObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class RecursoUsuario {

    @Autowired
    private ServicoUsuario servico;

    @GetMapping
    public ResponseEntity<List<DtoUsuario>> findAll() {
        List<Usuario> list = servico.findAll();
        List<DtoUsuario> listDto = list.stream().map(x -> new DtoUsuario(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DtoUsuario> findById(@PathVariable String id) {
        Usuario obj = servico.findById(id);
        return ResponseEntity.ok().body(new DtoUsuario(obj));
    }
}
