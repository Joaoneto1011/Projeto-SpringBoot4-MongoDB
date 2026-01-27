package com.joaoneto.workshopmongo.recursos;

import com.joaoneto.workshopmongo.dominio.Post;
import com.joaoneto.workshopmongo.dominio.Usuario;
import com.joaoneto.workshopmongo.dto.DtoUsuario;
import com.joaoneto.workshopmongo.servicos.ServicoPost;
import com.joaoneto.workshopmongo.servicos.ServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class RecursoPost {

    @Autowired
    private ServicoPost servicoPost;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = servicoPost.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
