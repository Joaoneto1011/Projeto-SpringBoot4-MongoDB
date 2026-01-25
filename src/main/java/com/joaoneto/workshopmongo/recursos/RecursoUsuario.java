package com.joaoneto.workshopmongo.recursos;

import com.joaoneto.workshopmongo.dominio.Usuario;
import com.joaoneto.workshopmongo.dto.DtoUsuario;
import com.joaoneto.workshopmongo.servicos.ServicoUsuario;
import com.joaoneto.workshopmongo.servicos.excecao.ExcecaoParaObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody DtoUsuario objDto) {
        Usuario obj = servico.fromDTO(objDto);
        obj = servico.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        servico.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody DtoUsuario objDto, @PathVariable String id) {
        Usuario obj = servico.fromDTO(objDto);
        obj.setId(id);
        obj = servico.update(obj);
        return ResponseEntity.noContent().build();
    }


}
